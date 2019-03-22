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
 * Demo class 实现车辆信息的CRUD
 *
 * @author Admin
 * @date 2019/3/9 18:13
 */
@Service
public class VehicleTypeServiceImpl implements IVehicleTypeService {
    @Autowired
    IVehicleTypeDao iVehicleTypeDao;

    /**
     * 添加一条车辆类型数据
     *
     * @param vehicleType
     * @return VehicleTypeEntity
     */
    @Override
    public VehicleTypeEntity saveByVehicleTypeEntity(VehicleTypeEntity vehicleType) {
        return iVehicleTypeDao.save(vehicleType);
    }

    /**
     * 根据Id删除一条车辆信息
     *
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        iVehicleTypeDao.deleteById(id);
    }

    /**
     * 修改汽车类型
     *
     * @param vehicleType
     * @return
     */
    @Override
    public VehicleTypeEntity updateByVehicleTypeEntity(VehicleTypeEntity vehicleType) {
        return iVehicleTypeDao.save(vehicleType);
    }

    /**
     * 分页查询车辆类型
     *
     * @param pageSize
     * @param pageNumber
     * @return
     */
    @Override
    public Page<VehicleTypeEntity> findAllByVehicleTypeEntitiesPaging(Integer pageSize, Integer pageNumber) {
        Pageable pageable = new PageRequest(pageSize, pageNumber);
        return iVehicleTypeDao.findAll(pageable);
    }


    /**
     * 动态查询车辆类型
     *
     * @param typeName
     * @param pageSize
     * @param pageNumber
     * @return Page<VehicleTypeEntity>
     */

    @Override
    public Page<VehicleTypeEntity> findAllByVehicleTypeEntityDynamic(String typeName, Integer pageSize, Integer pageNumber) {
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


}
