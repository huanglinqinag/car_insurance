package com.uhb.car.controller;

import com.uhb.car.bean.ResponseBean;
import com.uhb.car.util.qiniuyun.QiniuCloudUtil;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
    @RequestMapping(value="/uploadImg")
    public ResponseBean uploadImg(HttpServletRequest request) {

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
                    System.out.println("地址" + url);

                    fileName.append(url+"#");

                   // url[i]+url[]
                    //http://pocg6c04c.bkt.clouddn.com214c4100-6876-4e0a-8d51-137f5842b366
                    //http://pocg6c04c.bkt.clouddn.comc37dcfb2-9113-4674-8218-63f4d1cace88
                    //http://pocg6c04c.bkt.clouddn.comc37dcfb2-9113-4674-8218-63f4d1cace88#http://pocg6c04c.bkt.clouddn.com214c4100-6876-4e0a-8d51-137f5842b366#
                    flag = true;
                    //return new ResponseBean(200, "上传成功", url);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                return new ResponseBean(500, "文件上传异常", "1");
            }
        }
        System.out.println("fileName"+fileName.toString());
        if(flag){
            return new ResponseBean(200, "上传成功", null);
        }
        return null;
    }
}
