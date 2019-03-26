package com.uhb.car.dao;

import com.uhb.car.entity.CarOwnerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Dome interface:对车主信息进行CRUD Dao
 * @Author: LJW
 * @Date: 2019/3/19 18:44
 * @Version 1.0
 */
public interface ICarOwnerDao extends
        JpaRepository<CarOwnerEntity, Integer>,
        CrudRepository<CarOwnerEntity, Integer>,
        PagingAndSortingRepository<CarOwnerEntity, Integer>,
        JpaSpecificationExecutor<CarOwnerEntity>,
        DataTablesRepository<CarOwnerEntity, Integer> {
}
