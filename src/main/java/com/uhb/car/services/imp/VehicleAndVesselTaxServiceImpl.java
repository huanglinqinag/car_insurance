package com.uhb.car.services.imp;

import com.uhb.car.dao.IVehicleAndVesselTaxDao;
import com.uhb.car.entity.DisplacementEntity;
import com.uhb.car.entity.VehicleAndVesselTaxEntity;
import com.uhb.car.services.IVehicleAndVesselTaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Dome Class:实现对车船税的CRUD操作 VehicleAndVesselTaxServiceImpl
 * @Author: LJW
 * @Date: 2019/3/17 13:15
 * @Version 1.0
 */


@Service
public class VehicleAndVesselTaxServiceImpl implements IVehicleAndVesselTaxService {
    @Autowired
    IVehicleAndVesselTaxDao iVehicleAndVesselTaxDao;


    @Override
    public VehicleAndVesselTaxEntity saveByVehicleAndVesselTaxEntity(VehicleAndVesselTaxEntity vehicleAndVesselTax) {
        return iVehicleAndVesselTaxDao.save(vehicleAndVesselTax);
    }

    @Override
    public void deleteByVehicleVesselTaxId(Integer vehicleVesselTaxId) {
        iVehicleAndVesselTaxDao.deleteById(vehicleVesselTaxId);
    }

    @Override
    public VehicleAndVesselTaxEntity updateByVehicleAndVesselTaxEntity(VehicleAndVesselTaxEntity vehicleAndVesselTax) {
        return iVehicleAndVesselTaxDao.save(vehicleAndVesselTax);
    }

    @Override
    public Page<VehicleAndVesselTaxEntity> findAllByVehicleAndVesselTaxEntityPaging(Integer pageSize, Integer PageNumber) {
        Pageable pageable = new PageRequest(pageSize, PageNumber);
        return iVehicleAndVesselTaxDao.findAll(pageable);
    }

    @Override
    public Page<VehicleAndVesselTaxEntity> findAllByVehicleAndVesselTaxEntityDynamic(Integer displacementId, Integer pageSize, Integer pageNumber) {
        Pageable pageable = new PageRequest(pageSize, pageNumber);
        return iVehicleAndVesselTaxDao.findAll(new Specification<VehicleAndVesselTaxEntity>() {
            @Override
            public Predicate toPredicate(Root<VehicleAndVesselTaxEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (null != displacementId) {
                    predicateList.add(criteriaBuilder.equal(root.get("displacementId"), displacementId));
                }
                Predicate[] predicates = new Predicate[predicateList.size()];
                return criteriaBuilder.and(predicateList.toArray(predicates));
            }
        }, pageable);
    }
}
