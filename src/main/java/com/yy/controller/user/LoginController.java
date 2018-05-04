package com.yy.controller.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yuanyang
 * @Description:
 * @date 2018/5/4 14:53
 */
@Controller
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);


    @RequestMapping("/unAuth")
    public String index(ModelMap map){
        log.info("============Controller=================");
        map.put("title", "HelloWorld");
        return "login";
    }

    @RequestMapping("/welcome")
    public String welcome(){
        return "login";
    }
}
