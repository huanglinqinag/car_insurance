package com.uhb.car.services;

import com.uhb.car.entity.VehicleTypeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IVehicleTypeService {
    /**
     * 添加一个车辆类型
     *
     * @param vehicleTypeEntity
     * @return VehicleTypeEntity
     */
    VehicleTypeEntity save(VehicleTypeEntity vehicleTypeEntity);

    /**
     * 根据id删除
     *
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 修改一个车辆类型
     *
     * @param vehicleTypeEntity
     * @return VehicleTypeEntity
     */
    VehicleTypeEntity update(VehicleTypeEntity vehicleTypeEntity);

    /**
     * 模糊查询
     *
     * @param typeName
     * @return List<VehicleTypeEntity>
     */
    List<VehicleTypeEntity> findAllByTypeNameContaining(String typeName);


    /**
     * 分页查询
     *
     * @param pageable
     * @return List<VehicleTypeEntity>
     */
    Page<VehicleTypeEntity> findAll(Pageable pageable);

    /**
     * 动态查询车辆类型
     *
     * @param typeName
     * @param pageSize
     * @param pageNumber
     * @return Page<VehicleTypeEntity>
     */
    Page<VehicleTypeEntity> findAllVehicleTypeEntityDynamic(String typeName, Integer pageSize, Integer pageNumber);
}
