package com.yy.dao.entity.user;

import com.yy.dao.entity.BaseEntity;

/**
 * @author yuanyang
 * @Description:
 * @date 2018/4/18 16:55
 */
public class User extends BaseEntity{

    private String username;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
