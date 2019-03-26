package com.uhb.car.controller;

import com.uhb.car.bean.ResponseBean;
import com.uhb.car.dao.IClaimSettlementDao;
import com.uhb.car.entity.ClaimSettlementEntity;
import com.uhb.car.entity.DisplacementEntity;
import com.uhb.car.exception.UnauthorizedException;
import com.uhb.car.services.IClaimSettlementService;
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
 * @Dome Class:ClaimSettlementController
 * @Author: LJW
 * @Date: 2019/3/25 08:40
 * @Version 1.0
 */
@Api(tags = "理赔")
@RestController
@RequestMapping(value = "/ClaimSettlement")
public class ClaimSettlementController {
    @Autowired
    IClaimSettlementService iClaimSettlementService;
    @Autowired
    IClaimSettlementDao iClaimSettlementDao;

    @ApiOperation(value = "添加一条理赔信息", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "claimSettlementId", value = "理赔信息Id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "name", value = "被保险人/索赔受益人", required = true, dataType = "String"),
            @ApiImplicitParam(name = "thirdPartyInformation", value = "第三者情况", required = true, dataType = "String"),
            @ApiImplicitParam(name = "vehicleId", value = "车辆信息表id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "compulsoryId", value = "交强险保单号码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "typesOfInsuranceId", value = "商业险保单号码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "time", value = "出险时间", required = true, dataType = "Date"),
            @ApiImplicitParam(name = "site", value = "出险地点", required = true, dataType = "String"),
            @ApiImplicitParam(name = "cause", value = "出险原因", required = true, dataType = "String"),
            @ApiImplicitParam(name = "driver", value = "出险驾驶员", required = true, dataType = "String"),
            @ApiImplicitParam(name = "phone", value = "联系电话", required = true, dataType = "String"),
    })
    @RequestMapping(value = "/saveByClaimSettlementEntity", method = RequestMethod.GET)
    public ResponseBean saveByClaimSettlementEntity(ClaimSettlementEntity claimSettlement) {
        ClaimSettlementEntity claimSettlementEntity = iClaimSettlementService.saveByClaimSettlementEntity(claimSettlement);
        if (null != claimSettlementEntity) {
            return new ResponseBean(200, "成功", claimSettlementEntity);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "根据理赔信息id删除", notes = "")
    @ApiImplicitParam(name = "claimSettlementId", value = "理赔信息Id", required = true, dataType = "Integer")
    @RequestMapping(value = "/deleteByClaimSettlementId", method = RequestMethod.GET)
    public ResponseBean deleteByClaimSettlementId(Integer claimSettlementId) {
        try {
            iClaimSettlementService.deleteByClaimSettlementId(claimSettlementId);
            return new ResponseBean(200, "成功", claimSettlementId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "修改一条理赔信息", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "claimSettlementId", value = "理赔信息Id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "name", value = "被保险人/索赔受益人", required = true, dataType = "String"),
            @ApiImplicitParam(name = "thirdPartyInformation", value = "第三者情况", required = true, dataType = "String"),
            @ApiImplicitParam(name = "vehicleId", value = "车辆信息表id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "compulsoryId", value = "交强险保单号码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "typesOfInsuranceId", value = "商业险保单号码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "time", value = "出险时间", required = true, dataType = "Date"),
            @ApiImplicitParam(name = "site", value = "出险地点", required = true, dataType = "String"),
            @ApiImplicitParam(name = "cause", value = "出险原因", required = true, dataType = "String"),
            @ApiImplicitParam(name = "driver", value = "出险驾驶员", required = true, dataType = "String"),
            @ApiImplicitParam(name = "phone", value = "联系电话", required = true, dataType = "String"),
    })
    @RequestMapping(value = "/updateByClaimSettlementEntity", method = RequestMethod.GET)
    public ResponseBean updateByClaimSettlementEntity(ClaimSettlementEntity claimSettlement) {
        ClaimSettlementEntity claimSettlementEntity = iClaimSettlementService.updateByClaimSettlementEntity(claimSettlement);
        if (null != claimSettlementEntity) {
            return new ResponseBean(200, "成功", claimSettlementEntity);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "分页查询", notes = "需要分页相关参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "分页页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageNumber", value = "每页显示数据条数", required = true, dataType = "Integer"),
    })
    @RequestMapping(value = "/findAllByClaimSettlementEntityPaging", method = RequestMethod.GET)
    public ResponseBean findAllByClaimSettlementEntityPaging(Integer pageSize, Integer pageNumber) {
        Page<ClaimSettlementEntity> claimSettlementEntities = iClaimSettlementService.findAllByClaimSettlementEntityPaging(pageSize, pageNumber);
        if (null != claimSettlementEntities) {
            return new ResponseBean(200, "成功", claimSettlementEntities);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "分页查询", notes = "需要分页相关参数,和查询所需要的参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "分页页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageNumber", value = "每页显示数据条数", required = true, dataType = "Integer"),
    })
    @RequestMapping(value = "/findAllByClaimSettlementEntityDynamicOne", method = RequestMethod.GET)
    public ResponseBean findAllByClaimSettlementEntityDynamicOne(ClaimSettlementEntity claimSettlement, Integer pageSize, Integer pageNumber) {
        Page<ClaimSettlementEntity> claimSettlementEntities = iClaimSettlementService.findAllByClaimSettlementEntityDynamic(claimSettlement, pageSize, pageNumber);
        if (null != claimSettlementEntities) {
            return new ResponseBean(200, "成功", claimSettlementEntities);
        } else {
            throw new UnauthorizedException();
        }
    }

    @ApiOperation(value = "动态分页查询", notes = "需要模糊查询")
    @RequestMapping(value = "/findAllByClaimSettlementEntityDynamic", method = RequestMethod.GET)
    public DataTablesOutput<ClaimSettlementEntity> findAllByClaimSettlementEntityDynamic(@Valid DataTablesInput input) {
        return iClaimSettlementDao.findAll(input);
    }
}
