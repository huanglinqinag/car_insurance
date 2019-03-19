package com.uhb.car.services;

import com.uhb.car.entity.VehicleTypeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IVehicleTypeService {
    /**
     * 分页查询
     *
     * @param pageable
     * @return List<VehicleTypeEntity>
     */
    Page<VehicleTypeEntity> findAll(Pageable pageable);

    /**
     * 模糊查询
     *
     * @param typeName
     * @return List<VehicleTypeEntity>
     */
    List<VehicleTypeEntity> findAllByTypeNameContaining(String typeName);

    /**
     * 根据id删除
     *
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 添加一个车辆类型
     *
     * @param vehicleTypeEntity
     * @return VehicleTypeEntity
     */
    VehicleTypeEntity save(VehicleTypeEntity vehicleTypeEntity);

    Page<VehicleTypeEntity> findAllVehicleTypeEntityDynamic(String typeName, Integer pageSize, Integer pageNumber);
}
