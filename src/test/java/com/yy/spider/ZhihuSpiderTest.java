package com.yy.spider;

import com.yy.ZhihuspiderApplicationTests;
import com.yy.service.spider.SpiderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yuanyang
 * @Description:
 * @date 2018/6/1 15:54
 */
public class ZhihuSpiderTest extends ZhihuspiderApplicationTests {

    private final static String startUrl = "https://www.zhihu.com/people/excited-vczh/activities";

    @Autowired
    private SpiderService spiderService;

    @Test
    public void getZhihuUserTest(){
        spiderService.spiderStart(startUrl);
    }

}
