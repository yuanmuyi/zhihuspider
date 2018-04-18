package com.yy.service.user;


import com.yy.dao.entity.user.Role;

import java.util.List;

/**
 * @author yuanyang
 * @Description:
 * @date 2018/4/18 16:51
 */
public interface RoleService {


    Role findById(Long id);

    List<Role> findRolesByUserId(Long userId);
}
