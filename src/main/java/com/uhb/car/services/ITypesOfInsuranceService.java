package com.uhb.car.services;

import com.uhb.car.entity.TypesOfInsuranceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @interfaceName:ITypesOfInsuranceService
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
    int deleteAllByTypesOfInsuranceId(int typesOfInsuranceId);

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
     * @param typesOfInsuranceId
     * @param insuranceName
     * @param pageable
     * @return Page<TypesOfInsuranceEntity>
     */
    Page<TypesOfInsuranceEntity> findAllTypesOfInsuranceEntities(int typesOfInsuranceId, String insuranceName, Pageable pageable);
}
