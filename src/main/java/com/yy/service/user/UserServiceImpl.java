package com.yy.service.user;

import com.yy.dao.entity.user.User;
import com.yy.dao.mapper.UserMapper;
import com.yy.dao.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuanyang
 * @Description:用户服务实现
 * @date 2018/4/18 16:51
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;


    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public UserVo findByUserName(String userName) {
        User user = userMapper.findByUsername(userName);
        UserVo userVo = new UserVo();
        userVo.setId(user.getId());
        userVo.setUsername(user.getUsername());
        userVo.setPassword(user.getPassword());
        return userVo;
    }
}
