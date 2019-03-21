package com.uhb.car.controller;

import com.uhb.car.bean.ResponseBean;
import com.uhb.car.entity.DisplacementEntity;
import com.uhb.car.entity.VehicleAndVesselTaxEntity;
import com.uhb.car.exception.UnauthorizedException;
import com.uhb.car.services.IVehicleAndVesselTaxService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @ClassName:VehicleAndVesselTaxController
 * @Author: LJW
 * @Date: 2019/3/17 13:20
 * @Version 1.0
 */


@Api(tags = "车船税")
@RestController
@RequestMapping(value = "/VehicleAndVesselTax")
public class VehicleAndVesselTaxController {
    @Autowired
    IVehicleAndVesselTaxService iVehicleAndVesselTaxService;

    @ApiOperation(value = "添加车船税", notes = "需要三个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "vehicleAndVesselTaxId", value = "车船税Id", required = true, dataType = "int"),
            @ApiImplicitParam(name = "displacementId", value = "排量", required = true, dataType = "int"),
            @ApiImplicitParam(name = "price", value = "车船税Id", required = true, dataType = "int"),

    })
    @RequestMapping(value = "/saveVehicleAndVesselTax", method = RequestMethod.GET)
    public ResponseBean saveVehicleAndVesselTax(VehicleAndVesselTaxEntity vehicleAndVesselTaxEntity) {
        VehicleAndVesselTaxEntity vehicleAndVesselTax = iVehicleAndVesselTaxService.save(vehicleAndVesselTaxEntity);
        if (null != vehicleAndVesselTax) {
            return new ResponseBean(200, "成功", vehicleAndVesselTax);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "根据车船税Id删除", tags = "需要车船税Id")
    @ApiImplicitParam(name = "vehicleVesselTaxId", value = "车船税Id", required = true, dataType = "int")
    @RequestMapping(value = "deleteByVehicleAndVesselTaxId", method = RequestMethod.GET)
    public ResponseBean deleteByVehicleAndVesselTaxId(int vehicleVesselTaxId) {
        int i = iVehicleAndVesselTaxService.deleteByVehicleVesselTaxId(vehicleVesselTaxId);
        if (0 != i) {
            return new ResponseBean(200, "成功", i);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "分页查询", notes = "需要两个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "页数", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pageNumber", value = "每页显示条数", required = true, dataType = "int"),
    })
    @RequestMapping(value = "/findAllVehicleAndVesselTaxPaging", method = RequestMethod.GET)
    public ResponseBean findAllVehicleAndVesselTaxPaging(int pageSize, int pageNumber, Pageable pageable) {
        pageable = new PageRequest(pageSize, pageNumber);
        Page<VehicleAndVesselTaxEntity> vehicleAndVesselTaxEntityList = iVehicleAndVesselTaxService.findAll(pageable);

        if (null != vehicleAndVesselTaxEntityList) {
            return new ResponseBean(200, "成功", vehicleAndVesselTaxEntityList);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "车船税动态查询", notes = "需要页数和每页显示的条数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "页数", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pageNumber", value = "每页显示条数", required = true, dataType = "int"),
    })
    @RequestMapping(value = "/findVesselTaxEntitiesDynamic", method = RequestMethod.GET)
    public ResponseBean findVesselTaxEntitiesDynamic(DisplacementEntity displacementEntity, Integer pageNumber, Integer pageSize) {
        Page<VehicleAndVesselTaxEntity> vehicleAndVesselTaxEntities = iVehicleAndVesselTaxService.findVesselTaxEntitiesDynamic(displacementEntity, pageNumber, pageSize);
        if (null != vehicleAndVesselTaxEntities) {
            return new ResponseBean(200, "成功", vehicleAndVesselTaxEntities);
        } else {
            throw new UnauthorizedException();
        }
    }
}
