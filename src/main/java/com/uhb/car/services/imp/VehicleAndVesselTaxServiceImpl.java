package com.uhb.car.services.imp;

import com.uhb.car.dao.IVehicleAndVesselTaxDao;
import com.uhb.car.entity.VehicleAndVesselTaxEntity;
import com.uhb.car.services.IVehicleAndVesselTaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
/*

    @Override
    public int deleteByVehicleAndVesselTaxId(int vehicleAndVesselTaxId) {
        return iVehicleAndVesselTaxDao.deleteByVehicleAndVesselTaxId(vehicleAndVesselTaxId);
    }
*/

    @Override
    public Page<VehicleAndVesselTaxEntity> findAll(Pageable pageable) {
        return iVehicleAndVesselTaxDao.findAll(pageable);
    }
}
