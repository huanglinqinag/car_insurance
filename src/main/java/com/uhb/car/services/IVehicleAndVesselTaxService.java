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
     * 添加一条车船税信息
     *
     * @param vehicleAndVesselTax
     * @return VehicleAndVesselTaxEntity
     */
    VehicleAndVesselTaxEntity saveByVehicleAndVesselTaxEntity(VehicleAndVesselTaxEntity vehicleAndVesselTax);

    /**
     * 根据车船税Id进行删除
     *
     * @param vehicleVesselTaxId
     */
    void deleteByVehicleVesselTaxId(Integer vehicleVesselTaxId);

    /**
     * 修改车船税信息
     *
     * @param vehicleAndVesselTax
     * @return VehicleAndVesselTaxEntity
     */
    VehicleAndVesselTaxEntity updateByVehicleAndVesselTaxEntity(VehicleAndVesselTaxEntity vehicleAndVesselTax);

    /**
     * 分页查询车船税信息
     *
     * @param pageSize
     * @param PageNumber
     * @return Page<VehicleAndVesselTaxEntity>
     */
    Page<VehicleAndVesselTaxEntity> findAllByVehicleAndVesselTaxEntityPaging(Integer pageSize, Integer PageNumber);

    /**
     * 动态分页查询车船税信息
     *
     * @param pageSize
     * @param pageNumber
     * @return Page<VehicleAndVesselTaxEntity>
     */
    Page<VehicleAndVesselTaxEntity> findAllByVehicleAndVesselTaxEntityDynamic(Integer displacementId, Integer pageSize, Integer pageNumber);

}
