package com.uhb.car.services;

import com.uhb.car.entity.DisplacementEntity;
import org.springframework.data.domain.Page;

/**
 * @Dome interface:对汽车排量进行CURD service
 * @Author: LJW
 * @Date: 2019/3/19 17:51
 * @Version 1.0
 */
public interface IDisplacementService {
    /**
     * 添加一条汽车排量信息
     *
     * @param displacementEntity
     * @return DisplacementEntity
     */
    DisplacementEntity saveByDisplacementEntity(DisplacementEntity displacementEntity);

    /**
     * 根据汽车排量Id进行删除
     *
     * @param displacementId
     */
    void deleteByDisplacementId(Integer displacementId);

    /**
     * 修改汽车排量信息
     *
     * @param displacementEntity
     * @return DisplacementEntity
     */
    DisplacementEntity updateByDisplacementEntity(DisplacementEntity displacementEntity);

    /**
     * 分页查询所有汽车排量信息
     *
     * @param pageSize
     * @param pageNumber
     * @return Page<DisplacementEntity>
     */
    Page<DisplacementEntity> findAllByDisplacementEntityPaging(Integer pageSize, Integer pageNumber);

    Page<DisplacementEntity> findAllByDisplacementEntityDynamic(DisplacementEntity displacement, Integer pageSize, Integer pageNumber);

}
