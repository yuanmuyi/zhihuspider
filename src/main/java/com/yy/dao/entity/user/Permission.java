package com.yy.dao.entity.user;

import com.yy.dao.entity.BaseEntity;

/**
 * @author yuanyang
 * @Description:
 * @date 2018/4/18 16:56
 */
public class Permission extends BaseEntity{

    private String name;

    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
