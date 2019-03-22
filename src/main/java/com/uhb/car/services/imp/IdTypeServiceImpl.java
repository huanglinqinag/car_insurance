package com.uhb.car.services.imp;

import com.uhb.car.dao.IIdTypeDao;
import com.uhb.car.entity.IdTypeEntity;
import com.uhb.car.services.IIdTypeService;
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
    public void deleteByIdTypeId(Integer idTypeId) {
        iIdTypeDao.deleteById(idTypeId);
    }

    @Override
    public IdTypeEntity updateByIdTypeEntity(IdTypeEntity idType) {
        return iIdTypeDao.save(idType);
    }

    @Override
    public Page<IdTypeEntity> findAllByIdTypeEntityPaging(Integer pageSize, Integer pageNumber) {
        Pageable pageable = new PageRequest(pageSize, pageNumber);
        return iIdTypeDao.findAll(pageable);
    }

    @Override
    public Page<IdTypeEntity> findAllByIdTypeEntityDynamic(IdTypeEntity idType, Integer pageSize, Integer pageNumber) {
        Pageable pageable = new PageRequest(pageSize, pageNumber);
        return iIdTypeDao.findAll(new Specification<IdTypeEntity>() {
            @Override
            public Predicate toPredicate(Root<IdTypeEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (null != idType.getIdTypeName()) {
                    predicateList.add(criteriaBuilder.like(root.get("idTypeName"), "%" + idType.getIdTypeName() + "%"));
                }
                if (0 != idType.getOwnerNature()) {
                    predicateList.add(criteriaBuilder.equal(root.get("ownerNature"), idType.getOwnerNature()));
                }
                Predicate[] predicates = new Predicate[predicateList.size()];
                return criteriaBuilder.and(predicateList.toArray(predicates));
            }
        }, pageable);
    }
}
