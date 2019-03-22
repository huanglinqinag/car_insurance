package com.uhb.car.services.imp;

import com.uhb.car.dao.IDisplacementDao;
import com.uhb.car.entity.DisplacementEntity;
import com.uhb.car.services.IDisplacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    /**
     * 添加一条汽车排量信息
     *
     * @param displacement
     * @return DisplacementEntity
     */
    @Override
    public DisplacementEntity save(DisplacementEntity displacement) {
        return iDisplacementDao.save(displacement);
    }

    /**
     * 根据汽车排量Id进行删除
     *
     * @param displacementId
     * @return int
     */
    @Override
    public int deleteAllByDisplacementId(Integer displacementId) {
        return iDisplacementDao.deleteAllByDisplacementId(displacementId);
    }

    @Override
    public DisplacementEntity update(DisplacementEntity displacement) {
        return iDisplacementDao.save(displacement);
    }

    @Override
    public Page<DisplacementEntity> findAll(Pageable pageable) {
        return iDisplacementDao.findAll(pageable);
    }
}
