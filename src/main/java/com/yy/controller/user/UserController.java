package com.yy.controller.user;

import com.yy.controller.BaseController;
import com.yy.dao.vo.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author: victor(yuanyang)
 * @date: 2018/4/19 23:21
 * @reviewer
 */
@Api(value = "用户接口",tags = {"用户接口"})
@RestController
@RequestMapping("/test")
public class UserController extends BaseController{


    @ApiOperation("获取用户")
    @GetMapping("/getUser")
    public ResponseResult getUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        return new ResponseResult(session.getAttribute("data"));
    }

    @ApiOperation("设置用户")
    @GetMapping("/setUser")
    public ResponseResult setUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("data","yuanmuyi");
        return new ResponseResult("你好");
    }

}
