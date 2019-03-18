package com.uhb.car.services;

import com.uhb.car.entity.VehicleAndVesselTaxEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @interfaceName:IVehicleAndVesselTaxService
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

  /*  *//**
     * 根据车船随id删除
     *
     * @param vehicleAndVesselTaxId
     * @return int
     *//*


    int deleteByVehicleAndVesselTaxId(int vehicleAndVesselTaxId);*/

    /**
     * 分页查询所有车船税
     *
     * @param pageable
     * @return Page<VehicleAndVesselTaxEntity>
     */


    Page<VehicleAndVesselTaxEntity> findAll(Pageable pageable);
}
