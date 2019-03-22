package com.uhb.car.controller;

import com.uhb.car.bean.ResponseBean;
import com.uhb.car.entity.CarOwnerEntity;
import com.uhb.car.exception.UnauthorizedException;
import com.uhb.car.services.ICarOwnerService;
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
 * @Dome Class:CarOwnerController
 * @Author: LJW
 * @Date: 2019/3/19 19:11
 * @Version 1.0
 */
@Api(tags = "车主信息")
@RestController
@RequestMapping(value = "/CarOwner")
public class CarOwnerController {
    @Autowired
    ICarOwnerService iCarOwnerService;

    @ApiOperation(value = "新增车主信息", notes = "需要7个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "carOwnerId", value = "车主信息Id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "theOwnerName", value = "车主名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "natrueOfTheOwner", value = "车主性质", required = true, dataType = "String"),
            @ApiImplicitParam(name = "idTypeId", value = "证件类型", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "idNumber", value = "证件号码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "relation", value = "电话号码被保人与车辆关系", required = true, dataType = "String"),
            @ApiImplicitParam(name = "picture", value = "证件照照片", required = true, dataType = "String"),
    })
    @RequestMapping(value = "/saveCarOwner", method = RequestMethod.GET)
    public ResponseBean saveCarOwner(CarOwnerEntity carOwner) {
        CarOwnerEntity carOwnerEntity = iCarOwnerService.save(carOwner);
        if (null != carOwnerEntity) {
            return new ResponseBean(200, "成功", carOwnerEntity);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "根据车主信息Id进行删除", notes = "需要车主信息Id")
    @ApiImplicitParam(name = "carOwnerId", value = "车主信息Id", required = true, dataType = "Integer")
    @RequestMapping(value = "/deleteAllByDisplacementId", method = RequestMethod.GET)
    public ResponseBean deleteAllByDisplacementId(Integer carOwnerId) {
        try {
            iCarOwnerService.deleteById(carOwnerId);
            return new ResponseBean(200, "成功", carOwnerId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "新增车主信息", notes = "需要7个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "carOwnerId", value = "车主信息Id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "theOwnerName", value = "车主名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "natrueOfTheOwner", value = "车主性质", required = true, dataType = "String"),
            @ApiImplicitParam(name = "idTypeId", value = "证件类型", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "idNumber", value = "证件号码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "relation", value = "电话号码被保人与车辆关系", required = true, dataType = "String"),
            @ApiImplicitParam(name = "picture", value = "证件照照片", required = true, dataType = "String"),
    })
    @RequestMapping(value = "/saveCarOwner", method = RequestMethod.GET)
    public ResponseBean updateCarOwner(CarOwnerEntity carOwner) {
        CarOwnerEntity carOwnerEntity = iCarOwnerService.update(carOwner);
        if (null != carOwnerEntity) {
            return new ResponseBean(200, "成功", carOwnerEntity);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "分页查询车主信息", notes = "需要分页的页数和每页显示数据的条数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNumber", value = "每页显示数据条数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "分页的页数", required = true, dataType = "Integer"),
    })
    @RequestMapping(value = "/findAllCarOwnerEntity", method = RequestMethod.GET)
    public ResponseBean findAllCarOwnerEntity(Integer pageNumber, Integer pageSize, Pageable pageable) {
        pageable = new PageRequest(pageSize, pageNumber);
        Page<CarOwnerEntity> carOwnerEntities = iCarOwnerService.findAll(pageable);
        if (null != carOwnerEntities) {
            return new ResponseBean(200, "成功", carOwnerEntities);
        } else {
            throw new UnauthorizedException();
        }
    }
}
