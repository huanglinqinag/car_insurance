package com.uhb.car.dao;

import com.uhb.car.entity.SysLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName:aop日志
 * @Author: hlq
 * @Date: 2019/3/22 9:56
 * @Version 1.0
 */
public interface LoggerAop extends JpaRepository<SysLog,Integer> {

}
