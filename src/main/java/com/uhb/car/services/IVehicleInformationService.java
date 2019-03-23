package com.uhb.car.services;

import com.uhb.car.entity.VehicleInformationEntity;
import org.springframework.data.domain.Page;

/**
 * @Dome interface:对车辆信息进行CRUD的接口 IVehicleInformationService
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
    VehicleInformationEntity saveVehicleInformationEntity(VehicleInformationEntity vehicleInformation);

    /**
     * 根据车辆id进行删除
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
    VehicleInformationEntity updateVehicleInformationEntity(VehicleInformationEntity vehicleInformation);

    /**
     * 分页查询一条车辆信息
     *
     * @param pageSize
     * @param pageNumber
     * @return Page<VehicleInformationEntity>
     */
    Page<VehicleInformationEntity> findAllByVehicleInformationEntityPaging(Integer pageSize, Integer pageNumber);

    /**
     * 动态分页查询一条车辆信息
     *
     * @param vehicleInformation
     * @param pageSize
     * @param pageNumber
     * @return Page<VehicleInformationEntity>
     */
    Page<VehicleInformationEntity> findAllByVehicleInformationEntityDynamic(VehicleInformationEntity vehicleInformation, Integer pageSize, Integer pageNumber);
}
