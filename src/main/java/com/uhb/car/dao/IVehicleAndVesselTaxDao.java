package com.uhb.car.dao;

import com.uhb.car.entity.VehicleAndVesselTaxEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Dome interface:对车船税进行CRUD Dao
 * @Author: LJW
 * @Date: 2019/3/15 13:04
 * @Version 1.0
 */


public interface IVehicleAndVesselTaxDao extends
        JpaRepository<VehicleAndVesselTaxEntity, Integer>,
        CrudRepository<VehicleAndVesselTaxEntity, Integer>,
        PagingAndSortingRepository<VehicleAndVesselTaxEntity, Integer>,
        JpaSpecificationExecutor<VehicleAndVesselTaxEntity>,
        DataTablesRepository<VehicleAndVesselTaxEntity, Integer> {
}
