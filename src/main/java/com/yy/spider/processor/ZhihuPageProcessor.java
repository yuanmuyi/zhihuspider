package com.yy.spider.processor;

import com.yy.common.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yuanyang
 * @Description:知乎页面处理
 * @date 2018/5/31 17:37
 */
public class ZhihuPageProcessor implements PageProcessor {

    private final String[] sex = { "未知", "女", "男" };

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static Site site = Site.me().setRetryTimes(3).setUserAgent(
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36")
            .setCharset("UTF-8").addHeader("Host", "www.zhihu.com").setTimeOut(10000)
            .addHeader("Referer", "https://www.zhihu.com/")
            .addCookie("_xsrf", "41770e04-fcb4-4460-8739-6ad17a8198dd")
            .addCookie("_zap", "bf620a96-84a9-49e3-b620-c7a545ca6e3f")
            .addCookie("z_c0", "2|1:0|10:1528117259|4:z_c0|92:Mi4xZHUtT0F3QUFBQUFBMEdHOEMtdWxEU1lBQUFCZ0FsVk5DNFlDWEFBbUZXanptdk1qX3lxeHZ6U1NLR2lpczZ0cHZR|f47e51cc8761c95e75213ee0279a055ca32df890f36567d4b64ef73ae5bd6d23")
            .addCookie("__utmc", "155987696");

    private void setJsonInfo(Page page) {
        Map<String,Object> result = new HashMap<>(16);

        String id = page.getUrl().regex("people/(.*?)/", 1).get();
        String temp = page.getHtml().css("div#data").regex("datString id = page.getUrl().regex(\"people/(.*?)/\", 1).get();a-state=\"(.*?)\"", 1).get();
        if (temp == null) {
            logger.info("The home page of " + id + " is not available.");
            return;// 无法获取该用户主页
        }
        // 替换转义字符
        temp = temp.replace("&quot;", "\"").replace("&lt;", "<").replace("&gt;", ">");
        Json json = new Json(temp);
        String test = json.jsonPath("$..users['" + id + "']").get();
        if (test == null) {
            logger.info("The home page of " + id + " is not available.");
            return;// 该用户账号被封禁
        }
        Json userJson = new Json(test);

        // 采用JsonPath抽取用户个人信息
        result.put("id",id);
        result.put("name",userJson.jsonPath("$.name").get());
        result.put("sex",sex[Integer.valueOf(userJson.jsonPath("$.gender").get()) + 1]);
        result.put("introduction",userJson.jsonPath("$.headline").get());
        result.put("school",userJson.jsonPath("$.educations[*].school.name").get());
        result.put("company",userJson.jsonPath("$.employments[*].company.name").get());
        result.put("job",userJson.jsonPath("$.employments[*].job.name").get());
        if (userJson.regex("\"business\":\\{").match()) {
            result.put("business",userJson.jsonPath("$.business.name").get());
        }
        result.put("location",userJson.jsonPath("$.locations[*].name").get());
        result.put("answer",userJson.jsonPath("$.answerCount").get());
        result.put("agree",userJson.jsonPath("$.voteupCount").get());
        result.put("follower",userJson.jsonPath("$.followerCount").get());

        page.putField(Constant.RESULT_LIST_MAP, result);
    }

    private String getAPI(String url) {
        // 获取关注列表
        return url.replace("https://www.zhihu.com/people", "https://www.zhihu.com/api/v4/members").replace("activities",
                "followees?offset=0&limit=20");
    }

    @Override
    public void process(Page page) {
        if (page.getHtml().css("div.Unhuman").match()) {
            // 账号/ip被封,终止程序
            System.out.println("banned!!!");
            logger.error("Account has been banned!");
            System.exit(1);
        }

        if (page.getStatusCode() != 200) {
            System.out.println(page.getStatusCode());
        }

        if (page.getUrl().regex("/api/v4/members").match()) {
            List<String> urls = page.getJson().jsonPath("$.data[*].url_token").all();
            for (String url : urls) {
                page.addTargetRequest("https://www.zhihu.com/people/" + url + "/activities");
            }
        } else {
            String url = getAPI(page.getUrl().get());
            page.addTargetRequest(url);
            setJsonInfo(page);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        String url = "https://www.zhihu.com/people/excited-vczh/activities";
        System.out.println(url.replace("https://www.zhihu.com/people", "https://www.zhihu.com/api/v4/members"));
    }
}
