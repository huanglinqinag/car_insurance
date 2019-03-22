package com.uhb.car.dao;

import com.uhb.car.entity.TypesOfInsuranceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @Dome interface:商业险的CRUD Dao
 * @Author: LJW
 * @Date: 2019/3/17 14:16
 * @Version 1.0
 */
public interface ITypesOfInsuranceDao extends JpaRepository<TypesOfInsuranceEntity, Integer>, CrudRepository<TypesOfInsuranceEntity, Integer>, PagingAndSortingRepository<TypesOfInsuranceEntity, Integer>, JpaSpecificationExecutor<TypesOfInsuranceEntity> {
}