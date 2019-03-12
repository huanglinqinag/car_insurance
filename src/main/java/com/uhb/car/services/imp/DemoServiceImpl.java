package com.uhb.car.services.imp;


import com.uhb.car.dao.UserDao;
import com.uhb.car.entity.Users;
import com.uhb.car.services.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

/**
 * @ClassName:
 * @Author: hlq
 * @Date: 2019/3/7 15:58
 * @Version 1.0
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
     private UserDao de;
    @Override
    public Users findByName(String name) {
        return de.findByName(name);
    }

    @Override
    public List<Users> findAll() {
        return de.findAll();
    }
}
