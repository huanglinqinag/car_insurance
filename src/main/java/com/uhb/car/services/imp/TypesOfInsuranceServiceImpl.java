package com.uhb.car.services.imp;

import com.uhb.car.dao.ITypesOfInsuranceDao;
import com.uhb.car.entity.TypesOfInsuranceEntity;
import com.uhb.car.services.ITypesOfInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public int deleteAllByTypesOfInsuranceId(int typesOfInsuranceId) {
        return iTypesOfInsuranceDao.deleteAllByTypesOfInsuranceId(typesOfInsuranceId);
    }

    @Override
    public Page<TypesOfInsuranceEntity> findAll(Pageable pageable) {
        return iTypesOfInsuranceDao.findAll(pageable);
    }

    @Override
    public Page<TypesOfInsuranceEntity> findAllTypesOfInsuranceEntities(int typesOfInsuranceId, String insuranceName, Pageable pageable) {
        return iTypesOfInsuranceDao.findAll(new Specification<TypesOfInsuranceEntity>() {
            @Override
            public Predicate toPredicate(Root<TypesOfInsuranceEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (0 != typesOfInsuranceId) {
                    predicateList.add(criteriaBuilder.equal(root.get("typesOfInsuranceId"), typesOfInsuranceId));
                }
                if (null != insuranceName) {
                    predicateList.add(criteriaBuilder.like(root.get("insuranceName"), "%" + insuranceName + "%"));
                }
                Predicate[] predicates = new Predicate[predicateList.size()];
                return criteriaBuilder.and(predicateList.toArray(predicates));
            }
        }, pageable);
    }
}
