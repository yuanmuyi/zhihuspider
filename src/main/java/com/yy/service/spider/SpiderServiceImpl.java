package com.yy.service.spider;

import com.yy.common.QueueManager;
import com.yy.common.enums.EsIndexAndTypeEnum;
import com.yy.dao.es.EsOperatorDao;
import com.yy.spider.zhihu.EsPipeline;
import com.yy.spider.zhihu.ZhihuDownloader;
import com.yy.spider.zhihu.ZhihuPageProcessor;
import com.yy.spider.zhihu.ZhihuSpider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.scheduler.FileCacheQueueScheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yuanyang
 * @Description:爬虫实现类
 * @date 2018/6/1 11:13
 */
@Service
public class SpiderServiceImpl implements SpiderService {

    private static final Logger log = LoggerFactory.getLogger(SpiderServiceImpl.class);
    @Autowired
    private EsPipeline esPipeline;

    @Autowired
    private EsOperatorDao esOperatorDao;

    private ExecutorService dataThread = new ThreadPoolExecutor(1,1,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());

    @Override
    public void spiderStart(String url) {
        ZhihuSpider spider = new ZhihuSpider(new ZhihuPageProcessor());
        spider.addUrl(url).setDownloader(new ZhihuDownloader(spider))
              .setScheduler(new FileCacheQueueScheduler("/spider/logs/queue"))
              .addPipeline(esPipeline)
              .thread(1);
        spider.run();
    }


    public void inserZhiDataToEs(){
        List<Map<String,Object>> listMap = new ArrayList<>();
        dataThread.submit(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Map<String,Object> result = QueueManager.getZhihuQueue().take();
                        listMap.add(result);
                        if (listMap.size() >= 100){
                            esOperatorDao.bulkInsertData(EsIndexAndTypeEnum.ZHIHU.getIndex(),EsIndexAndTypeEnum.ZHIHU.getType(),listMap,true);
                            log.info("往es:[{}]中添加了100条数据",EsIndexAndTypeEnum.ZHIHU.getIndex());
                            listMap.clear();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

}
