package com.uhb.car.controller;

import com.uhb.car.bean.ResponseBean;
import com.uhb.car.dao.IEnergyTypeDao;
import com.uhb.car.entity.EnergyTypeEntity;
import com.uhb.car.entity.IdTypeEntity;
import com.uhb.car.exception.UnauthorizedException;
import com.uhb.car.services.IEnergyTypeService;
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
 * @Dome Class:EnergyTypeController
 * @Author: LJW
 * @Date: 2019/3/23 12:41
 * @Version 1.0
 */
@Api(tags = "能源类型")
@RestController
@RequestMapping(value = "/EnergyType")
public class EnergyTypeController {
    @Autowired
    IEnergyTypeService iEnergyTypeService;
    @Autowired
    IEnergyTypeDao iEnergyTypeDao;

    @ApiOperation(value = "添加能源类型", notes = "需要要两个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "energyTypeId", value = "能源类型Id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "energyTypeName", value = "能源类型名称", required = true, dataType = "String"),

    })
    @RequestMapping(value = "/saveEnergyTypeEntity", method = RequestMethod.GET)
    public ResponseBean saveEnergyTypeEntity(EnergyTypeEntity energyType) {
        EnergyTypeEntity energyTypeEntity = iEnergyTypeService.saveEnergyTypeEntity(energyType);
        if (null != energyTypeEntity) {
            return new ResponseBean(200, "成功", energyTypeEntity);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "根据能源类型id删除", notes = "需要要一个参数")
    @ApiImplicitParam(name = "energyTypeId", value = "能源类型Id", required = true, dataType = "Integer")
    @RequestMapping(value = "/deleteByEnergyTypeId", method = RequestMethod.GET)
    public ResponseBean deleteByEnergyTypeId(Integer energyTypeId) {
        try {
            iEnergyTypeService.deleteByEnergyTypeId(energyTypeId);
            return new ResponseBean(200, "成功", energyTypeId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "修改能源类型", notes = "需要要两个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "energyTypeId", value = "能源类型Id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "energyTypeName", value = "能源类型名称", required = true, dataType = "String"),

    })
    @RequestMapping(value = "/updateEnergyTypeEntity", method = RequestMethod.GET)
    public ResponseBean updateEnergyTypeEntity(EnergyTypeEntity energyType) {
        EnergyTypeEntity energyTypeEntity = iEnergyTypeService.updateEnergyTypeEntity(energyType);
        if (null != energyTypeEntity) {
            return new ResponseBean(200, "成功", energyTypeEntity);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "分页查询能源类型", notes = "需要要两个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "分页页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageNumber", value = "每页显示数据条数", required = true, dataType = "Integer"),

    })
    @RequestMapping(value = "/findAllByEnergyTypeEntityPaging", method = RequestMethod.GET)
    public ResponseBean findAllByEnergyTypeEntityPaging(Integer pageSize, Integer pageNumber) {
        Page<EnergyTypeEntity> energyTypeEntities = iEnergyTypeService.findAllByEnergyTypeEntityPaging(pageSize, pageNumber);
        if (null != energyTypeEntities) {
            return new ResponseBean(200, "成功", energyTypeEntities);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "分页查询能源类型", notes = "需要要三个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "分页页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageNumber", value = "每页显示数据条数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "energyTypeName", value = "能源类型名称", required = true, dataType = "String"),
    })
    @RequestMapping(value = "/findAllByEnergyTypeEntityDynamicOne", method = RequestMethod.GET)
    public ResponseBean findAllByEnergyTypeEntityDynamicOne(EnergyTypeEntity energyType, Integer pageSize, Integer pageNumber) {
        Page<EnergyTypeEntity> energyTypeEntities = iEnergyTypeService.findAllByEnergyTypeEntityDynamic(energyType, pageSize, pageNumber);
        if (null != energyTypeEntities) {
            return new ResponseBean(200, "成功", energyTypeEntities);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "动态分页查询", notes = "需要模糊查询")
    @RequestMapping(value = "/findAllByEnergyTypeEntityDynamic", method = RequestMethod.GET)
    public DataTablesOutput<EnergyTypeEntity> findAllByEnergyTypeEntityDynamic(@Valid DataTablesInput input) {
        return iEnergyTypeDao.findAll(input);
    }
}

