package com.yy.spider.zhihu;

import com.yy.common.Constant;
import com.yy.common.QueueManager;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Map;

/**
 * @author yuanyang
 * @Description:es管道
 * @date 2018/5/31 17:28
 */
@Component
public class EsPipeline implements Pipeline {

    @Override
    public void process(ResultItems resultItems, Task task) {
        Map<String, Object> result = resultItems.get(Constant.RESULT_LIST_MAP);
        try {
            if (result != null && !result.isEmpty()) {
                QueueManager.getZhihuQueue().put(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
