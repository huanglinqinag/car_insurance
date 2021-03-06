package com.uhb.car.controller;

import com.uhb.car.bean.ResponseBean;
import com.uhb.car.dao.ITypesOfInsuranceDao;
import com.uhb.car.entity.TypesOfInsuranceEntity;
import com.uhb.car.entity.VehicleAndVesselTaxEntity;
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
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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
    @Autowired
    ITypesOfInsuranceDao iTypesOfInsuranceDao;

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
    @Log(operationType = "删除操作", operationName = "删除商业险")
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

    @ApiOperation(value = "分页查询商业险", notes = "需要分页的页数和每页显示的条数")
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

    @ApiOperation(value = "动态分页查询商业险", notes = "需要3个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "insuranceName", value = "商业险名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pageSize", value = "页数", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pageNumber", value = "每页显示条数", required = true, dataType = "int"),
    })
    @RequestMapping(value = "/findAllByTypesOfInsuranceEntityDynamicOne", method = RequestMethod.GET)
    public ResponseBean findAllByTypesOfInsuranceEntityDynamicOne(TypesOfInsuranceEntity typesOfInsurance, Integer pageSize, Integer pageNumber) {
        Page<TypesOfInsuranceEntity> typesOfInsuranceEntityPage = iTypesOfInsuranceService.findAllByTypesOfInsuranceEntityDynamic(typesOfInsurance, pageSize, pageNumber);
        if (null != typesOfInsuranceEntityPage) {
            return new ResponseBean(200, "成功", typesOfInsuranceEntityPage);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "动态分页查询", notes = "需要模糊查询")
    @RequestMapping(value = "/findAllByTypesOfInsuranceEntityDynamic", method = RequestMethod.GET)
    public DataTablesOutput<TypesOfInsuranceEntity> findAllByTypesOfInsuranceEntityDynamic(@Valid DataTablesInput input) {
        return iTypesOfInsuranceDao.findAll(input);
    }
}
