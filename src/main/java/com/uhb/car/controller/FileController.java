package com.uhb.car.controller;

import com.uhb.car.bean.ResponseBean;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName:文件上传
 * @Author: hlq
 * @Date: 2019/3/14 9:48
 * @Version 1.0
 */
@Api(tags = "图片上传")
@Controller
public class FileController {
    @ApiOperation(value = "图片上传", notes = "需要一参数")
    @ApiImplicitParam(name = "fileName", value = "文件名", required = true, dataType = "file")
    @RequestMapping(value = "/file",consumes = "multipart/*",headers="content-type=multipart/from-data")
    @ResponseBody
    public ResponseBean File( MultipartFile file){
        if (file.isEmpty()){
            return new ResponseBean(500,"文件不存在","123");
        }
        String fileName=file.getOriginalFilename();
        int size =(int) file.getSize();
        //String path ="";

        return new ResponseBean(500,"文件不存在","123");
    }
}
