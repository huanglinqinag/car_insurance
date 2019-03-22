package com.uhb.car.dao;

import com.uhb.car.entity.VehicleAndVesselTaxEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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


public interface IVehicleAndVesselTaxDao extends JpaRepository<VehicleAndVesselTaxEntity, Integer>, CrudRepository<VehicleAndVesselTaxEntity, Integer>, PagingAndSortingRepository<VehicleAndVesselTaxEntity, Integer>, JpaSpecificationExecutor<VehicleAndVesselTaxEntity> {
    /**
     * 新增一条车船税
     *
     * @param vehicleAndVesselTaxEntity
     * @return VehicleAndVesselTaxEntity
     */

    @Override
    VehicleAndVesselTaxEntity save(VehicleAndVesselTaxEntity vehicleAndVesselTaxEntity);

    /**
     * 根据车船税Id进行删除
     *
     * @param vehicleVesselTaxId
     */
    @Override
    void deleteById(Integer vehicleVesselTaxId);

    /**
     * 分页查询所有车船税
     *
     * @param pageable
     * @return Page<VehicleAndVesselTaxEntity>
     */

    @Override
    Page<VehicleAndVesselTaxEntity> findAll(Pageable pageable);
}
