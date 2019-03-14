package com.uhb.car.exception;

import com.uhb.car.bean.ResponseBean;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName:
 * @Author: hlq
 * @Date: 2019/3/12 16:10
 * @Version 1.0
 */

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = ShiroException.class)//处理所有异常
    @ResponseBody //在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
    public ResponseBean UnauthorizedException(){
        return new ResponseBean(401,"权限不足","滚");
    }


    @ExceptionHandler(value = Exception.class)//处理所有异常
    @ResponseBody //在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
    public ResponseBean Exception(){
        return new ResponseBean(500,"异常","123");
    }
    @ExceptionHandler(value = AuthorizationException.class)//处理所有异常
    @ResponseBody //在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
    public ResponseBean AuthorizationException(){
        return new ResponseBean(401,"异常","123");
    }










}
