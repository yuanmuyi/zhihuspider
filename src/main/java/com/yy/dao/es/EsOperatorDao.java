package com.yy.dao.es;

import java.util.List;
import java.util.Map;

/**
 * @author yuanyang
 * @Description:Es操作接口
 * @date 2018/5/9 16:00
 */
public interface EsOperatorDao {

 
    /**
     * 索引和类型初始化
     * @author yaunyang
     * @date 2018/5/9 16:11
     */
    void initIndexAndType();

    /**
     * 数据插入
     * @author yaunyang
     * @date 2018/5/10 11:23
     */
    void insertData(String index,String type,Map<String,Object> data);

    /**
     * 批量插入
     * @author yaunyang
     * @date 2018/6/1 11:31
     */
    void bulkInsertData(String index, String type, List<Map<String,Object>> datas, boolean refresh);
}
