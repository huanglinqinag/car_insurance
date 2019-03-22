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
     * 添加保单
     *
     * @param inventoryEntity
     * @return InventoryEntity
     */
    InventoryEntity save(InventoryEntity inventoryEntity);

    /**
     * 删除保单
     *
     * @param inventoryId
     * @return void
     */
    void deleteById(int inventoryId);

    /**
     * 修改一条保单信息
     *
     * @param inventoryEntity
     * @return InventoryEntity
     */
    InventoryEntity update(InventoryEntity inventoryEntity);

    /**
     * 分页查询
     *
     * @param pageable
     * @return Page<InventoryEntity>
     */
    Page<InventoryEntity> findAll(Pageable pageable);

    /**
     * 动态查询保单信息
     *
     * @param pageNumber
     * @param pageSize
     * @return Page<InventoryEntity>
     */
    Page<InventoryEntity> findInventoryEntityDynamic(Integer pageNumber, Integer pageSize);
}
