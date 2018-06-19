package com.yy.common;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yuanyang
 * @Description:
 * @date 2018/6/19 10:21
 */
public class QueueManager {

    private static BlockingQueue<Map<String,Object>> zhihuQueue = new LinkedBlockingQueue<>();

    public static BlockingQueue<Map<String,Object>> getZhihuQueue(){
        return zhihuQueue;
    }

}
