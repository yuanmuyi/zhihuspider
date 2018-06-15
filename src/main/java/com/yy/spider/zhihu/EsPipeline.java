package com.yy.spider.zhihu;

import com.yy.common.Constant;
import com.yy.common.enums.EsIndexAndTypeEnum;
import com.yy.dao.es.EsOperatorDao;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private EsOperatorDao esOperatorDao;

    @Override
    public void process(ResultItems resultItems, Task task) {
        Map<String,Object> result = resultItems.get(Constant.RESULT_LIST_MAP);
        try {
            if (result != null && !result.isEmpty()){
                esOperatorDao.insertData(EsIndexAndTypeEnum.ZHIHU.getIndex(),EsIndexAndTypeEnum.ZHIHU.getType(),result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
