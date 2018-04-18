package com.yy.dao.entity.user;

import com.yy.dao.entity.BaseEntity;

/**
 * @author yuanyang
 * @Description:
 * @date 2018/4/18 16:56
 */
public class Role extends BaseEntity{

    private String name;

    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
