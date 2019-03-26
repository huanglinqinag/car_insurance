package com.uhb.car.dao;

import com.uhb.car.entity.VehicleTypeEntity;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


/**
 * Demo interface: IVehicleTypeDao
 *
 * @Author: LJW
 * @version:V1.0
 * @Date: 2019/3/17 12:56
 * @Description: TODO
 */
@Repository
public interface IVehicleTypeDao extends
        JpaRepository<VehicleTypeEntity, Integer>,
        CrudRepository<VehicleTypeEntity, Integer>,
        PagingAndSortingRepository<VehicleTypeEntity, Integer>,
        JpaSpecificationExecutor<VehicleTypeEntity>,
        DataTablesRepository<VehicleTypeEntity, Integer> {
}
