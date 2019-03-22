package com.uhb.car.util.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName:切面类
 * @Author: hlq
 * @Date: 2019/3/21 18:41
 * @Version 1.0
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);
    /**
     * @ClassName:
     * @Author: hlq
     * @Date: 2019/3/21 19:00
     * @Version 1.0
     * @param: Controller层切点
     * 第一个*代表所有的返回值类型
     * 第二个*代表所有的类
     * 第三个*代表类所有方法
     * 最后一个..代表所有的参数。
     */
    @Pointcut("execution(* com.uhb.car.controller..*.*(..))")
     public void pointcut(){}

     @Before("pointcut()")
    public void before(JoinPoint joinPoint){
         ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
         HttpServletRequest request = attributes.getRequest();
         //获取请求的url
         logger.info("url:{}",request.getRequestURI());
         //获取请求的方法
         logger.info("method:{}",request.getMethod());
         //获取请求的ip
         logger.info("ip:{}",request.getRemoteAddr());

     }
}
