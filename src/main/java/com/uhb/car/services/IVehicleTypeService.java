package com.uhb.car.services;

import com.uhb.car.entity.VehicleTypeEntity;
import org.springframework.data.domain.Page;

/**
 * @Dome interface:对车辆类型进行 CRUD service
 * @Author: LJW
 * @Date: 2019/3/22 08:54
 * @Version 1.0
 */
public interface IVehicleTypeService {
    /**
     * 添加一个车辆类型
     *
     * @param vehicleType
     * @return VehicleTypeEntity
     */
    VehicleTypeEntity saveByVehicleTypeEntity(VehicleTypeEntity vehicleType);

    /**
     * 根据id删除
     *
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 修改一个车辆类型
     *
     * @param vehicleType
     * @return VehicleTypeEntity
     */
    VehicleTypeEntity updateByVehicleTypeEntity(VehicleTypeEntity vehicleType);

    /**
     * 分页查询车辆类型
     *
     * @param pageSize
     * @param pageNumber
     * @return Page<vehicleType>
     */
    Page<VehicleTypeEntity> findAllByVehicleTypeEntitiesPaging(Integer pageSize, Integer pageNumber);

    /**
     * 动态查询车辆类型
     *
     * @param typeName
     * @param pageSize
     * @param pageNumber
     * @return Page<VehicleTypeEntity>
     */
    Page<VehicleTypeEntity> findAllByVehicleTypeEntityDynamic(String typeName, Integer pageSize, Integer pageNumber);
}
