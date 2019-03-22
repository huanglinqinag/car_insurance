package com.uhb.car.controller;

import com.uhb.car.bean.ResponseBean;
import com.uhb.car.entity.VehicleTypeEntity;
import com.uhb.car.exception.UnauthorizedException;
import com.uhb.car.services.IVehicleTypeService;
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
    private IVehicleTypeService iVehicleTypeService;

    @ApiOperation(value = "添加车辆类型", notes = "需要车辆类型Id和车辆类型名称")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "vehicleTypeId", value = "车辆类型Id", required = true, dataType = "int"),
            @ApiImplicitParam(name = "typeName", value = "车辆类型名称", required = true, dataType = "String"),
    })
    @RequestMapping(value = "/savesaveVehicleTypeEntity", method = RequestMethod.GET)
    public ResponseBean saveVehicleTypeEntity(VehicleTypeEntity vehicleTypeEntity) {
        VehicleTypeEntity typeEntity = iVehicleTypeService.save(vehicleTypeEntity);
        if (typeEntity != null) {
            return new ResponseBean(200, "成功", typeEntity);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "删除车辆类型", notes = "需要车辆类型Id")
    @ApiImplicitParam(name = "id", value = "车辆类型ID", required = true, dataType = "int")
    @RequestMapping(value = "/deleteById", method = RequestMethod.GET)
    public ResponseBean deleteById(int id) {
        try {
            iVehicleTypeService.deleteById(id);
            return new ResponseBean(200, "成功", id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("test");
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "修改车辆类型", notes = "需要车辆类型Id和车辆类型名称")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "vehicleTypeId", value = "车辆类型Id", required = true, dataType = "int"),
            @ApiImplicitParam(name = "typeName", value = "车辆类型名称", required = true, dataType = "String"),
    })
    @RequestMapping(value = "/updateVehicleTypeEntity", method = RequestMethod.GET)
    public ResponseBean updateVehicleTypeEntity(VehicleTypeEntity vehicleTypeEntity) {
        VehicleTypeEntity typeEntity = iVehicleTypeService.update(vehicleTypeEntity);
        if (typeEntity != null) {
            return new ResponseBean(200, "成功", typeEntity);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "根据车辆类型模糊查询", notes = "需要车辆类型")
    @ApiImplicitParam(name = "typeName", value = "车辆类型", required = true, dataType = "String")
    @RequestMapping(value = "/findAllByTypeNameContaining", method = RequestMethod.GET)
    public ResponseBean findAllByTypeNameContaining(String typeName) {
        List<VehicleTypeEntity> vehicleTypeEntityList = iVehicleTypeService.findAllByTypeNameContaining(typeName);
        if (vehicleTypeEntityList != null) {
            return new ResponseBean(200, "成功", vehicleTypeEntityList);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "分页查询车辆类型", notes = "需要两个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "页数", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pageNumber", value = "显示条数", required = true, dataType = "int"),
    })
    @RequestMapping(value = "/findAllVehicleTypePaging", method = RequestMethod.GET)
    public ResponseBean findAllVehicleTypePaging(Pageable pageable, int pageSize, int pageNumber) {
        pageable = new PageRequest(pageSize, pageNumber);
        Page<VehicleTypeEntity> vehicleTypeEntityList = iVehicleTypeService.findAll(pageable);
        if (vehicleTypeEntityList != null) {
            return new ResponseBean(200, "lsjj", vehicleTypeEntityList);
        } else {
            throw new UnauthorizedException();
        }
    }


    @ApiOperation(value = "动态查询车辆类型", notes = "需要两个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "typeName", value = "类型名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pageSize", value = "页数", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pageNumber", value = "显示条数", required = true, dataType = "int"),
    })
    @RequestMapping(value = "/findAllVehicleTypeEntityDynamic", method = RequestMethod.GET)
    public ResponseBean findAllVehicleTypeEntityDynamic(Integer pageSize, Integer pageNumber, String typeName) {
        Page<VehicleTypeEntity> vehicleTypeEntityList = iVehicleTypeService.findAllVehicleTypeEntityDynamic(typeName, pageSize, pageNumber);
        if (vehicleTypeEntityList != null) {
            return new ResponseBean(200, "成功", vehicleTypeEntityList);
        } else {
            throw new UnauthorizedException();
        }
    }


}
