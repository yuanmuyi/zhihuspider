package com.yy.es;

import com.yy.ZhihuspiderApplicationTests;
import com.yy.dao.es.EsOperatorDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yuanyang
 * @Description:
 * @date 2018/6/1 16:43
 */
public class EsTest extends ZhihuspiderApplicationTests {
    @Autowired
    private EsOperatorDao esOperatorDao;

    @Test
    public void insertData(){
//        Map<String,Object> testData = new HashMap<>(8);
//        testData.put("name","张三");
//        testData.put("introduction","电影编剧、导演");
//        esOperatorDao.insertData(EsIndexAndTypeEnum.ZHIHU.getIndex(),EsIndexAndTypeEnum.ZHIHU.getType(),testData);
    }

    @Test
    public void initEsIndex(){
        esOperatorDao.initIndexAndType();
    }
}
