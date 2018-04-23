package com.yy.service.user;

import com.yy.dao.entity.user.Role;
import com.yy.dao.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuanyang
 * @Description:
 * @date 2018/4/18 16:52
 */
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleMapper roleMapper;
    @Override
    public Role findById(Long id) {
        return null;
    }

    @Override
    public List<Role> findRolesByUserId(Long userId) {
        return roleMapper.findRolesByUserId(userId);
    }
}
