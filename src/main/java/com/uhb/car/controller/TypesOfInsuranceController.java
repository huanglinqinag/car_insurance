package com.uhb.car.controller;

import com.uhb.car.bean.ResponseBean;
import com.uhb.car.entity.TypesOfInsuranceEntity;
import com.uhb.car.services.ITypesOfInsuranceService;
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

    @ApiOperation(value = "添加一条商业险数据", tags = "不需要参数")
    @RequestMapping(value = "save", method = RequestMethod.GET)
    public ResponseBean save(TypesOfInsuranceEntity types) {
        TypesOfInsuranceEntity typesOfInsuranceEntity = iTypesOfInsuranceService.save(types);
        if (null != typesOfInsuranceEntity) {
            return new ResponseBean(200, "成功", typesOfInsuranceEntity);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "根据商业险Id删除", tags = "需要商业险id")
    @ApiImplicitParam(name = "typesOfInsuranceId", value = "商业险ID", required = true, dataType = "int")
    @RequestMapping(value = "/deleteAllByTypesOfInsuranceId", method = RequestMethod.GET)
    public ResponseBean deleteAllByTypesOfInsuranceId(int typesOfInsuranceId) {
        int i = iTypesOfInsuranceService.deleteAllByTypesOfInsuranceId(typesOfInsuranceId);
        if (0 != i) {
            return new ResponseBean(200, "成功", i);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "分页查询商业险", tags = "需要两个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "页数", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pageNumber", value = "每页显示条数", required = true, dataType = "int"),
    })
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseBean findAll(int pageSize, int pageNumber, Pageable pageable) {
        pageable = new PageRequest(pageSize, pageNumber);
        Page<TypesOfInsuranceEntity> typesOfInsuranceEntities = iTypesOfInsuranceService.findAll(pageable);
        if (null != typesOfInsuranceEntities) {
            return new ResponseBean(200, "成功", typesOfInsuranceEntities);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "动态查询", tags = "需要四个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "typesOfInsuranceId", value = "商业险ID", required = true, dataType = "String"),
            @ApiImplicitParam(name = "insuranceName", value = "商业险名称", required = true, dataType = "String "),
            @ApiImplicitParam(name = "pageSize", value = "页数", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pageNumber", value = "每页显示条数", required = true, dataType = "int"),
    })
    @RequestMapping(value = "/findAllTypesOfInsuranceEntities", method = RequestMethod.GET)
    public ResponseBean findAllTypesOfInsuranceEntities(int typesOfInsuranceId, String insuranceName, int pageSize, int pageNumber, Pageable pageable) {
        pageable = new PageRequest(pageSize, pageNumber);
        Page<TypesOfInsuranceEntity> typesOfInsuranceEntityPage = iTypesOfInsuranceService.findAllTypesOfInsuranceEntities(typesOfInsuranceId, insuranceName, pageable);
        if (null != typesOfInsuranceEntityPage) {
            return new ResponseBean(200, "成功", typesOfInsuranceEntityPage);
        } else {
            throw new UnauthorizedException();
        }
    }
}
