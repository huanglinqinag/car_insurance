package com.uhb.car.services.imp;

import com.uhb.car.dao.IInventoryDao;
import com.uhb.car.entity.InventoryEntity;
import com.uhb.car.services.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @ClassName:InventoryServiceImpl
 * @Author: LJW
 * @Date: 2019/3/18 14:16
 * @Version 1.0
 */
@Service
public class InventoryServiceImpl implements IInventoryService {
    @Autowired
    IInventoryDao iInventoryDao;

    @Override
    public InventoryEntity save(InventoryEntity inventoryEntity) {
        return iInventoryDao.save(inventoryEntity);
    }

    @Override
    public int deleteByInventoryId(int inventoryId) {
        return iInventoryDao.deleteByInventoryId(inventoryId);
    }

    @Override
    public Page<InventoryEntity> findAll(Pageable pageable) {
        return iInventoryDao.findAll(pageable);
    }

}
