package com.uhb.car.controller;

import com.uhb.car.bean.ResponseBean;
import com.uhb.car.dao.IIdTypeDao;
import com.uhb.car.entity.IdTypeEntity;
import com.uhb.car.entity.InventoryEntity;
import com.uhb.car.exception.UnauthorizedException;
import com.uhb.car.services.IIdTypeService;
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
 * @Dome Class:IdTypeController
 * @Author: LJW
 * @Date: 2019/3/22 09:24
 * @Version 1.0
 */
@Api(tags = "证件信息")
@RestController
@RequestMapping(value = "/IdType")
public class IdTypeController {
    @Autowired
    IIdTypeService iIdTypeService;
    @Autowired
    IIdTypeDao iIdTypeDao;

    @ApiOperation(value = "添加证件信息", notes = "需要三个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "idTypeId", value = "证件Id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "idTypeName", value = "证件类型", required = true, dataType = "String"),
            @ApiImplicitParam(name = "ownerNature", value = "车主性质 ", required = true, dataType = "Integer"),
    })
    @RequestMapping(value = "/saveByIdTypeEntity", method = RequestMethod.GET)
    public ResponseBean saveByIdTypeEntity(IdTypeEntity idType) {
        IdTypeEntity idTypeEntity = iIdTypeService.saveByIdTypeEntity(idType);
        if (null != idTypeEntity) {
            return new ResponseBean(200, "成功", idTypeEntity);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "根据证件id进行删除", notes = "需要证件id")
    @ApiImplicitParam(name = "idTypeId", value = "证件Id", required = true, dataType = "Integer")
    @RequestMapping(value = "/deleteByIdTypeId", method = RequestMethod.GET)
    public ResponseBean deleteByIdTypeId(Integer idTypeId) {
        try {
            iIdTypeService.deleteByIdTypeId(idTypeId);
            return new ResponseBean(200, "成功", idTypeId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "修改证件信息", notes = "需要三个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "idTypeId", value = "证件Id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "idTypeName", value = "证件类型", required = true, dataType = "String"),
            @ApiImplicitParam(name = "ownerNature", value = "车主性质 ", required = true, dataType = "Integer"),
    })
    @RequestMapping(value = "/updateByIdTypeEntity", method = RequestMethod.GET)
    public ResponseBean updateByIdTypeEntity(IdTypeEntity idType) {
        IdTypeEntity idTypeEntity = iIdTypeService.updateByIdTypeEntity(idType);
        if (null != idTypeEntity) {
            return new ResponseBean(200, "成功", idTypeEntity);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "分页查询", notes = "需要 条数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "分页页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageNumber", value = "每页显示的数据条数", required = true, dataType = "Integer"),
    })
    @RequestMapping(value = "/findAllByIdTypeEntityPaging", method = RequestMethod.GET)
    public ResponseBean findAllByIdTypeEntityPaging(Integer pageSize, Integer pageNumber) {
        Page<IdTypeEntity> idTypeEntities = iIdTypeService.findAllByIdTypeEntityPaging(pageSize, pageNumber);
        if (null != idTypeEntities) {
            return new ResponseBean(200, "成功", idTypeEntities);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "动态分页查询", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "分页页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageNumber", value = "每页显示的数据条数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "idTypeName", value = "证件类型", required = true, dataType = "String"),
            @ApiImplicitParam(name = "ownerNature", value = "车主性质 ", required = true, dataType = "Integer"),

    })
    @RequestMapping(value = "/findAllByIdTypeEntityDynamicOne", method = RequestMethod.GET)
    public ResponseBean findAllByIdTypeEntityDynamicOne(IdTypeEntity idType, Integer pageSize, Integer pageNumber) {
        Page<IdTypeEntity> idTypeEntities = iIdTypeService.findAllByIdTypeEntityDynamic(idType, pageSize, pageNumber);
        if (null != idTypeEntities) {
            return new ResponseBean(200, "成功", idTypeEntities);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "动态分页查询", notes = "需要模糊查询")
    @RequestMapping(value = "/findAllByIdTypeEntityDynamic", method = RequestMethod.GET)
    public DataTablesOutput<IdTypeEntity> findAllByIdTypeEntityDynamic(@Valid DataTablesInput input) {
        return iIdTypeDao.findAll(input);
    }
}
