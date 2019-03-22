package com.uhb.car.services;

import com.uhb.car.entity.TypesOfInsuranceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @interfaceName:商业险CUDRService
 * @Author: LJW
 * @Date: 2019/3/17 14:53
 * @Version 1.0
 */
public interface ITypesOfInsuranceService {
    /**
     * 添加一条商业险
     *
     * @param types
     * @return TypesOfInsuranceEntity
     */
    TypesOfInsuranceEntity save(TypesOfInsuranceEntity types);

    /**
     * 根据商业险Id删除
     *
     * @param typesOfInsuranceId
     * @return int
     */
    void deleteById(int typesOfInsuranceId);

    /**
     * 修改商业险信息
     *
     * @param types
     * @return TypesOfInsuranceEntity
     */
    TypesOfInsuranceEntity update(TypesOfInsuranceEntity types);

    /**
     * 根据商业险名称进行模糊查询
     *
     * @param insuranceName
     * @return List<TypesOfInsuranceEntity>
     */
    List<TypesOfInsuranceEntity> findAllByInsuranceNameContaining(String insuranceName);


    /**
     * 分页查询商业险
     *
     * @param pageable
     * @return Page<TypesOfInsuranceEntity>
     */
    Page<TypesOfInsuranceEntity> findAll(Pageable pageable);

    /**
     * 动态查询
     *
     * @param insuranceName
     * @param pageSize
     * @param pageNumber
     * @return Page<TypesOfInsuranceEntity>
     */

    Page<TypesOfInsuranceEntity> findAllTypesOfInsuranceEntitiesDynamic(String insuranceName, Integer pageSize, Integer pageNumber);
}

