package com.uhb.car.services.imp;

import com.uhb.car.dao.ICarOwnerDao;
import com.uhb.car.entity.CarOwnerEntity;
import com.uhb.car.services.ICarOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @Dome Class:实现对车主信息的CRUD CarOwnerServiceImpl
 * @Author: LJW
 * @Date: 2019/3/19 19:07
 * @Version 1.0
 */
@Service
public class CarOwnerServiceImpl implements ICarOwnerService {
    @Autowired
    ICarOwnerDao iCarOwnerDao;

    /**
     * 添加车主信息
     *
     * @param carOwner
     * @return CarOwnerEntity
     */
    @Override
    public CarOwnerEntity save(CarOwnerEntity carOwner) {
        return iCarOwnerDao.save(carOwner);
    }

    /**
     * 根据车主Id进行删除
     *
     * @param carOwnerId
     * @return
     */
    @Override
    public void deleteById(Integer carOwnerId) {
        iCarOwnerDao.deleteById(carOwnerId);
    }

    @Override
    public CarOwnerEntity update(CarOwnerEntity carOwner) {
        return iCarOwnerDao.save(carOwner);
    }

    /**
     * 分页查询车主信息
     *
     * @param pageable
     * @return
     */
    @Override
    public Page<CarOwnerEntity> findAll(Pageable pageable) {
        return iCarOwnerDao.findAll(pageable);
    }
}
