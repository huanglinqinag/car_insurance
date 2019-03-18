package com.uhb.car.dao;

import com.uhb.car.entity.TypesOfInsuranceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @interfaceName:ITypesOfInsuranceDao
 * @Author: LJW
 * @Date: 2019/3/17 14:16
 * @Version 1.0
 */
public interface ITypesOfInsuranceDao extends JpaRepository<TypesOfInsuranceEntity, Integer>, CrudRepository<TypesOfInsuranceEntity, Integer>, PagingAndSortingRepository<TypesOfInsuranceEntity, Integer>, JpaSpecificationExecutor<TypesOfInsuranceEntity> {
    /**
     * 添加一条商业险
     *
     * @param types
     * @return TypesOfInsuranceEntity
     */
    @Override
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
    @Override
    Page<TypesOfInsuranceEntity> findAll(Pageable pageable);
}