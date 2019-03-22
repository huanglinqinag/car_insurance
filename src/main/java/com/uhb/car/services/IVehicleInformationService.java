package com.uhb.car.services;

import com.uhb.car.entity.VehicleInformationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Dome interface:IVehicleInformationService
 * @Author: LJW
 * @Date: 2019/3/22 08:54
 * @Version 1.0
 */
public interface IVehicleInformationService {
    /**
     * 添加一条车辆信息
     *
     * @param vehicleInformation
     * @return VehicleInformationEntity
     */
    VehicleInformationEntity saveVehicleInformation(VehicleInformationEntity vehicleInformation);

    /**
     * 根据Id删除车辆信息
     *
     * @param vehicleId
     */
    void deleteByVehicleId(Integer vehicleId);

    /**
     * 修改一条车辆信息
     *
     * @param vehicleInformation
     * @return VehicleInformationEntity
     */
    VehicleInformationEntity updateVehicleInformation(VehicleInformationEntity vehicleInformation);

    /**
     * 分页查询所有车辆信息
     *
     * @param pageable
     * @return Page<VehicleInformationEntity>
     */
    Page<VehicleInformationEntity> findAllByVehicleInformation(Pageable pageable);

    /**
     * 动态查询车辆信息
     *
     * @param pageSize
     * @param pageNumber
     * @return Page<VehicleInformationEntity>
     */
    Page<VehicleInformationEntity> findAllByVehicleInformationDynamic(Integer pageSize, Integer pageNumber);
}
