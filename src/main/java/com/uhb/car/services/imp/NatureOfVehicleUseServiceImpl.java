package com.uhb.car.services.imp;

import com.uhb.car.dao.INatureOfVehicleUseDao;
import com.uhb.car.entity.NatureOfVehicleUseEntity;
import com.uhb.car.services.INatureOfVehicleUseService;
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
 * @Dome Class:NatureOfVehicleUseServiceImpl
 * @Author: LJW
 * @Date: 2019/3/22 22:59
 * @Version 1.0
 */
@Service
public class NatureOfVehicleUseServiceImpl implements INatureOfVehicleUseService {
    @Autowired
    INatureOfVehicleUseDao iNatureOfVehicleUseDao;

    @Override
    public NatureOfVehicleUseEntity saveByNatureOfVehicleUseEntity(NatureOfVehicleUseEntity natureOfVehicleUse) {
        return iNatureOfVehicleUseDao.save(natureOfVehicleUse);
    }

    @Override
    public void deleteByNatureOfVehicleUseEntity(Integer natureOfVehicleUseId) {
        iNatureOfVehicleUseDao.deleteById(natureOfVehicleUseId);
    }

    @Override
    public NatureOfVehicleUseEntity updateByNatureOfVehicleUseEntity(NatureOfVehicleUseEntity natureOfVehicleUse) {
        return null;
    }

    @Override
    public Page<NatureOfVehicleUseEntity> findByNatureOfVehicleUseEntityPaging(Integer pageSize, Integer pageNumber) {
        Pageable pageable = new PageRequest(pageSize, pageNumber);
        return iNatureOfVehicleUseDao.findAll(pageable);
    }

    @Override
    public Page<NatureOfVehicleUseEntity> findByNatureOfVehicleUseEntityPagingDynamic(NatureOfVehicleUseEntity natureOfVehicleUse, Integer pageSize, Integer pageNumber) {

        Pageable pageable = new PageRequest(pageSize, pageNumber);
        return iNatureOfVehicleUseDao.findAll(new Specification<NatureOfVehicleUseEntity>() {
            @Override
            public Predicate toPredicate(Root<NatureOfVehicleUseEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (null != natureOfVehicleUse.getNatureName()) {
                    predicateList.add(criteriaBuilder.like(root.get("natureName"), "%" + natureOfVehicleUse.getNatureName() + "%"));
                }
                Predicate[] predicates = new Predicate[predicateList.size()];
                return criteriaBuilder.and(predicateList.toArray(predicates));
            }
        }, pageable);
    }
}
