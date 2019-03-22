package com.uhb.car.services;

import com.uhb.car.entity.CarOwnerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Dome interface:对车主信息进行CRUD Service
 * @Author: LJW
 * @Date: 2019/3/19 19:06
 * @Version 1.0
 */
public interface ICarOwnerService {
    /**
     * 添加车主信息
     *
     * @param carOwner
     * @return CarOwnerEntity
     */
    CarOwnerEntity save(CarOwnerEntity carOwner);

    /**
     * 根据车主信息Id进行删除
     *
     * @param carOwnerId
     * @return int
     */
    void deleteById(Integer carOwnerId);

    /**
     * 修改车主信息
     *
     * @param carOwner
     * @return CarOwnerEntity
     */
    CarOwnerEntity update(CarOwnerEntity carOwner);

    /**
     * 分页查询车主信息
     *
     * @param pageable
     * @return Page<CarOwnerEntity>
     */
    Page<CarOwnerEntity> findAll(Pageable pageable);
}
