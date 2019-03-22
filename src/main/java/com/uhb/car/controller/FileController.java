package com.uhb.car.controller;

import com.uhb.car.bean.ResponseBean;
import com.uhb.car.exception.UnauthorizedException;
import com.uhb.car.util.qiniuyun.QiniuCloudUtil;
import org.apache.commons.codec.binary.Base64;
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
public class FileController {
    @RequestMapping(value="/upload")
    public String upload() {
        return "wen";
    }

    @ResponseBody
    @RequestMapping(value="/uploadImg",method = RequestMethod.POST)
    public ResponseBean uploadImg(HttpServletRequest request) throws UnauthorizedException {

        List<MultipartFile> images = ((MultipartHttpServletRequest) request).getFiles("image");
        System.out.println("daxiao"+images.size());
        boolean flag = false;
        StringBuffer fileName = new StringBuffer();
        for (int i = 0; i < images.size(); i++) {
            MultipartFile image=images.get(i);
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

                    fileName.append(url+"#");
                    flag = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                return new ResponseBean(500, "文件上传异常", "1");
            }
        }
        System.out.println("fileName"+fileName.toString());
        String fileNameS=fileName.toString();
        String[] sour=fileNameS.split("#");
        for (int i=0;i<sour.length;i++){
            System.out.println("分割后的"+sour[i]);
            String s=sour[i];
            byte[] bytes=s.getBytes();
            Base64 base64=new Base64();
            bytes=base64.decode(bytes);
            String str11 = null;
            try {
                str11 = new String(bytes,"utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            System.out.println("解密后的url"+str11);
        }

        if(flag){
            return new ResponseBean(200, "上传成功", null);
        }
        return null;
    }
}
