package com.uhb.car.dao;

import com.uhb.car.entity.IdTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Dome interface:IIdTypeDao
 * @Author: LJW
 * @Date: 2019/3/22 09:10
 * @Version 1.0
 */
public interface IIdTypeDao extends JpaRepository<IdTypeEntity, Integer>, CrudRepository<IdTypeEntity, Integer>, PagingAndSortingRepository<IdTypeEntity, Integer>, JpaSpecificationExecutor<IdTypeEntity> {
}
