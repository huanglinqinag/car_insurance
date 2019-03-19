package com.uhb.car.services.imp;

import com.uhb.car.dao.IVehicleTypeDao;
import com.uhb.car.entity.VehicleTypeEntity;
import com.uhb.car.services.IVehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.*;

/**
 * Demo class VehicleTypeServiceImpl
 *
 * @author Admin
 * @date 2019/3/9 18:13
 */
@Service
public class VehicleTypeServiceImpl implements IVehicleTypeService {
    @Autowired
    IVehicleTypeDao iVehicleTypeDao;

    @Override
    public Page<VehicleTypeEntity> findAll(Pageable pageable) {
        return iVehicleTypeDao.findAll(pageable);
    }


    @Override
    public List<VehicleTypeEntity> findAllByTypeNameContaining(String typeName) {
        return iVehicleTypeDao.findAllByTypeNameContaining(typeName);
    }

    @Override
    public Page<VehicleTypeEntity> findAllVehicleTypeEntityDynamic(String typeName, Integer pageSize, Integer pageNumber) {
        Pageable pageable = new PageRequest(pageSize, pageNumber);
        return iVehicleTypeDao.findAll(new Specification<VehicleTypeEntity>() {
            @Override
            public Predicate toPredicate(Root<VehicleTypeEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (null != typeName && !typeName.equals("")) {
                    predicateList.add(criteriaBuilder.like(root.get("typeName"), "%" + typeName + "%"));
                }
                Predicate[] predicates = new Predicate[predicateList.size()];
                return criteriaBuilder.and(predicateList.toArray(predicates));

            }
        }, pageable);
    }

    @Override
    public void deleteById(Integer id) {
        iVehicleTypeDao.deleteById(id);
    }

    @Override
    public VehicleTypeEntity save(VehicleTypeEntity vehicleTypeEntity) {
        return iVehicleTypeDao.save(vehicleTypeEntity);
    }

}
