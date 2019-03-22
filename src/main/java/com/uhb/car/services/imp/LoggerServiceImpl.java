package com.uhb.car.services.imp;

import com.uhb.car.dao.LoggerAop;
import com.uhb.car.entity.SysLog;
import com.uhb.car.services.LoggerAopServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName:aop
 * @Author: hlq
 * @Date: 2019/3/22 10:01
 * @Version 1.0
 */
@Service
public class LoggerServiceImpl implements LoggerAopServices {
    @Autowired
    LoggerAop loggerAop;

    @Override
    public SysLog save(SysLog sysLog) {
        return loggerAop.save(sysLog);

    }
}
