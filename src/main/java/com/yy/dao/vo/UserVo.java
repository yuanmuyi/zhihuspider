package com.yy.dao.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author yuanyang
 * @Description:
 * @date 2018/4/18 17:48
 */
public class UserVo implements Serializable{

    private Long id;

    private String username;

    private String password;

    private List<String> roles;

    private List<String> permissions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
}
