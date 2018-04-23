package com.yy.dao.mapper;

import com.yy.dao.entity.user.User;
import org.springframework.stereotype.Repository;
/**
 * @author yuanyang
 * @Description:
 * @date 2018/4/18 16:55
 */
@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    User findByUsername(String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}