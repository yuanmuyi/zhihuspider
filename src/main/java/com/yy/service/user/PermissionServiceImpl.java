package com.yy.service.user;

import com.yy.dao.entity.user.Permission;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuanyang
 * @Description:
 * @date 2018/4/18 16:52
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Override
    public Permission findById(Long id) {
        return null;
    }

    @Override
    public List<Permission> findPermissionsByUserId(Long userId) {
        return null;
    }
}
