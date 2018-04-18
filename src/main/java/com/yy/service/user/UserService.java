package com.yy.service.user;

import com.yy.dao.entity.user.User;
import com.yy.dao.vo.UserVo;
import com.yy.service.BaseService;

/**
 * @author yuanyang
 * @Description:
 * @date 2018/4/18 16:50
 */
public interface UserService extends BaseService {

    User findById(Long id);

    UserVo findByUserName(String userName);
}
