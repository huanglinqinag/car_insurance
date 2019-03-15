package com.uhb.car.controller;

import com.uhb.car.bean.ResponseBean;

import com.uhb.car.entity.Users;
import com.uhb.car.exception.UnauthorizedException;
import com.uhb.car.services.DemoService;
import com.uhb.car.util.jwt.JWTUtil;
import io.swagger.annotations.*;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * @ClassName:
 * @Author: hlq
 * @Date: 2019/3/6 9:55
 * @Version 1.0
 */
@Api(tags = "用户")
@Controller
public class DemoController {
    @Autowired
    DemoService demoService;
    @RequestMapping(value = "/login")
    public  String lo(){
        return "tologin";
    }

    @ApiOperation(value = "登录验证", notes = "需要两参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String"),
    })
    @RequestMapping(value = "/gologin", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean login(String username, String password) {
        Users users=demoService.findByName(username);
        if (users.getPassword().equals(password)){
            return new ResponseBean(200,"login success", JWTUtil.sign(username,password));
        }else {
            throw new UnauthorizedException();
        }
    }
    @ApiOperation(value = "查询用户", notes = "不需要参数")
    @RequestMapping(value = "/tolist" ,method = RequestMethod.GET )
    @ResponseBody
    @RequiresRoles({"admin"})
    public ResponseBean list() throws AuthenticationException {
        List<Users> list=demoService.findAll();
        System.out.println(list.size());

       return new ResponseBean(200,"ok",list);
        //return new ResponseBean(200,"12",12);
    }

    @ApiOperation(value = "异常", notes = "不需要参数")
    @RequestMapping(value = "/yichang" ,method = RequestMethod.GET )
    @ResponseBody
    public ResponseBean yichang() throws UnauthorizedException {
        throw new UnauthorizedException("权限不足");
        //return new ResponseBean(200,"12",12);
    }
    @RequestMapping("/401")
    public ResponseBean si(){

        return new ResponseBean(401,"没有权限","1232");

    }


}
