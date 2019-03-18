package com.uhb.car.controller;

import com.uhb.car.bean.ResponseBean;
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

    @ApiOperation(value = "添加车船税", tags = "不需要参数")
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public ResponseBean save(VehicleAndVesselTaxEntity vehicleAndVesselTaxEntity) {
        VehicleAndVesselTaxEntity vehicleAndVesselTax = iVehicleAndVesselTaxService.save(vehicleAndVesselTaxEntity);
        if (null != vehicleAndVesselTax) {
            return new ResponseBean(200, "成功", vehicleAndVesselTax);
        } else {
            throw new UnauthorizedException();
        }
    }

    /*@ApiOperation(value = "根据车船税Id删除", tags = "需要车船税Id")
    @ApiImplicitParam(name = "vehicleAndVesselTaxId", value = "车船税Id", required = true, dataType = "int")
    @RequestMapping
    public ResponseBean deleteByVehicleAndVesselTaxId(int vehicleAndVesselTaxId) {
        int i = iVehicleAndVesselTaxService.deleteByVehicleAndVesselTaxId(vehicleAndVesselTaxId);
        if (0 != i) {
            return new ResponseBean(200, "成功", i);
        } else {
            throw new UnauthorizedException();
        }
    }*/

    @ApiOperation(value = "分页查询", tags = "需要两个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "页数", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pageNumber", value = "每页显示条数", required = true, dataType = "int"),
    })
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseBean findAll(int pageSize, int pageNumber, Pageable pageable) {
        pageable = new PageRequest(pageSize, pageNumber);
        Page<VehicleAndVesselTaxEntity> vehicleAndVesselTaxEntityList = iVehicleAndVesselTaxService.findAll(pageable);
        if (null != vehicleAndVesselTaxEntityList) {
            return new ResponseBean(200, "成功", vehicleAndVesselTaxEntityList);
        } else {
            throw new UnauthorizedException();
        }
    }
}
