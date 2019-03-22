package com.uhb.car.dao;

import com.uhb.car.entity.DisplacementEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Dome interface:对汽车排量进行 CRUD Dao
 * @Author: LJW
 * @Date: 2019/3/19 17:40
 * @Version 1.0
 */
public interface IDisplacementDao extends JpaRepository<DisplacementEntity, Integer>, CrudRepository<DisplacementEntity, Integer>, PagingAndSortingRepository<DisplacementEntity, Integer>, JpaSpecificationExecutor<DisplacementEntity> {
    /**
     * 新增一条汽车排量信息
     *
     * @param displacement
     * @return DisplacementEntity
     */
    @Override
    DisplacementEntity save(DisplacementEntity displacement);

    /**
     * 根据车俩排练Id进行删除
     *
     * @param displacementId
     * @return int
     */
    int deleteAllByDisplacementId(Integer displacementId);

    /**
     * 分页查询所有排量信息
     *
     * @param pageable
     * @return Page<DisplacementEntity>
     */
    @Override
    Page<DisplacementEntity> findAll(Pageable pageable);

}
