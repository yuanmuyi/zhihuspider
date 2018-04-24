package com.yy.controller.user;

import com.yy.controller.BaseController;
import com.yy.dao.vo.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: victor(yuanyang)
 * @date: 2018/4/19 23:21
 * @reviewer
 */
@Api(value = "用户接口",tags = {"用户接口"})
@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

	@ApiOperation(value = "用户登录")
	@PostMapping("/login")
	public ResponseResult login(HttpServletRequest request,String username,String password){
		Subject subject = SecurityUtils.getSubject();
		String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
		UsernamePasswordToken token = new UsernamePasswordToken(username,md5Password);
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			return new ResponseResult(401,"用户名或密码错误");
		}
		return new ResponseResult(200,"登录成功");
	}
}
