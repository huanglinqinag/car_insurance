package com.uhb.car.services;

import com.uhb.car.entity.IdTypeEntity;
import org.springframework.data.domain.Page;

/**
 * @Dome interface:对证件信息进行CRUD IIdTypeService
 * @Author: LJW
 * @Date: 2019/3/22 09:16
 * @Version 1.0
 */
public interface IIdTypeService {
    /**
     * 添加证件信息
     *
     * @param idType
     * @return IdTypeEntity
     */
    IdTypeEntity saveByIdTypeEntity(IdTypeEntity idType);

    /**
     * 根据证件Id进行删除
     *
     * @param idTypeId
     */
    void deleteByIdTypeId(Integer idTypeId);

    /**
     * 修改证件信息
     *
     * @param idType
     * @return IdTypeEntity
     */
    IdTypeEntity updateByIdTypeEntity(IdTypeEntity idType);

    /**
     * 分页查询证件信息
     *
     * @param pageSize
     * @param pageNumber
     * @return Page<IdTypeEntity>
     */
    Page<IdTypeEntity> findAllByIdTypeEntityPaging(Integer pageSize, Integer pageNumber);

    /**
     * 动态分页查询证件信息
     *
     * @param idType
     * @param pageSize
     * @param pageNumber
     * @return Page<IdTypeEntity>
     */
    Page<IdTypeEntity> findAllByIdTypeEntityDynamic(IdTypeEntity idType, Integer pageSize, Integer pageNumber);

}
