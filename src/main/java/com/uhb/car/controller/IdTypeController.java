package com.uhb.car.controller;

import com.uhb.car.bean.ResponseBean;
import com.uhb.car.entity.IdTypeEntity;
import com.uhb.car.exception.UnauthorizedException;
import com.uhb.car.services.IIdTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Dome Class:IdTypeController
 * @Author: LJW
 * @Date: 2019/3/22 09:24
 * @Version 1.0
 */
@Api(tags = "证件信息")
@RestController
@RequestMapping(value = "IdType")
public class IdTypeController {
    @Autowired
    IIdTypeService iIdTypeService;

    @ApiOperation(value = "添加证件信息", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "idTypeId", value = "证件Id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "idTypeName", value = "证件类型", required = true, dataType = "String"),
            @ApiImplicitParam(name = "ownerNature", value = "车主性质 ", required = true, dataType = "Integer"),
    })
    @RequestMapping(value = "/saveByIdType", method = RequestMethod.GET)
    public ResponseBean saveByIdType(IdTypeEntity idType) {
        IdTypeEntity idTypeEntity = iIdTypeService.saveByIdType(idType);
        if (null != idTypeEntity) {
            return new ResponseBean(200, "成功", idTypeEntity);
        } else {
            throw new UnauthorizedException();
        }
    }
}
