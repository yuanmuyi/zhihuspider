package com.yy.util;

import java.util.UUID;

/**
 * @author yuanyang
 * @Description:唯一id生成工具
 * @date 2018/5/14 16:26
 */
public class UUIDUtils {

    public static  String getUUID(){
        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString();
        uuidStr = uuidStr.replace("-","");
        return uuidStr;
    }
}
