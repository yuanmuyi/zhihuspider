package com.yy.dao.mapper;

import com.yy.dao.entity.user.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yuanyang
 * @Description:
 * @date 2018/4/18 16:55
 */
@Repository
public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> findRolesByUserId(Long userId);
}