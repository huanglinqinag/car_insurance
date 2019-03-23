package com.uhb.car.services.imp;

import com.uhb.car.dao.IEnergyTypeDao;
import com.uhb.car.entity.EnergyTypeEntity;
import com.uhb.car.services.IEnergyTypeService;
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
 * @Dome Class:EnergyTypeServiceImpl
 * @Author: LJW
 * @Date: 2019/3/23 12:34
 * @Version 1.0
 */
@Service
public class EnergyTypeServiceImpl implements IEnergyTypeService {
    @Autowired
    IEnergyTypeDao iEnergyTypeDao;

    @Override
    public EnergyTypeEntity saveEnergyTypeEntity(EnergyTypeEntity energyType) {
        return iEnergyTypeDao.save(energyType);
    }

    @Override
    public void deleteByEnergyTypeId(Integer energyTypeId) {
        iEnergyTypeDao.deleteById(energyTypeId);
    }

    @Override
    public EnergyTypeEntity updateEnergyTypeEntity(EnergyTypeEntity energyType) {
        return iEnergyTypeDao.save(energyType);
    }

    @Override
    public Page<EnergyTypeEntity> findAllByEnergyTypeEntityPaging(Integer pageSize, Integer pageNumber) {
        Pageable pageable = new PageRequest(pageSize, pageNumber);
        return iEnergyTypeDao.findAll(pageable);
    }

    @Override
    public Page<EnergyTypeEntity> findAllByEnergyTypeEntityDynamic(EnergyTypeEntity energyType, Integer pageSize, Integer pageNumber) {
        Pageable pageable = new PageRequest(pageSize, pageNumber);
        return iEnergyTypeDao.findAll(new Specification<EnergyTypeEntity>() {
            @Override
            public Predicate toPredicate(Root<EnergyTypeEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (null != energyType.getEnergyTypeName()) {
                    predicateList.add(criteriaBuilder.like(root.get("energyTypeName"), "%" + energyType.getEnergyTypeName() + "%"));
                }
                Predicate[] predicates = new Predicate[predicateList.size()];
                return criteriaBuilder.and(predicateList.toArray(predicates));
            }
        }, pageable);
    }
}
