package com.yy.exception;

import com.yy.dao.vo.ResponseResult;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yuanyang
 * @description:业务异常全局处理器
 * @date 2018/10/17 16:29
 */
@ControllerAdvice
public class BizExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(BizExceptionHandler.class);


    @ExceptionHandler(AuthorizationException.class)
    @ResponseBody
    protected ResponseResult shiroAuthorizationException(Exception e, HttpServletRequest request){
        log.warn("shiro 权限异常, uri={}, msg={}",request.getRequestURL(),e.getMessage(),e);
        if (e instanceof UnauthenticatedException){
            return  new ResponseResult(405,"token无效");
        }else if (e instanceof UnauthorizedException){
            return new ResponseResult(406,"无权限");
        }else {
            return new ResponseResult(500,"server error");
        }
    }

}
