package com.uhb.car.controller;

import com.uhb.car.bean.ResponseBean;
import com.uhb.car.entity.VehicleTypeEntity;
import com.uhb.car.exception.UnauthorizedException;
import com.uhb.car.services.imp.VehicleTypeServiceImpl;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Demo class VehicleTypeController
 *
 * @author Admin
 * @date 2019/3/9 18:17
 */
@Api(tags = "车辆类型")
@RestController
@RequestMapping(value = "/VehicleTypeEntity")
public class VehicleTypeController {
    @Autowired
    private VehicleTypeServiceImpl vehicleTypeServiceImpl;

    @ApiOperation(value = "添加车辆类型", notes = "不需要参数")
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public ResponseBean save(VehicleTypeEntity vehicleTypeEntity) {
        VehicleTypeEntity typeEntity = vehicleTypeServiceImpl.save(vehicleTypeEntity);
        if (typeEntity != null) {
            return new ResponseBean(200, "成功", typeEntity);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "分页查询", notes = "需要两个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "页数", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pageNumber", value = "显示条数", required = true, dataType = "int"),
    })
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseBean findAll(Pageable pageable, int pageSize, int pageNumber) {
        pageable = new PageRequest(pageSize, pageNumber);
        Page<VehicleTypeEntity> vehicleTypeEntityList = vehicleTypeServiceImpl.findAll(pageable);
        if (vehicleTypeEntityList != null) {
            return new ResponseBean(200, "lsjj", vehicleTypeEntityList);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "模糊查询", notes = "需要一个参数")
    @ApiImplicitParam(name = "typeName", value = "车辆类型", required = true, dataType = "String")
    @RequestMapping(value = "/findAllByTypeNameContaining", method = RequestMethod.GET)
    public ResponseBean findAllByTypeNameContaining(String typeName) {
        List<VehicleTypeEntity> vehicleTypeEntityList = vehicleTypeServiceImpl.findAllByTypeNameContaining(typeName);
        if (vehicleTypeEntityList != null) {
            return new ResponseBean(200, "成功", vehicleTypeEntityList);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "动态查询", notes = "需要两个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "vehicleTypeId", value = "车辆类型Id", required = true, dataType = "int"),
            @ApiImplicitParam(name = "typeName", value = "类型名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pageSize", value = "页数", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pageNumber", value = "显示条数", required = true, dataType = "int"),
    })
    @RequestMapping(value = "/findAllDynamic", method = RequestMethod.GET)
    public ResponseBean findAll(Pageable pageable, int pageSize, int pageNumber, int vehicleTypeId, String typeName) {
        pageable = new PageRequest(pageSize, pageNumber);
        System.out.println("vehicleTypeId" + vehicleTypeId);
        System.out.println("typeName" + typeName);
        Page<VehicleTypeEntity> vehicleTypeEntityList = vehicleTypeServiceImpl.findAll(vehicleTypeId, typeName, pageable);
        if (vehicleTypeEntityList != null) {
            return new ResponseBean(200, "成功", vehicleTypeEntityList);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "删除车辆类型", notes = "需要Id")
    @ApiImplicitParam(name = "id", value = "车辆类型ID", required = true, dataType = "int")
    @RequestMapping(value = "/deleteById", method = RequestMethod.GET)
    public ResponseBean deleteById(int id) {
        try {
            vehicleTypeServiceImpl.deleteById(id);
            return new ResponseBean(200, "成功", id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("test");
            throw new UnauthorizedException();
        }
    }

}
