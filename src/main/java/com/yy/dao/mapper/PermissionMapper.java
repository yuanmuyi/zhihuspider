package com.yy.dao.mapper;

import com.yy.dao.entity.user.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yuanyang
 * @Description:
 * @date 2018/4/18 16:55
 */
@Repository
public interface PermissionMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    List<Permission> findPermissionsByUserId(Long userId);
}