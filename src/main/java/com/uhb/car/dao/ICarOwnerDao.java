package com.uhb.car.dao;

import com.uhb.car.entity.CarOwnerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
public interface ICarOwnerDao extends JpaRepository<CarOwnerEntity, Integer>, CrudRepository<CarOwnerEntity, Integer>, PagingAndSortingRepository<CarOwnerEntity, Integer>, JpaSpecificationExecutor<CarOwnerEntity> {
    /**
     * 添加车主信息
     *
     * @param carOwner
     * @return CarOwnerEntity
     */
    @Override
    CarOwnerEntity save(CarOwnerEntity carOwner);

    /**
     * 根据车主信息Id进行删除
     *
     * @param carOwnerId
     * @return int
     */
    @Override
    void deleteById(Integer carOwnerId);

    /**
     * 分页查询车主信息
     *
     * @param pageable
     * @return
     */
    @Override
    Page<CarOwnerEntity> findAll(Pageable pageable);
}
