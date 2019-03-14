package com.uhb.car.controller;

import com.uhb.car.bean.ResponseBean;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @ApiImplicitParam(name = "file", value = "文件", required = true, dataType = "String")
    @RequestMapping(value = "/file", method = RequestMethod.GET)
    @ResponseBody
    public String File(){
        return "123";
    }
}
