package com.uhb.car.services;

import com.uhb.car.entity.TypesOfInsuranceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @interfaceName:对商业险进行CUDR ITypesOfInsuranceService
 * @Author: LJW
 * @Date: 2019/3/17 14:53
 * @Version 1.0
 */
public interface ITypesOfInsuranceService {
    /**
     * 添加一条商业险数据
     *
     * @param typesOfInsurance
     * @return
     */
    TypesOfInsuranceEntity saveByTypesOfInsuranceEntity(TypesOfInsuranceEntity typesOfInsurance);

    /**
     * 根据商业险Id进行删除
     *
     * @param typesOfInsuranceId
     */
    void deleteByTypesOfInsuranceId(Integer typesOfInsuranceId);

    /**
     * 修改一条商业险数据
     *
     * @param typesOfInsurance
     * @return TypesOfInsuranceEntity
     */
    TypesOfInsuranceEntity updateByTypesOfInsuranceEntity(TypesOfInsuranceEntity typesOfInsurance);

    /**
     * 分页查询商业险信息
     *
     * @param pageSize
     * @param pageNumber
     * @return Page<TypesOfInsuranceEntity>
     */
    Page<TypesOfInsuranceEntity> findAllByTypesOfInsuranceEntityPaging(Integer pageSize, Integer pageNumber);

    /**
     * 动态分页查询商业险信息
     *
     * @param typesOfInsurance
     * @param pageSize
     * @param pageNumber
     * @return Page<TypesOfInsuranceEntity>
     */
    Page<TypesOfInsuranceEntity> findAllByTypesOfInsuranceEntityDynamic(TypesOfInsuranceEntity typesOfInsurance, Integer pageSize, Integer pageNumber);

}

