package com.uhb.car.services.imp;

import com.uhb.car.dao.IInventoryDao;
import com.uhb.car.entity.InventoryEntity;
import com.uhb.car.services.IInventoryService;
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
 * @ClassName:InventoryServiceImpl
 * @Author: LJW
 * @Date: 2019/3/18 14:16
 * @Version 1.0
 */
@Service
public class InventoryServiceImpl implements IInventoryService {
    @Autowired
    IInventoryDao iInventoryDao;

    @Override
    public InventoryEntity save(InventoryEntity inventoryEntity) {
        return iInventoryDao.save(inventoryEntity);
    }

    @Override
    public void deleteById(int inventoryId) {
        iInventoryDao.deleteById(inventoryId);
    }

    @Override
    public InventoryEntity update(InventoryEntity inventoryEntity) {
        return iInventoryDao.save(inventoryEntity);
    }

    @Override
    public Page<InventoryEntity> findAll(Pageable pageable) {
        return iInventoryDao.findAll(pageable);
    }

    @Override
    public Page<InventoryEntity> findInventoryEntityDynamic(Integer pageNumber, Integer pageSize) {
        Pageable pageable = new PageRequest(pageSize, pageNumber);
        return iInventoryDao.findAll(new Specification<InventoryEntity>() {
            @Override
            public Predicate toPredicate(Root<InventoryEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                Predicate[] predicates = new Predicate[predicateList.size()];
                return criteriaBuilder.and(predicateList.toArray(predicates));
            }
        }, pageable);
    }

}
