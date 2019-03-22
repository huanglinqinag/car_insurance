package com.uhb.car.services.imp;

import com.uhb.car.dao.IDisplacementDao;
import com.uhb.car.entity.DisplacementEntity;
import com.uhb.car.services.IDisplacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @Dome Class:DisplacementServiceImpl
 * @Author: LJW
 * @Date: 2019/3/19 18:05
 * @Version 1.0
 */
@Service
public class DisplacementServiceImpl implements IDisplacementService {
    @Autowired
    IDisplacementDao iDisplacementDao;

    @Override
    public DisplacementEntity saveByDisplacementEntity(DisplacementEntity displacementEntity) {
        return iDisplacementDao.save(displacementEntity);
    }

    @Override
    public void deleteByDisplacementId(Integer displacementId) {
        iDisplacementDao.deleteById(displacementId);
    }

    @Override
    public DisplacementEntity updateByDisplacementEntity(DisplacementEntity displacementEntity) {
        return iDisplacementDao.save(displacementEntity);
    }

    @Override
    public Page<DisplacementEntity> findAllByDisplacementEntityPaging(Integer pageSize, Integer pageNumber) {
        Pageable pageable = new PageRequest(pageSize, pageNumber);
        return iDisplacementDao.findAll(pageable);
    }
}
