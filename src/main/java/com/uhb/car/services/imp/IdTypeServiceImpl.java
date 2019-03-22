package com.uhb.car.services.imp;

import com.uhb.car.dao.IIdTypeDao;
import com.uhb.car.entity.IdTypeEntity;
import com.uhb.car.services.IIdTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @Dome Class:IdTypeServiceImpl
 * @Author: LJW
 * @Date: 2019/3/22 09:21
 * @Version 1.0
 */
@Service
public class IdTypeServiceImpl implements IIdTypeService {
    @Autowired
    IIdTypeDao iIdTypeDao;

    @Override
    public IdTypeEntity saveByIdTypeEntity(IdTypeEntity idType) {
        return iIdTypeDao.save(idType);
    }

    @Override
    public void deleteByIdTypeEntity(Integer idTypeId) {
        iIdTypeDao.deleteById(idTypeId);
    }

    @Override
    public IdTypeEntity updateByIdTypeEntity(IdTypeEntity idType) {
        return iIdTypeDao.save(idType);
    }

    @Override
    public Page<IdTypeEntity> findAllByIdTypeEntity(Integer pageSize, Integer pageNumber) {
        Pageable pageable = new PageRequest(pageSize, pageNumber);
        return iIdTypeDao.findAll(pageable);
    }
}
