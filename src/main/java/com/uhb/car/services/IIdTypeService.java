package com.uhb.car.services;

import com.uhb.car.entity.IdTypeEntity;
import org.springframework.data.domain.Page;

/**
 * @Dome interface:IIdTypeService
 * @Author: LJW
 * @Date: 2019/3/22 09:16
 * @Version 1.0
 */
public interface IIdTypeService {
    /**
     * 添加一条证件信息
     *
     * @param idType
     * @return IdTypeEntity
     */
    IdTypeEntity saveByIdType(IdTypeEntity idType);

    /**
     * 根据证件Id删除
     *
     * @param idTypeId
     */
    void deleteId(Integer idTypeId);

    /**
     * 修改证件信息
     *
     * @param idType
     * @return IdTypeEntity
     */
    IdTypeEntity updateByIdType(IdTypeEntity idType);

    /**
     * 分页查询
     *
     * @param pageSize
     * @param pageNumber
     * @return Page<IdTypeEntity>
     */
    Page<IdTypeEntity> findAllByIdType(Integer pageSize, Integer pageNumber);
}
