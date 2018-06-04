package com.yy.service.spider;

import com.yy.spider.pipeline.EsPipeline;
import com.yy.spider.processor.ZhihuPageProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.scheduler.FileCacheQueueScheduler;

/**
 * @author yuanyang
 * @Description:爬虫实现类
 * @date 2018/6/1 11:13
 */
@Service
public class SpiderServiceImpl implements SpiderService {

    @Autowired
    private EsPipeline esPipeline;
    @Override
    public void spiderStart(String url) {
        Spider.create(new ZhihuPageProcessor())
                .addUrl(url)
                // 设置Scheduler，使用File来管理URL队列, 可以去重爬取
                .setScheduler(new FileCacheQueueScheduler("/spider/logs/queue"))
                .addPipeline(esPipeline)
                .thread(3)
                .run();
    }

    public static void main(String[] args) {
        SpiderServiceImpl spiderService = new SpiderServiceImpl();
        spiderService.spiderStart("https://www.zhihu.com/people/lu-jia-1-62/activities");
    }
}
