package com.uhb.car.dao;

import com.uhb.car.entity.VehicleInformationEntity;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Dome interface:IVehicleInformationDao
 * @Author: LJW
 * @Date: 2019/3/22 08:48
 * @Version 1.0
 */
public interface IVehicleInformationDao extends
        JpaRepository<VehicleInformationEntity, Integer>,
        CrudRepository<VehicleInformationEntity, Integer>,
        PagingAndSortingRepository<VehicleInformationEntity, Integer>,
        JpaSpecificationExecutor<VehicleInformationEntity>,
        DataTablesRepository<VehicleInformationEntity, Integer> {
}
