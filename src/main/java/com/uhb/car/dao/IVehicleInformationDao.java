package com.uhb.car.dao;

import com.uhb.car.entity.VehicleInformationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
public interface IVehicleInformationDao extends JpaRepository<VehicleInformationEntity, Integer>, CrudRepository<VehicleInformationEntity, Integer>, PagingAndSortingRepository<VehicleInformationEntity, Integer>, JpaSpecificationExecutor<VehicleInformationEntity> {
    /**
     * 添加一条车辆信息
     *
     * @param vehicleInformation
     * @return VehicleInformationEntity
     */
    @Override
    VehicleInformationEntity save(VehicleInformationEntity vehicleInformation);

    /**
     * 根据Id删除车辆信息
     *
     * @param vehicleId
     */
    void deleteId(Integer vehicleId);

    /**
     * 分页查询所有车辆信息
     *
     * @param pageable
     * @return Page<VehicleInformationEntity>
     */
    @Override
    Page<VehicleInformationEntity> findAll(Pageable pageable);
}
