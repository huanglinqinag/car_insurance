package com.uhb.car.services;

import com.uhb.car.entity.DisplacementEntity;
import com.uhb.car.entity.VehicleAndVesselTaxEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Dome interface:对车船税进行CRUD Service
 * @Author: LJW
 * @Date: 2019/3/17 13:14
 * @Version 1.0
 */


public interface IVehicleAndVesselTaxService {
    /**
     * 新增一条车船税
     *
     * @param vehicleAndVesselTaxEntity
     * @return VehicleAndVesselTaxEntity
     */


    VehicleAndVesselTaxEntity save(VehicleAndVesselTaxEntity vehicleAndVesselTaxEntity);

    /**
     * 根据车船税Id删除
     *
     * @param vehicleVesselTaxId
     */
    void deleteById(Integer vehicleVesselTaxId);

    /**
     * 修改一条车船税数据
     *
     * @param vehicleAndVesselTaxEntity
     * @return VehicleAndVesselTaxEntity
     */
    VehicleAndVesselTaxEntity update(VehicleAndVesselTaxEntity vehicleAndVesselTaxEntity);

    /**
     * 分页查询所有车船税
     *
     * @param pageable
     * @return Page<VehicleAndVesselTaxEntity>
     */


    Page<VehicleAndVesselTaxEntity> findAll(Pageable pageable);

    /**
     * 动态分页查询
     *
     * @param
     * @param pageNumber
     * @param pageSize
     * @return Page<VehicleAndVesselTaxEntity>
     */
    Page<VehicleAndVesselTaxEntity> findVesselTaxEntitiesDynamic(Integer displacementId, Integer pageNumber, Integer pageSize);
}
