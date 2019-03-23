package com.uhb.car.dao;

import com.uhb.car.entity.NatureOfVehicleUseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Dome interface:INatureOfVehicleUseDao
 * @Author: LJW
 * @Date: 2019/3/22 22:48
 * @Version 1.0
 */
public interface INatureOfVehicleUseDao extends JpaRepository<NatureOfVehicleUseEntity, Integer>, CrudRepository<NatureOfVehicleUseEntity, Integer>, PagingAndSortingRepository<NatureOfVehicleUseEntity, Integer>, JpaSpecificationExecutor<NatureOfVehicleUseEntity> {
}
