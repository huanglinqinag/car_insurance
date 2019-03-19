package com.uhb.car.dao;

import com.uhb.car.entity.VehicleAndVesselTaxEntity;
import com.uhb.car.entity.VehicleTypeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Demo interface: IVehicleTypeDao
 *
 * @Auther: LJW
 * @version:V1.0
 * @Date: 2019/3/17 12:56
 * @Description: TODO
 */
@Repository
public interface IVehicleTypeDao extends JpaRepository<VehicleTypeEntity, Integer>, CrudRepository<VehicleTypeEntity, Integer>, PagingAndSortingRepository<VehicleTypeEntity, Integer>, JpaSpecificationExecutor<VehicleTypeEntity> {
    /**
     * 添加车辆类型
     *
     * @param vehicleTypeEntity
     * @return VehicleTypeEntity
     */
    @Override
    VehicleTypeEntity save(VehicleTypeEntity vehicleTypeEntity);

    /**
     * 模糊查询
     *
     * @param typeName
     * @return
     */
    List<VehicleTypeEntity> findAllByTypeNameContaining(String typeName);

    /**
     * 根据车辆类型id删除
     *
     * @param id
     */
    @Override
    void deleteById(Integer id);

    /**
     * fetch data by rule id
     * 分页查询所有车辆类型
     *
     * @param pageable
     * @return List<VehicleTypeEntity>
     */
    @Override
    Page<VehicleTypeEntity> findAll(Pageable pageable);


}
