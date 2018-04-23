package com.yy.service.user;

import com.yy.dao.entity.user.Permission;
import com.yy.dao.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuanyang
 * @Description:
 * @date 2018/4/18 16:52
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public Permission findById(Long id) {
        return null;
    }

    @Override
    public List<Permission> findPermissionsByUserId(Long userId) {
        return permissionMapper.findPermissionsByUserId(userId);
    }
}
