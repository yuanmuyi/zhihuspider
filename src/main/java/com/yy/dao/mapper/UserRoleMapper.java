package com.yy.dao.mapper;

import com.yy.dao.entity.user.UserRole;
import org.springframework.stereotype.Repository;
/**
 * @author yuanyang
 * @Description:
 * @date 2018/4/18 16:55
 */
@Repository
public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);
}