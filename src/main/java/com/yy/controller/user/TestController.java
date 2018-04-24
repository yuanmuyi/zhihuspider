package com.yy.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yuanyang
 * @Description:
 * @date 2018/4/24 14:48
 */
@Controller
public class TestController {

    @RequestMapping("/index")
    public String index() {

        return "index";
    }
}
