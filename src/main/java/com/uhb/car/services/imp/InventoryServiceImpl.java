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
 * @ClassName:实现对保单信息的CRUD操作 InventoryServiceImpl
 * @Author: LJW
 * @Date: 2019/3/18 14:16
 * @Version 1.0
 */
@Service
public class InventoryServiceImpl implements IInventoryService {
    @Autowired
    IInventoryDao iInventoryDao;


    @Override
    public InventoryEntity saveByInventoryEntity(InventoryEntity inventory) {
        return iInventoryDao.save(inventory);
    }

    @Override
    public void deleteByInventoryId(Integer inventoryId) {
        iInventoryDao.deleteById(inventoryId);
    }

    @Override
    public InventoryEntity updateByInventoryEntity(InventoryEntity inventory) {
        return iInventoryDao.save(inventory);
    }

    @Override
    public Page<InventoryEntity> findAllByInventoryEntityPaging(Integer pageSize, Integer pageNumber) {
        Pageable pageable = new PageRequest(pageSize, pageNumber);
        return iInventoryDao.findAll(pageable);
    }

    @Override
    public Page<InventoryEntity> findByInventoryEntityDynamic(Integer pageSize, Integer pageNumber, InventoryEntity inventory) {
        Pageable pageable = new PageRequest(pageSize, pageNumber);
        return iInventoryDao.findAll(new Specification<InventoryEntity>() {
            @Override
            public Predicate toPredicate(Root<InventoryEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (null != inventory.getTypesName()) {
                    predicateList.add(criteriaBuilder.like(root.get("typesName"), "%" + inventory.getTypesName() + "%"));
                }
                if (0 != inventory.getVehicleId()) {
                    predicateList.add(criteriaBuilder.equal(root.get("vehicleId"), inventory.getVehicleId()));
                }
                if (0 != inventory.getCarOwnerId()) {
                    predicateList.add(criteriaBuilder.equal(root.get("carOwnerId"), inventory.getTypesName()));
                }
                if (0 != inventory.getVehicleAndVesselTaxId()) {
                    predicateList.add(criteriaBuilder.equal(root.get("vehicleAndVesselTaxId"), inventory.getTypesName()));
                }
                Predicate[] predicates = new Predicate[predicateList.size()];
                return criteriaBuilder.and(predicateList.toArray(predicates));
            }
        }, pageable);
    }
}
