package com.uhb.car.services.imp;

import com.uhb.car.dao.ICarOwnerDao;
import com.uhb.car.entity.CarOwnerEntity;
import com.uhb.car.services.ICarOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    @Override
    public CarOwnerEntity saveByCarOwnerEntity(CarOwnerEntity carOwnerEntity) {
        return iCarOwnerDao.save(carOwnerEntity);
    }

    @Override
    public void deleteByCarOwnerId(Integer carOwnerId) {
        iCarOwnerDao.deleteById(carOwnerId);
    }

    @Override
    public CarOwnerEntity updateByCarOwnerEntity(CarOwnerEntity carOwnerEntity) {
        return iCarOwnerDao.save(carOwnerEntity);
    }

    @Override
    public Page<CarOwnerEntity> findAllByCarOwnerEntitiesPaging(Integer pageSize, Integer pageNumber) {
        Pageable pageable = new PageRequest(pageSize, pageNumber);
        return iCarOwnerDao.findAll(pageable);
    }
}
