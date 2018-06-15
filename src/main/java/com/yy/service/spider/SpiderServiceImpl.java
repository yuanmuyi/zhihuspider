package com.yy.service.spider;

import com.yy.dao.es.EsOperatorDao;
import com.yy.spider.zhihu.EsPipeline;
import com.yy.spider.zhihu.ZhihuDownloader;
import com.yy.spider.zhihu.ZhihuPageProcessor;
import com.yy.spider.zhihu.ZhihuSpider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    @Autowired
    private EsOperatorDao esOperatorDao;

    @Override
    public void spiderStart(String url) {
        ZhihuSpider spider = new ZhihuSpider(new ZhihuPageProcessor());
        spider.addUrl(url)
                .setDownloader(new ZhihuDownloader(spider))
              .setScheduler(new FileCacheQueueScheduler("/spider/logs/queue"))
              .addPipeline(esPipeline)
              .thread(12);
        spider.run();
    }

}
