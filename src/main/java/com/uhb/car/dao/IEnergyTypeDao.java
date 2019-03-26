package com.uhb.car.dao;

import com.uhb.car.entity.EnergyTypeEntity;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Dome interface:对能源信息进行CRUD IEnergyTypeDao
 * @Author: LJW
 * @Date: 2019/3/23 12:23
 * @Version 1.0
 */
public interface IEnergyTypeDao extends
        JpaRepository<EnergyTypeEntity, Integer>,
        CrudRepository<EnergyTypeEntity, Integer>,
        PagingAndSortingRepository<EnergyTypeEntity, Integer>,
        JpaSpecificationExecutor<EnergyTypeEntity>,
        DataTablesRepository<EnergyTypeEntity, Integer> {
}
