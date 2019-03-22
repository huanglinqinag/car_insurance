package com.uhb.car.services;

import com.uhb.car.dao.LoggerAop;
import com.uhb.car.entity.SysLog;

/**
 * @ClassName:aop日志
 * @Author: hlq
 * @Date: 2019/3/22 9:58
 * @Version 1.0
 */
public interface LoggerAopServices{
    /**
     * @ClassName:添加日志记录
     * @Author: hlq
     * @Date: 2019/3/22 10:00
     * @Version 1.0
     */

    SysLog save(SysLog sysLog);
}
