package com.uhb.car.services;

import com.uhb.car.entity.NatureOfVehicleUseEntity;
import org.springframework.data.domain.Page;

/**
 * @Dome interface:对车辆使用性质进行CRUD INatureOfVehicleUseService
 * @Author: LJW
 * @Date: 2019/3/22 22:50
 * @Version 1.0
 */
public interface INatureOfVehicleUseService {
    /**
     * 添加一条车辆性质
     *
     * @param natureOfVehicleUse
     * @return NatureOfVehicleUseEntity
     */
    NatureOfVehicleUseEntity saveByNatureOfVehicleUseEntity(NatureOfVehicleUseEntity natureOfVehicleUse);

    /**
     * 根据车辆性质Id进行删除
     *
     * @param natureOfVehicleUseId
     */
    void deleteByNatureOfVehicleUseEntity(Integer natureOfVehicleUseId);

    /**
     * 修改车辆性质
     *
     * @param natureOfVehicleUse
     * @return NatureOfVehicleUseEntity
     */
    NatureOfVehicleUseEntity updateByNatureOfVehicleUseEntity(NatureOfVehicleUseEntity natureOfVehicleUse);

    /**
     * 分页查询车辆性质
     *
     * @param pageSize
     * @param pageNumber
     * @return Page<NatureOfVehicleUseEntity>
     */
    Page<NatureOfVehicleUseEntity> findByNatureOfVehicleUseEntityPaging(Integer pageSize, Integer pageNumber);

    /**
     * 动态分页查询车辆性质
     *
     * @param natureOfVehicleUse
     * @param pageSize
     * @param pageNumber
     * @return Page<NatureOfVehicleUseEntity>
     */
    Page<NatureOfVehicleUseEntity> findByNatureOfVehicleUseEntityPagingDynamic(NatureOfVehicleUseEntity natureOfVehicleUse, Integer pageSize, Integer pageNumber);
}
