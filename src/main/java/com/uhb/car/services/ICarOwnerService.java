package com.uhb.car.services;

import com.uhb.car.entity.CarOwnerEntity;
import org.springframework.data.domain.Page;

/**
 * @Dome interface:对车主信息进行CRUD ICarOwnerService
 * @Author: LJW
 * @Date: 2019/3/19 19:06
 * @Version 1.0
 */
public interface ICarOwnerService {
    /**
     * 添加一条车主信息
     *
     * @param carOwnerEntity
     * @return CarOwnerEntity
     */
    CarOwnerEntity saveByCarOwnerEntity(CarOwnerEntity carOwnerEntity);

    /**
     * 根据车主信息Id进行删除
     *
     * @param carOwnerId
     */
    void deleteByCarOwnerId(Integer carOwnerId);

    /**
     * 修改车主信息
     *
     * @param carOwnerEntity
     * @return
     */
    CarOwnerEntity updateByCarOwnerEntity(CarOwnerEntity carOwnerEntity);

    /**
     * 分页查询所有车主信息
     *
     * @param pageSize
     * @param pageNumber
     * @return
     */
    Page<CarOwnerEntity> findAllByCarOwnerEntitiesPaging(Integer pageSize, Integer pageNumber);

    /**
     * 动态分页查询
     *
     * @param carOwner
     * @param pageSize
     * @param pageNumber
     * @return Page<CarOwnerEntity>
     */
    Page<CarOwnerEntity> findAllByCarOwnerEntitiesDynamic(CarOwnerEntity carOwner, Integer pageSize, Integer pageNumber);

}
