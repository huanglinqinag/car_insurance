package com.uhb.car.services;

import com.uhb.car.entity.EnergyTypeEntity;
import org.springframework.data.domain.Page;

/**
 * @Dome interface:IEnergyTypeService
 * @Author: LJW
 * @Date: 2019/3/23 12:28
 * @Version 1.0
 */
public interface IEnergyTypeService {
    /**
     * 添加一条能源信息
     *
     * @param energyType
     * @return EnergyTypeEntity
     */
    EnergyTypeEntity saveEnergyTypeEntity(EnergyTypeEntity energyType);

    /**
     * 根据能源Id删除
     *
     * @param energyTypeId
     */
    void deleteByEnergyTypeId(Integer energyTypeId);

    /**
     * 修改能源信息
     *
     * @param energyType
     * @return EnergyTypeEntity
     */
    EnergyTypeEntity updateEnergyTypeEntity(EnergyTypeEntity energyType);

    /**
     * 分页查询能源信息
     *
     * @param pageSize
     * @param pageNumber
     * @return Page<EnergyTypeEntity>
     */
    Page<EnergyTypeEntity> findAllByEnergyTypeEntityPaging(Integer pageSize, Integer pageNumber);

    /**
     * 动态分页查询能源信息
     *
     * @param energyType
     * @param pageSize
     * @param pageNumber
     * @return Page<EnergyTypeEntity>
     */
    Page<EnergyTypeEntity> findAllByEnergyTypeEntityDynamic(EnergyTypeEntity energyType, Integer pageSize, Integer pageNumber);
}
