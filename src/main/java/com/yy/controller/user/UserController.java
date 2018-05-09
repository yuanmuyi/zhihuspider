package com.yy.controller.user;

import com.yy.controller.BaseController;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: victor(yuanyang)
 * @date: 2018/4/19 23:21
 * @reviewer
 */
@Api(value = "用户接口",tags = {"用户接口"})
@RestController
@RequestMapping("/user")
public class UserController extends BaseController{



}
