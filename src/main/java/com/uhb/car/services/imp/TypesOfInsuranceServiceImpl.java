package com.uhb.car.services.imp;

import com.uhb.car.dao.ITypesOfInsuranceDao;
import com.uhb.car.entity.TypesOfInsuranceEntity;
import com.uhb.car.services.ITypesOfInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:TypesOfInsuranceServiceImpl
 * @Author: LJW
 * @Date: 2019/3/17 14:22
 * @Version 1.0
 */
@Service
public class TypesOfInsuranceServiceImpl implements ITypesOfInsuranceService {
    @Autowired
    ITypesOfInsuranceDao iTypesOfInsuranceDao;

    @Override
    public TypesOfInsuranceEntity saveByTypesOfInsuranceEntity(TypesOfInsuranceEntity typesOfInsurance) {
        return iTypesOfInsuranceDao.save(typesOfInsurance);
    }

    @Override
    public void deleteByTypesOfInsuranceId(Integer typesOfInsuranceId) {
        iTypesOfInsuranceDao.deleteById(typesOfInsuranceId);
    }

    @Override
    public TypesOfInsuranceEntity updateByTypesOfInsuranceEntity(TypesOfInsuranceEntity typesOfInsurance) {
        return iTypesOfInsuranceDao.save(typesOfInsurance);
    }

    @Override
    public Page<TypesOfInsuranceEntity> findAllByTypesOfInsuranceEntityPaging(Integer pageSize, Integer pageNumber) {
        Pageable pageable = new PageRequest(pageSize, pageNumber);
        return iTypesOfInsuranceDao.findAll(pageable);
    }
}
