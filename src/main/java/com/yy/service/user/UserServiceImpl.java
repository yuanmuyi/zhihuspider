package com.yy.service.user;

import com.yy.dao.entity.user.User;
import com.yy.dao.vo.UserVo;
import org.springframework.stereotype.Service;

/**
 * @author yuanyang
 * @Description:用户服务实现
 * @date 2018/4/18 16:51
 */
@Service
public class UserServiceImpl implements UserService {


    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public UserVo findByUserName(String userName) {
        return null;
    }
}
