package com.uhb.car.controller;

import com.uhb.car.bean.ResponseBean;
import com.uhb.car.dao.INatureOfVehicleUseDao;
import com.uhb.car.entity.NatureOfVehicleUseEntity;
import com.uhb.car.exception.UnauthorizedException;
import com.uhb.car.services.INatureOfVehicleUseService;
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
 * @Dome Class:NatureOfVehicleUseController
 * @Author: LJW
 * @Date: 2019/3/22 23:06
 * @Version 1.0
 */
@Api(tags = "车辆性质")
@RestController
@RequestMapping(value = "NatureOfVehicleUse")
public class NatureOfVehicleUseController {
    @Autowired
    INatureOfVehicleUseService iNatureOfVehicleUseService;
    @Autowired
    INatureOfVehicleUseDao iNatureOfVehicleUseDao;

    @ApiOperation(value = "添加一条车辆性质", notes = "需要两个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "natureOfVehicleUseId", value = "车辆性质Id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "natureName", value = "车辆性质名称", required = true, dataType = "String"),
    })
    @RequestMapping(value = "saveByNatureOfVehicleUseEntity", method = RequestMethod.GET)
    public ResponseBean saveByNatureOfVehicleUseEntity(NatureOfVehicleUseEntity natureOfVehicleUse) {
        NatureOfVehicleUseEntity natureOfVehicleUseEntity = iNatureOfVehicleUseService.saveByNatureOfVehicleUseEntity(natureOfVehicleUse);
        if (null != natureOfVehicleUseEntity) {
            return new ResponseBean(200, "成功", natureOfVehicleUseEntity);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "根据车辆性质Id删除", notes = "需要车辆性质Id")
    @ApiImplicitParam(name = "natureOfVehicleUseId", value = "车辆性质Id", required = true, dataType = "Integer")
    @RequestMapping(value = "/deleteByNatureOfVehicleUseEntity", method = RequestMethod.GET)
    public ResponseBean deleteByNatureOfVehicleUseEntity(Integer natureOfVehicleUseId) {
        try {
            iNatureOfVehicleUseService.deleteByNatureOfVehicleUseEntity(natureOfVehicleUseId);
            return new ResponseBean(200, "成功", natureOfVehicleUseId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "修改一条车辆性质", notes = "需要两个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "natureOfVehicleUseId", value = "车辆性质Id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "natureName", value = "车辆性质名称", required = true, dataType = "String"),
    })
    @RequestMapping(value = "updateByNatureOfVehicleUseEntity", method = RequestMethod.GET)
    public ResponseBean updateByNatureOfVehicleUseEntity(NatureOfVehicleUseEntity natureOfVehicleUse) {
        NatureOfVehicleUseEntity natureOfVehicleUseEntity = iNatureOfVehicleUseService.updateByNatureOfVehicleUseEntity(natureOfVehicleUse);
        if (null != natureOfVehicleUseEntity) {
            return new ResponseBean(200, "成功", natureOfVehicleUseEntity);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "分页查询车辆性质", notes = "需要两个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "分页页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageNumber", value = "每页显示数据条数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/findByNatureOfVehicleUseEntityPaging", method = RequestMethod.GET)
    public ResponseBean findByNatureOfVehicleUseEntityPaging(Integer pageSize, Integer pageNumber) {
        Page<NatureOfVehicleUseEntity> natureOfVehicleUseEntities = iNatureOfVehicleUseService.findByNatureOfVehicleUseEntityPaging(pageSize, pageNumber);
        if (null != natureOfVehicleUseEntities) {
            return new ResponseBean(200, "成功", natureOfVehicleUseEntities);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "分页查询车辆性质", notes = "需要三个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "natureName", value = "车辆性质名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pageSize", value = "分页页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageNumber", value = "每页显示数据条数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/findByNatureOfVehicleUseEntityPagingDynamicOne", method = RequestMethod.GET)
    public ResponseBean findByNatureOfVehicleUseEntityPagingDynamicOne(NatureOfVehicleUseEntity natureOfVehicleUse, Integer pageSize, Integer pageNumber) {
        Page<NatureOfVehicleUseEntity> natureOfVehicleUseEntities = iNatureOfVehicleUseService.findByNatureOfVehicleUseEntityPagingDynamic(natureOfVehicleUse, pageSize, pageNumber);
        if (null != natureOfVehicleUseEntities) {
            return new ResponseBean(200, "成功", natureOfVehicleUseEntities);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "动态分页查询", notes = "需要模糊查询")
    @RequestMapping(value = "/findByNatureOfVehicleUseEntityPagingDynamic", method = RequestMethod.GET)
    public DataTablesOutput<NatureOfVehicleUseEntity> findByNatureOfVehicleUseEntityPagingDynamic(@Valid DataTablesInput input) {
        return iNatureOfVehicleUseDao.findAll(input);
    }
}
