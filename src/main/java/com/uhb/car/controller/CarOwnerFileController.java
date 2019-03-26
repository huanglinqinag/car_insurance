package com.uhb.car.controller;

import com.uhb.car.bean.ResponseBean;
import com.uhb.car.entity.CarOwnerEntity;
import com.uhb.car.exception.UnauthorizedException;
import com.uhb.car.services.ICarOwnerService;
import com.uhb.car.util.qiniuyun.QiniuCloudUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @ClassName:文件上传
 * @Author: hlq
 * @Date: 2019/3/14 9:48
 * @Version 1.0
 */

@Controller
public class CarOwnerFileController {
    @Autowired
    ICarOwnerService iCarOwnerService;

    @RequestMapping(value = "/CarOwnerUpload")
    public String upload() {
        return "carOwner";
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "carOwnerId", value = "车主信息Id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "theOwnerName", value = "车主名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "natrueOfTheOwner", value = "车主性质", required = true, dataType = "String"),
            @ApiImplicitParam(name = "idTypeId", value = "证件类型", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "idNumber", value = "证件号码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "relation", value = "电话号码被保人与车辆关系", required = true, dataType = "String"),
            @ApiImplicitParam(name = "picture", value = "证件照照片", required = true, dataType = "String"),
    })
    @ResponseBody
    @RequestMapping(value = "/carOwnerUploadImg", method = RequestMethod.POST)
    public ResponseBean uploadImg(HttpServletRequest request, CarOwnerEntity carOwner) throws UnauthorizedException {

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
            carOwner.setPicture(fileName.toString());
            CarOwnerEntity carOwnerEntity = iCarOwnerService.saveByCarOwnerEntity(carOwner);
            if (null != carOwnerEntity) {
                return new ResponseBean(200, "添加成功", null);
            }
            return new ResponseBean(200, "上传成功", null);
        }
        return null;
    }
}
