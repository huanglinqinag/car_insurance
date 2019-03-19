package com.uhb.car.controller;

import com.uhb.car.bean.ResponseBean;
import com.uhb.car.entity.InventoryEntity;
import com.uhb.car.exception.UnauthorizedException;
import com.uhb.car.services.IInventoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @ApiOperation(value = "新增保单", notes = "需要11个参数")
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
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public ResponseBean save(InventoryEntity inventoryEntity) {
        InventoryEntity Inventory = iInventoryService.save(inventoryEntity);
        if (null != Inventory) {
            return new ResponseBean(200, "成功", Inventory);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "修改保单", notes = "需要11个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "inventoryId", value = "保单Id", required = true, dataType = "int"),
            @ApiImplicitParam(name = "insuranceNumber", value = "投保单号", required = true, dataType = "int"),
            @ApiImplicitParam(name = "typesOfInsuranceId", value = "品种名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "vehicleId", value = "车辆信息", required = true, dataType = "int"),
            @ApiImplicitParam(name = "carOwnerId", value = "车主信息", required = true, dataType = "int"),
            @ApiImplicitParam(name = "premium", value = "保费", required = true, dataType = "int"),
            @ApiImplicitParam(name = "vehicleAndVesselTaxId", value = "车船税Id", required = true, dataType = "int"),
            @ApiImplicitParam(name = "effectiveDate", value = "生效时间", required = true, dataType = "Date"),
            @ApiImplicitParam(name = "amountPayable", value = "应付金额", required = true, dataType = "int"),
            @ApiImplicitParam(name = "startingTime", value = "起保时间", required = true, dataType = "Date"),
            @ApiImplicitParam(name = "finalProtectionTime", value = "终保时间", required = true, dataType = "Date"),

    })
    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public ResponseBean modify(InventoryEntity inventoryEntity) {
        InventoryEntity Inventory = iInventoryService.save(inventoryEntity);
        if (null != Inventory) {
            return new ResponseBean(200, "成功", Inventory);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "删除保单", notes = "需要保单Id")
    @ApiImplicitParam(name = "inventoryId", value = "保单Id", required = true, dataType = "int")
    @RequestMapping(value = "/deleteByInventoryId", method = RequestMethod.GET)
    public ResponseBean deleteByInventoryId(int inventoryId) {
        int i = iInventoryService.deleteByInventoryId(inventoryId);
        if (0 != i) {
            return new ResponseBean(200, "成功", i);
        } else {
            throw new UnauthorizedException();

        }
    }
}
