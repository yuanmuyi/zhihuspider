package com.yy.controller.user;

import com.yy.dao.vo.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yuanyang
 * @Description:
 * @date 2018/5/4 14:53
 */
@Controller
@Api(value = "登录接口", tags = {"登录接口"})
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/")
    public String index(ModelMap map){
        map.put("title", "HelloWorld");
        return "index";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "login";
    }

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    @ResponseBody
    public ResponseResult login(HttpServletRequest request, @RequestParam("username") String username, @RequestParam("password") String password){
        Subject subject = SecurityUtils.getSubject();
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        UsernamePasswordToken token = new UsernamePasswordToken(username,md5Password);
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return new ResponseResult(null,500, "用户名或密码错误", false);
        }
        return new ResponseResult(null);
    }
}
