package com.uhb.car.services;

import com.uhb.car.entity.DisplacementEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Dome interface:对汽车排量进行CURD service
 * @Author: LJW
 * @Date: 2019/3/19 17:51
 * @Version 1.0
 */
public interface IDisplacementService {
    /**
     * 新增一条汽车排量信息
     *
     * @param displacement
     * @return DisplacementEntity
     */
    DisplacementEntity save(DisplacementEntity displacement);

    /**
     * 根据车俩排练Id进行删除
     *
     * @param displacementId
     * @return int
     */
    int deleteAllByDisplacementId(Integer displacementId);

    /**
     * 修改车辆排量信息
     *
     * @param displacement
     * @return DisplacementEntity
     */
    DisplacementEntity update(DisplacementEntity displacement);

    /**
     * 分页查询所有排量信息
     *
     * @param pageable
     * @return Page<DisplacementEntity>
     */
    Page<DisplacementEntity> findAll(Pageable pageable);
}
