package com.uhb.car.controller;

import com.uhb.car.bean.ResponseBean;
import com.uhb.car.dao.IInventoryDao;
import com.uhb.car.entity.InventoryEntity;
import com.uhb.car.entity.NatureOfVehicleUseEntity;
import com.uhb.car.exception.UnauthorizedException;
import com.uhb.car.services.IInventoryService;
import com.uhb.car.util.interfaceLog.Log;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @ClassName:InventoryController
 * @Author: LJW
 * @Date: 2019/3/18 14:18
 * @Version 1.0
 */
@Api(tags = "保单号")
@RestController
@RequestMapping(value = "/Inventory")
public class InventoryController {
    @Autowired
    IInventoryService iInventoryService;
    @Autowired
    IInventoryDao iInventoryDao;

    @ApiOperation(value = "新增保单信息", notes = "需要11个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "inventoryId", value = "保单Id", required = true, dataType = "int"),
            @ApiImplicitParam(name = "insuranceNumber", value = "投保单号", required = true, dataType = "int"),
            @ApiImplicitParam(name = "typesName", value = "险种类型", required = true, dataType = "String"),
            @ApiImplicitParam(name = "vehicleId", value = "车辆信息", required = true, dataType = "int"),
            @ApiImplicitParam(name = "carOwnerId", value = "车主信息", required = true, dataType = "int"),
            @ApiImplicitParam(name = "premium", value = "保费", required = true, dataType = "int"),
            @ApiImplicitParam(name = "vehicleAndVesselTaxId", value = "车船税Id", required = true, dataType = "int"),
            @ApiImplicitParam(name = "effectiveDate", value = "生效时间", required = true, dataType = "Date"),
            @ApiImplicitParam(name = "amountPayable", value = "应付金额", required = true, dataType = "int"),
            @ApiImplicitParam(name = "startingTime", value = "起保时间", required = true, dataType = "Date"),
            @ApiImplicitParam(name = "finalProtectionTime", value = "终保时间", required = true, dataType = "Date"),

    })
    @RequestMapping(value = "/saveByInventoryEntity", method = RequestMethod.GET)
    public ResponseBean saveByInventoryEntity(InventoryEntity inventory) {
        InventoryEntity Inventory = iInventoryService.saveByInventoryEntity(inventory);
        if (null != Inventory) {
            return new ResponseBean(200, "成功", Inventory);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "删除保单", notes = "需要保单Id")
    @ApiImplicitParam(name = "inventoryId", value = "保单Id", required = true, dataType = "int")
    @RequestMapping(value = "/deleteByInventoryId", method = RequestMethod.GET)
    @Log(operationType = "删除操作", operationName = "删除保单")
    public ResponseBean deleteByInventoryId(int inventoryId) {
        try {
            iInventoryService.deleteByInventoryId(inventoryId);
            return new ResponseBean(200, "成功", inventoryId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "修改保单信息", notes = "需要11个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "inventoryId", value = "保单Id", required = true, dataType = "int"),
            @ApiImplicitParam(name = "insuranceNumber", value = "投保单号", required = true, dataType = "int"),
            @ApiImplicitParam(name = "typesName", value = "险种类型", required = true, dataType = "String"),
            @ApiImplicitParam(name = "vehicleId", value = "车辆信息", required = true, dataType = "int"),
            @ApiImplicitParam(name = "carOwnerId", value = "车主信息", required = true, dataType = "int"),
            @ApiImplicitParam(name = "premium", value = "保费", required = true, dataType = "int"),
            @ApiImplicitParam(name = "vehicleAndVesselTaxId", value = "车船税Id", required = true, dataType = "int"),
            @ApiImplicitParam(name = "effectiveDate", value = "生效时间", required = true, dataType = "Date"),
            @ApiImplicitParam(name = "amountPayable", value = "应付金额", required = true, dataType = "int"),
            @ApiImplicitParam(name = "startingTime", value = "起保时间", required = true, dataType = "Date"),
            @ApiImplicitParam(name = "finalProtectionTime", value = "终保时间", required = true, dataType = "Date"),

    })
    @RequestMapping(value = "/updateByInventoryEntity", method = RequestMethod.GET)
    public ResponseBean updateByInventoryEntity(InventoryEntity inventory) {
        InventoryEntity Inventory = iInventoryService.updateByInventoryEntity(inventory);
        if (null != Inventory) {
            return new ResponseBean(200, "成功", Inventory);
        } else {
            throw new UnauthorizedException();
        }
    }


    @ApiOperation(value = "分页查询保单信息", notes = "需要分页的页数和每页显示的数据条数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNumber", value = "每页显示数据条数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "页数", required = true, dataType = "Integer"),

    })
    @RequestMapping(value = "/findAllByInventoryEntityPaging", method = RequestMethod.GET)
    public ResponseBean findAllByInventoryEntityPaging(Integer pageNumber, Integer pageSize) {
        Page<InventoryEntity> inventoryEntityPage = iInventoryService.findAllByInventoryEntityPaging(pageNumber, pageSize);
        if (null != inventoryEntityPage) {
            return new ResponseBean(200, "成功", inventoryEntityPage);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "动态分页查询", notes = "需要6个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "typesName", value = "险种类型", required = true, dataType = "String"),
            @ApiImplicitParam(name = "vehicleId", value = "车辆信息Id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "carOwnerId", value = "车主信息Id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "vehicleAndVesselTaxId", value = "车船税Id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "分页页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageNumber", value = "每页显示条数", required = true, dataType = "Integer"),

    })
    @RequestMapping(value = "/findByInventoryEntityDynamicOne", method = RequestMethod.GET)
    public ResponseBean findByInventoryEntityDynamicOne(Integer pageSize, Integer pageNumber, InventoryEntity inventory) {
        Page<InventoryEntity> inventoryEntityPage = iInventoryService.findByInventoryEntityDynamic(pageSize, pageNumber, inventory);
        if (null != inventoryEntityPage) {
            return new ResponseBean(200, "成功", inventoryEntityPage);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "动态分页查询", notes = "需要模糊查询")
    @RequestMapping(value = "/findByInventoryEntityDynamic", method = RequestMethod.GET)
    public DataTablesOutput<InventoryEntity> findByInventoryEntityDynamic(@Valid DataTablesInput input) {
        return iInventoryDao.findAll(input);
    }
}
