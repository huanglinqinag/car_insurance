package com.uhb.car.dao;


import com.uhb.car.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @ClassName:
 * @Author: hlq
 * @Date: 2019/3/6 9:47
 * @Version 1.0
 */
@Repository
public interface UserDao extends JpaRepository<Users, Long> {
    /**
     *
     * @param name
     * @return
     */
    Users findByName(String name);

    /**
     *
     * @return
     */
    @Override
    List<Users> findAll();

}
