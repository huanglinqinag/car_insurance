package com.uhb.car.util.aspect;

import com.uhb.car.entity.SysLog;
import com.uhb.car.services.LoggerAopServices;
import com.uhb.car.util.interfaceLog.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName:切面类
 * @Author: hlq
 * @Date: 2019/3/21 18:41
 * @Version 1.0
 */

@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    @Autowired
    LoggerAopServices loggerAopServices;

        @Pointcut("execution(* com.uhb.car.controller.*.delete*(..))")
        public void pointcut() {
        }

        @Before("pointcut()")
        public void before(JoinPoint joinPoint) {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            HttpSession session = request.getSession();
            //用户名
            String username = (String) session.getAttribute("username");
            //ip
            String ip = request.getRemoteAddr();
            try {
                //请求方法
                String targetName = joinPoint.getTarget().getClass().getName();
                //
                String methodName = joinPoint.getSignature().getName();
                System.out.println(methodName);
                //
                Object[] arguments = joinPoint.getArgs();

                Class targetClass = Class.forName(targetName);
                Method[] methods = targetClass.getMethods();
                String operationType = "";
                String operationName = "";
                for (Method method : methods) {
                    System.out.println(method.getName());
                    Class[] clazzs = method.getParameterTypes();
                    if (methodName.equals(method.getName())) {
                        operationType = method.getAnnotation(Log.class).operationType();
                        operationName = method.getAnnotation(Log.class).operationName();
                        break;
                    }
                }
                SysLog sysLog = new SysLog();
                sysLog.setDescription(operationName);
                sysLog.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()") + "." + operationType);
                sysLog.setLogType(0);
                sysLog.setRequestIp(ip);
                sysLog.setExceptionCode(null);
                sysLog.setExceptionDetail(null);
                sysLog.setParams(null);
                sysLog.setCreateBy(username);

                sysLog.setCreateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                //保存到数据库
                loggerAopServices.save(sysLog);
                System.out.println("插入成功");
            } catch (ClassNotFoundException e) {
                logger.error("前置通知异常");
                logger.error("异常信息", e.getMessage());
                e.printStackTrace();
            }


        }
    }

