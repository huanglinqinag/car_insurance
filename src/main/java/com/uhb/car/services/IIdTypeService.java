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
    IdTypeEntity saveByIdTypeEntity(IdTypeEntity idType);

    /**
     * 根据Id删除一条证件信息
     *
     * @param idTypeId
     */
    void deleteByIdTypeEntity(Integer idTypeId);

    /**
     * 修改一条证件信息
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
     * @return
     */
    Page<IdTypeEntity> findAllByIdTypeEntity(Integer pageSize, Integer pageNumber);
}
