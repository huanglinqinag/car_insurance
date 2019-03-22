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
    public TypesOfInsuranceEntity save(TypesOfInsuranceEntity types) {
        return iTypesOfInsuranceDao.save(types);
    }

    @Override
    public void deleteById(int typesOfInsuranceId) {
        iTypesOfInsuranceDao.deleteById(typesOfInsuranceId);
    }

    @Override
    public TypesOfInsuranceEntity update(TypesOfInsuranceEntity types) {
        return iTypesOfInsuranceDao.save(types);
    }

    @Override
    public List<TypesOfInsuranceEntity> findAllByInsuranceNameContaining(String insuranceName) {
        return iTypesOfInsuranceDao.findAllByInsuranceNameContaining(insuranceName);
    }


    @Override
    public Page<TypesOfInsuranceEntity> findAll(Pageable pageable) {
        return iTypesOfInsuranceDao.findAll(pageable);
    }


    @Override
    public Page<TypesOfInsuranceEntity> findAllTypesOfInsuranceEntitiesDynamic(String insuranceName, Integer pageSize, Integer pageNumber) {
        Pageable pageable = new PageRequest(pageSize, pageNumber);
        return iTypesOfInsuranceDao.findAll(new Specification<TypesOfInsuranceEntity>() {
            @Override
            public Predicate toPredicate(Root<TypesOfInsuranceEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (null != insuranceName) {
                    predicateList.add(criteriaBuilder.like(root.get("insuranceName"), "%" + insuranceName + "%"));
                }
                Predicate[] predicates = new Predicate[predicateList.size()];
                return criteriaBuilder.and(predicateList.toArray(predicates));
            }
        }, pageable);
    }
}
