package com.yy.service.user;


import com.yy.dao.entity.user.Permission;

import java.util.List;

/**
 * @author yuanyang
 * @Description:
 * @date 2018/4/18 16:52
 */
public interface PermissionService {

    Permission findById(Long id);

    List<Permission> findPermissionsByUserId(Long userId);
}
