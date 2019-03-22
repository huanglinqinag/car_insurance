package com.uhb.car.dao;

import com.uhb.car.entity.InventoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Dome interface:IInventoryDao对保单进行CRUD操作
 * @Author: LJW
 * @Date: 2019/3/18 13:55
 * @Version 1.0
 */
public interface IInventoryDao extends JpaRepository<InventoryEntity, Integer>, CrudRepository<InventoryEntity, Integer>, PagingAndSortingRepository<InventoryEntity, Integer>, JpaSpecificationExecutor<InventoryEntity> {
}
