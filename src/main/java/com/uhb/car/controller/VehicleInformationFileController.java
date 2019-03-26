package com.uhb.car.controller;

import com.uhb.car.bean.ResponseBean;
import com.uhb.car.entity.CarOwnerEntity;
import com.uhb.car.entity.VehicleInformationEntity;
import com.uhb.car.exception.UnauthorizedException;
import com.uhb.car.services.IVehicleInformationService;
import com.uhb.car.util.qiniuyun.QiniuCloudUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

/**
 * @Dome Class:VehicleInformationFileController
 * @Author: LJW
 * @Date: 2019/3/26 11:10
 * @Version 1.0
 */
@Controller
public class VehicleInformationFileController {
    @Autowired
    IVehicleInformationService iVehicleInformationService;

    @RequestMapping(value = "/VehicleInformationUpload")
    public String upload() {
        return "VehicleInformation";
    }

    @ApiOperation(value = "添加一条车辆信息", notes = "需要11条数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "vehicleId", value = "车辆信息Id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "licensePlateNumber", value = "车牌号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "vin", value = "车架号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "engineNumber", value = "发动机号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "vehicleTypeId", value = "车辆种类", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "natureOfVehicleUseId", value = "车辆使用性质", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "dateOfInitialRegistration", value = "初次登记的日期", required = true, dataType = "String"),
            @ApiImplicitParam(name = "energyTypeId", value = "能源种类", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "picture", value = "行驶证图片", required = true, dataType = "String"),
            @ApiImplicitParam(name = "displacementId", value = "排量", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "seating", value = "座位数", required = true, dataType = "Integer"),

    })
    @RequestMapping(value = "/vehicleInformationUploadImg", method = RequestMethod.POST)
    public ResponseBean uploadImg(HttpServletRequest request, VehicleInformationEntity vehicleInformation) throws UnauthorizedException {

        List<MultipartFile> images = ((MultipartHttpServletRequest) request).getFiles("image");
        System.out.println("daxiao" + images.size());
        boolean flag = false;
        StringBuffer fileName = new StringBuffer();
        for (int i = 0; i < images.size(); i++) {
            MultipartFile image = images.get(i);
            if (image.isEmpty()) {
                return new ResponseBean(400, "文件为空,请重新上传", "1");
            }
            try {
                //作为字节上传
                byte[] bytes = image.getBytes();
                String imageName = UUID.randomUUID().toString();
                try {
                    //使用base64方式上传到七牛云
                    String url = QiniuCloudUtil.put64image(bytes, imageName);
                    fileName.append(url + "#");
                    flag = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                return new ResponseBean(500, "文件上传异常", "1");
            }
        }
        System.out.println("fileName" + fileName.toString());
        String fileNameS = fileName.toString();
        String[] sour = fileNameS.split("#");
        for (int i = 0; i < sour.length; i++) {
            System.out.println("分割后的" + sour[i]);
            String s = sour[i];
            byte[] bytes = s.getBytes();
            Base64 base64 = new Base64();
            bytes = base64.decode(bytes);
            String str11 = null;
            try {
                str11 = new String(bytes, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            System.out.println("解密后的url" + str11);
        }

        if (flag) {
            vehicleInformation.setPicture(fileName.toString());
            VehicleInformationEntity vehicleInformationEntity = iVehicleInformationService.saveVehicleInformationEntity(vehicleInformation);
            if (null != vehicleInformationEntity) {
                return new ResponseBean(200, "成功", vehicleInformationEntity);
            }
            return new ResponseBean(200, "上传成功", null);
        }
        return null;
    }
}
