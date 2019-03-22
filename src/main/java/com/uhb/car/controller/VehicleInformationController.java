package com.uhb.car.controller;

import com.uhb.car.bean.ResponseBean;
import com.uhb.car.dao.IVehicleInformationDao;
import com.uhb.car.entity.VehicleInformationEntity;
import com.uhb.car.services.IVehicleInformationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseBean deleteByVehicleId(Integer vehicleId) {
        try {
            iVehicleInformationService.deleteByVehicleId(vehicleId);
            return new ResponseBean(200, "成功", vehicleId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UnauthorizedException();
        }
    }
}
