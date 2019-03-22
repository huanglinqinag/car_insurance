package com.uhb.car.services;

import com.uhb.car.entity.InventoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @interfaceName:IInventoryService
 * @Author: LJW
 * @Date: 2019/3/18 14:15
 * @Version 1.0
 */
public interface IInventoryService {
    /**
     * 添加保险
     *
     * @param inventory
     * @return InventoryEntity
     */
    InventoryEntity saveByInventoryEntity(InventoryEntity inventory);

    /**
     * 根据保单信息id删除
     *
     * @param inventoryId
     */
    void deleteByInventoryId(Integer inventoryId);

    /**
     * 修改保单信息
     *
     * @param inventory
     * @return InventoryEntity
     */
    InventoryEntity updateByInventoryEntity(InventoryEntity inventory);

    /**
     * 分页查询所有保单信息
     *
     * @param pageSize
     * @param pageNumber
     * @return Page<InventoryEntity>
     */
    Page<InventoryEntity> findAllByInventoryEntityPaging(Integer pageSize, Integer pageNumber);

    /**
     * 动态分页查询保单信息
     *
     * @param inventory
     * @param pageSize
     * @param pageNumber
     * @return Page<InventoryEntity>
     */
    Page<InventoryEntity> findByInventoryEntityDynamic(Integer pageSize, Integer pageNumber, InventoryEntity inventory);
}
