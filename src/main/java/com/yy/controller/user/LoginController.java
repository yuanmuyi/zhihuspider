package com.yy.controller.user;

import com.yy.dao.vo.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuanyang
 * @Description:
 * @date 2018/5/4 14:53
 */
@RestController
@Api(value = "登录接口", tags = {"登录接口"})
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/test")
    @RequiresPermissions("usermanager")
    public ResponseResult index(){
        return new ResponseResult("test");
    }

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public ResponseResult login(@RequestParam("username") String username, @RequestParam("password") String password){
        Subject subject = SecurityUtils.getSubject();
//        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        subject.login(token);
        return new ResponseResult(subject.getSession().getId(),200,"登录成功");
    }


    /**
     * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
     * @return
     */
    @GetMapping(value = "/unauth")
    public ResponseResult unauth() {
        return new ResponseResult(404,"未登录");
    }
}
