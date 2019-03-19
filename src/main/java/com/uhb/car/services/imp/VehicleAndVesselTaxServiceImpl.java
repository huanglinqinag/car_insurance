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

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:IVehicleAndVesselTaxService
 * @Author: LJW
 * @Date: 2019/3/17 13:15
 * @Version 1.0
 */


@Service
public class VehicleAndVesselTaxServiceImpl implements IVehicleAndVesselTaxService {
    @Autowired
    IVehicleAndVesselTaxDao iVehicleAndVesselTaxDao;


    @Override
    public VehicleAndVesselTaxEntity save(VehicleAndVesselTaxEntity vehicleAndVesselTaxEntity) {
        return iVehicleAndVesselTaxDao.save(vehicleAndVesselTaxEntity);
    }


//        @Override
//        public int deleteByVehicleAndVesselTaxId(int vehicleAndVesselTaxId) {
//            return iVehicleAndVesselTaxDao.deleteByVehicleAndVesselTaxId(vehicleAndVesselTaxId);
//        }


    @Override
    public Page<VehicleAndVesselTaxEntity> findVesselTaxEntitiesDynamic(DisplacementEntity displacementEntity, Integer pageNumber, Integer pageSize) {
        Pageable pageable = new PageRequest(pageSize, pageNumber);
        return iVehicleAndVesselTaxDao.findAll(new Specification<VehicleAndVesselTaxEntity>() {
            @Override
            public Predicate toPredicate(Root<VehicleAndVesselTaxEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                Predicate[] predicates = new Predicate[predicateList.size()];
                return criteriaBuilder.and(predicateList.toArray(predicates));
            }
        }, pageable);

    }

    @Override
    public Page<VehicleAndVesselTaxEntity> findAll(Pageable pageable) {
        return iVehicleAndVesselTaxDao.findAll(pageable);
    }
}
