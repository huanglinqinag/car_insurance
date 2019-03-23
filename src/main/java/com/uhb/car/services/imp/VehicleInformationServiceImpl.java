package com.uhb.car.services.imp;

import com.uhb.car.dao.IVehicleInformationDao;
import com.uhb.car.entity.VehicleInformationEntity;
import com.uhb.car.services.IVehicleInformationService;
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
 * @Dome Class:实现对车辆信息CRUD操作 VehicleInformationServiceImpl
 * @Author: LJW
 * @Date: 2019/3/22 08:58
 * @Version 1.0
 */
@Service
public class VehicleInformationServiceImpl implements IVehicleInformationService {
    @Autowired
    IVehicleInformationDao iVehicleInformationDao;

    @Override
    public VehicleInformationEntity saveVehicleInformationEntity(VehicleInformationEntity vehicleInformation) {
        return iVehicleInformationDao.save(vehicleInformation);
    }

    @Override
    public void deleteByVehicleId(Integer vehicleId) {
        iVehicleInformationDao.deleteById(vehicleId);
    }

    @Override
    public VehicleInformationEntity updateVehicleInformationEntity(VehicleInformationEntity vehicleInformation) {
        return iVehicleInformationDao.save(vehicleInformation);
    }

    @Override
    public Page<VehicleInformationEntity> findAllByVehicleInformationEntityPaging(Integer pageSize, Integer pageNumber) {
        Pageable pageable = new PageRequest(pageSize, pageNumber);
        return iVehicleInformationDao.findAll(pageable);
    }

    @Override
    public Page<VehicleInformationEntity> findAllByVehicleInformationEntityDynamic(VehicleInformationEntity vehicleInformation, Integer pageSize, Integer pageNumber) {
        Pageable pageable = new PageRequest(pageSize, pageNumber);
        return iVehicleInformationDao.findAll(new Specification<VehicleInformationEntity>() {
            @Override
            public Predicate toPredicate(Root<VehicleInformationEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (null != vehicleInformation.getLicensePlateNumber()) {
                    predicateList.add(criteriaBuilder.like(root.get("licensePlateNumber"), "%" + vehicleInformation.getLicensePlateNumber() + "%"));
                }
                if (null != vehicleInformation.getVin()) {
                    predicateList.add(criteriaBuilder.like(root.get("vin"), "%" + vehicleInformation.getVin() + "%"));
                }
                if (null != vehicleInformation.getEngineNumber()) {
                    predicateList.add(criteriaBuilder.like(root.get("engineNumber"), "%" + vehicleInformation.getEngineNumber() + "%"));
                }
                if (0 != vehicleInformation.getVehicleId()) {
                    predicateList.add(criteriaBuilder.equal(root.get("vehicleTypeId"), vehicleInformation.getVehicleId()));
                }
                if (0 != vehicleInformation.getNatureOfVehicleUseId()) {
                    predicateList.add(criteriaBuilder.equal(root.get("natureOfVehicleUseId"), vehicleInformation.getNatureOfVehicleUseId()));
                }
                if (0 != vehicleInformation.getEnergyTypeId()) {
                    predicateList.add(criteriaBuilder.equal(root.get("energyTypeId"), vehicleInformation.getEnergyTypeId()));
                }
                if (0 != vehicleInformation.getDisplacementId()) {
                    predicateList.add(criteriaBuilder.equal(root.get("displacementId"), vehicleInformation.getDisplacementId()));
                }
                Predicate[] predicates = new Predicate[predicateList.size()];
                return criteriaBuilder.and(predicateList.toArray(predicates));
            }
        }, pageable);
    }
}
