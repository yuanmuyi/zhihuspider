package com.yy.dao.mapper;

import com.yy.dao.entity.user.RolePermission;
import org.springframework.stereotype.Repository;

/**
 * @author yuanyang
 * @Description:
 * @date 2018/4/18 16:55
 */
@Repository
public interface RolePermissionMapper {
    int insert(RolePermission record);

    int insertSelective(RolePermission record);
}