package com.uhb.car.services;

import com.uhb.car.entity.Users;

import java.util.List;

/**
 * @ClassName:
 * @Author: hlq
 * @Date: 2019/3/7 15:57
 * @Version 1.0
 */
public interface DemoService {
    public Users findByName(String name);
    public List<Users> findAll();
}
