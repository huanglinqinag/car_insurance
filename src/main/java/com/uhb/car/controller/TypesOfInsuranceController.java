package com.uhb.car.controller;

import com.uhb.car.bean.ResponseBean;
import com.uhb.car.entity.TypesOfInsuranceEntity;
import com.uhb.car.services.ITypesOfInsuranceService;
import com.uhb.car.util.interfaceLog.Log;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName:TypesOfInsuranceController
 * @Author: LJW
 * @Date: 2019/3/17 14:25
 * @Version 1.0
 */
@Api(tags = "商业险")
@RestController
@RequestMapping(value = "/TypesOfInsurance")
public class TypesOfInsuranceController {
    @Autowired
    ITypesOfInsuranceService iTypesOfInsuranceService;

    @ApiOperation(value = "添加一条商业险数据", notes = "需要四个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "typesOfInsuranceId", value = "商业险Id", required = true, dataType = "int"),
            @ApiImplicitParam(name = "insuranceName", value = "商业险名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "sumInsured", value = "保额", required = true, dataType = "int"),
            @ApiImplicitParam(name = "price", value = "金额", required = true, dataType = "int"),
    })
    @RequestMapping(value = "saveByTypesOfInsuranceEntity", method = RequestMethod.GET)
    public ResponseBean saveByTypesOfInsuranceEntity(TypesOfInsuranceEntity types) {
        TypesOfInsuranceEntity typesOfInsuranceEntity = iTypesOfInsuranceService.saveByTypesOfInsuranceEntity(types);
        if (null != typesOfInsuranceEntity) {
            return new ResponseBean(200, "成功", typesOfInsuranceEntity);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "根据商业险Id删除", notes = "需要商业险id")
    @ApiImplicitParam(name = "typesOfInsuranceId", value = "商业险ID", required = true, dataType = "int")
    @RequestMapping(value = "/deleteByTypesOfInsuranceId", method = RequestMethod.GET)
    @Log(operationType="删除操作",operationName="删除商业险")
    public ResponseBean deleteByTypesOfInsuranceId(int typesOfInsuranceId) {
        try {
            iTypesOfInsuranceService.deleteByTypesOfInsuranceId(typesOfInsuranceId);
            return new ResponseBean(200, "成功", typesOfInsuranceId);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("test");
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "修改一条商业险数据", notes = "需要四个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "typesOfInsuranceId", value = "商业险Id", required = true, dataType = "int"),
            @ApiImplicitParam(name = "insuranceName", value = "商业险名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "sumInsured", value = "保额", required = true, dataType = "int"),
            @ApiImplicitParam(name = "price", value = "金额", required = true, dataType = "int"),
    })
    @RequestMapping(value = "updateByTypesOfInsuranceEntity", method = RequestMethod.GET)
    public ResponseBean updateByTypesOfInsuranceEntity(TypesOfInsuranceEntity types) {
        TypesOfInsuranceEntity typesOfInsuranceEntity = iTypesOfInsuranceService.updateByTypesOfInsuranceEntity(types);
        if (null != typesOfInsuranceEntity) {
            return new ResponseBean(200, "成功", typesOfInsuranceEntity);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "动态查询商业险", notes = "需要四个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "页数", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pageNumber", value = "每页显示条数", required = true, dataType = "int")
    })
    @RequestMapping(value = "/findAllByTypesOfInsuranceEntityPaging", method = RequestMethod.GET)
    public ResponseBean findAllByTypesOfInsuranceEntityPaging(Integer pageSize, Integer pageNumber) {
        Page<TypesOfInsuranceEntity> typesOfInsuranceEntityPage = iTypesOfInsuranceService.findAllByTypesOfInsuranceEntityPaging(pageSize, pageNumber);
        if (null != typesOfInsuranceEntityPage) {
            return new ResponseBean(200, "成功", typesOfInsuranceEntityPage);
        } else {
            throw new UnauthorizedException();
        }
    }
}
