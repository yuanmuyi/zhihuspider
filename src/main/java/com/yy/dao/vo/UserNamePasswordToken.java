package com.yy.dao.vo;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author yuanyang
 * @Description:
 * @date 2018/4/18 17:20
 */
public class UserNamePasswordToken implements AuthenticationToken {

    private String username;

    private String token;

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
