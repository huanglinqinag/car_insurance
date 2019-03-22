package com.uhb.car.util.interfaceLog;

import java.lang.annotation.*;

/**
 * @ClassName:自定义注解
 * @Author: hlq
 * @Date: 2019/3/22 9:41
 * @Version 1.0
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /** 要执行的操作类型比如：add操作 **/
    public String operationType() default "";
    /** 要执行的具体操作比如：添加用户 **/
    public String operationName() default "";
}
