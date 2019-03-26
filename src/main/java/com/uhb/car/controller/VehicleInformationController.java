package com.uhb.car.controller;

import com.uhb.car.bean.ResponseBean;
import com.uhb.car.dao.IVehicleInformationDao;
import com.uhb.car.entity.VehicleInformationEntity;
import com.uhb.car.entity.VehicleTypeEntity;
import com.uhb.car.services.IVehicleInformationService;
import com.uhb.car.util.interfaceLog.Log;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Dome Class:VehicleInformationController
 * @Author: LJW
 * @Date: 2019/3/22 11:09
 * @Version 1.0
 */
@Api(tags = "车辆信息")
@RestController
@RequestMapping(value = "/VehicleInformation")
public class VehicleInformationController {
    @Autowired
    IVehicleInformationService iVehicleInformationService;

    @Autowired
    IVehicleInformationDao iVehicleInformationDao;

    @ApiOperation(value = "添加一条车辆信息", notes = "需要11条数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "vehicleId", value = "车辆信息Id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "licensePlateNumber", value = "车牌号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "vin", value = "车架号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "engineNumber", value = "发动机号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "vehicleTypeId", value = "车辆种类", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "natureOfVehicleUseId", value = "车辆使用性质", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "dateOfInitialRegistration", value = "初次登记的日期", required = true, dataType = "String"),
            @ApiImplicitParam(name = "energyTypeId", value = "能源种类", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "picture", value = "行驶证图片", required = true, dataType = "String"),
            @ApiImplicitParam(name = "displacementId", value = "排量", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "seating", value = "座位数", required = true, dataType = "Integer"),

    })
    @RequestMapping(value = "/saveVehicleInformationEntity", method = RequestMethod.GET)
    public ResponseBean saveVehicleInformationEntity(VehicleInformationEntity vehicleInformation) {
        VehicleInformationEntity vehicleInformationEntity = iVehicleInformationService.saveVehicleInformationEntity(vehicleInformation);
        if (null != vehicleInformationEntity) {
            return new ResponseBean(200, "成功", vehicleInformationEntity);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "根据车辆信息Id删除")
    @ApiImplicitParam(name = "vehicleId", value = "车辆信息Id", required = true, dataType = "Integer")
    @RequestMapping(value = "deleteByVehicleId", method = RequestMethod.GET)
    @Log(operationType = "删除操作", operationName = "删除保单")
    public ResponseBean deleteByVehicleId(Integer vehicleId) {
        try {
            iVehicleInformationService.deleteByVehicleId(vehicleId);
            return new ResponseBean(200, "成功", vehicleId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "修改一条车辆信息", notes = "需要11条数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "vehicleId", value = "车辆信息Id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "licensePlateNumber", value = "车牌号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "vin", value = "车架号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "engineNumber", value = "发动机号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "vehicleTypeId", value = "车辆种类", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "natureOfVehicleUseId", value = "车辆使用性质", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "dateOfInitialRegistration", value = "初次登记的日期", required = true, dataType = "String"),
            @ApiImplicitParam(name = "energyTypeId", value = "能源种类", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "picture", value = "行驶证图片", required = true, dataType = "String"),
            @ApiImplicitParam(name = "displacementId", value = "排量", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "seating", value = "座位数", required = true, dataType = "Integer"),

    })
    @RequestMapping(value = "/updateVehicleInformationEntity", method = RequestMethod.GET)
    public ResponseBean updateVehicleInformationEntity(VehicleInformationEntity vehicleInformation) {
        VehicleInformationEntity vehicleInformationEntity = iVehicleInformationService.updateVehicleInformationEntity(vehicleInformation);
        if (null != vehicleInformationEntity) {
            return new ResponseBean(200, "成功", vehicleInformationEntity);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "分页查询车辆信息", notes = "需要分页的页数和每页显示的条数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageNumber", value = "每页显示数据条数", required = true, dataType = "Integer"),

    })
    @RequestMapping(value = "/findAllByVehicleInformationEntityPaging", method = RequestMethod.GET)
    public ResponseBean findAllByVehicleInformationEntityPaging(Integer pageSize, Integer pageNumber) {
        Page<VehicleInformationEntity> vehicleInformationEntities = iVehicleInformationService.findAllByVehicleInformationEntityPaging(pageSize, pageNumber);
        if (null != vehicleInformationEntities) {
            return new ResponseBean(200, "成功", vehicleInformationEntities);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "动态分页查询", notes = "需要6个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "licensePlateNumber", value = "车牌号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "vin", value = "车架号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "engineNumber", value = "发动机号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "vehicleTypeId", value = "车辆种类", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "natureOfVehicleUseId", value = "车辆使用性质", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "energyTypeId", value = "能源种类", required = true, dataType = "Integer"),
    })
    @RequestMapping(value = "/findAllByVehicleInformationEntityDynamicOne", method = RequestMethod.GET)
    public ResponseBean findAllByVehicleInformationEntityDynamicOne(VehicleInformationEntity vehicleInformation, Integer pageSize, Integer pageNumber) {
        Page<VehicleInformationEntity> vehicleInformationEntities = iVehicleInformationService.findAllByVehicleInformationEntityDynamic(vehicleInformation, pageSize, pageNumber);
        if (null != vehicleInformationEntities) {
            return new ResponseBean(200, "成功", vehicleInformationEntities);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "动态分页查询", notes = "需要模糊查询")
    @RequestMapping(value = "/findAllByVehicleInformationEntityDynamic", method = RequestMethod.GET)
    public DataTablesOutput<VehicleInformationEntity> findAllByVehicleTypeEntityDynamic(@Valid DataTablesInput input) {
        return iVehicleInformationDao.findAll(input);
    }
}
