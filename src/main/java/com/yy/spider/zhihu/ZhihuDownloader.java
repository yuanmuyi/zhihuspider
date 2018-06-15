package com.yy.spider.zhihu;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.downloader.HttpClientDownloader;

import java.util.Map;

/**
 * @author yuanyang
 * @Description:
 * @date 2018/6/12 16:17
 */
public class ZhihuDownloader extends HttpClientDownloader {

    private ZhihuSpider zhihuSpider = null;

    public ZhihuDownloader(ZhihuSpider zhihuSpider) {
        this.zhihuSpider = zhihuSpider;
    }

    @Override
    public Page download(Request request, Task task) {
        zhihuSpider.setSite();
        Map<String,String> cookie=zhihuSpider.getSite().getCookies();
        request.addCookie("z_c0",cookie.get("z_c0"));
        return super.download(request, task);

    }
}
