package com.uhb.car.services.imp;

import com.uhb.car.dao.ICarOwnerDao;
import com.uhb.car.entity.CarOwnerEntity;
import com.uhb.car.services.ICarOwnerService;
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
 * @Dome Class:实现对车主信息的CRUD操作 CarOwnerServiceImpl
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

    @Override
    public Page<CarOwnerEntity> findAllByCarOwnerEntitiesDynamic(CarOwnerEntity carOwner, Integer pageSize, Integer pageNumber) {
        Pageable pageable = new PageRequest(pageSize, pageNumber);
        return iCarOwnerDao.findAll(new Specification<CarOwnerEntity>() {
            @Override
            public Predicate toPredicate(Root<CarOwnerEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (null != carOwner.getTheOwnerName()) {
                    predicateList.add(criteriaBuilder.like(root.get("theOwnerName"), "%" + carOwner.getTheOwnerName() + "%"));
                }
                if (null != carOwner.getNatrueOfTheOwner()) {
                    predicateList.add(criteriaBuilder.like(root.get("natrueOfTheOwner"), "%" + carOwner.getNatrueOfTheOwner() + "%"));
                }
                if (0 != carOwner.getIdTypeId()) {
                    predicateList.add(criteriaBuilder.equal(root.get("idTypeId"), carOwner.getIdTypeId()));
                }
                if (null != carOwner.getIdNumber()) {
                    predicateList.add(criteriaBuilder.like(root.get("idNumber"), "%" + carOwner.getIdNumber() + "%"));
                }
                Predicate[] predicates = new Predicate[predicateList.size()];
                return criteriaBuilder.and(predicateList.toArray(predicates));
            }
        }, pageable);
    }
}
