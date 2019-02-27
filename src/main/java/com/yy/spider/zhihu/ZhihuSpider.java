package com.yy.spider.zhihu;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author yuanyang
 * @Description:
 * @date 2018/6/12 16:15
 */
public class ZhihuSpider extends Spider {

    private Random random = new Random();

    private Integer flag = -1;

    private Long t = 0L;

    /**
     *1858,1878,1838,181,199405899602,19940583297
     */
    private List<String> cookies = Arrays.asList("2|1:0|10:1542766871|4:z_c0|92:Mi4xZHUtT0F3QUFBQUFBa0M2dWoyeU9EU1lBQUFCZ0FsVk5GZ19pWEFEVEZMZVU5bVlpbTRLa0lQS2ZLd0dfcFV3MlN3|33738b7ef2bbe87dab59daf1c0ec7803b6a479e4d94326f6e34fe8def1706a66");

    public ZhihuSpider(PageProcessor pageProcessor) {
        super(pageProcessor);
    }

    public void setSite() {
        //随机休眠时间减少被封风险
        site.setSleepTime(2000 + random.nextInt(3000));
        int num = 100;
        if (++flag % num == 0) {
            System.out.println("抓取100个帐号耗时:"+ (System.currentTimeMillis()-t)/1000 + "ms");
            t = System.currentTimeMillis();
            int position = flag / num;
            if (position == cookies.size() - 1) {
                flag = -num;
            }
            //爬取num个页面后切换账号
            site.addCookie("z_c0", cookies.get(position));
            System.out.println("Account number: " + position);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }
}
