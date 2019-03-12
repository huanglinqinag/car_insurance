package com.uhb.car.config;/*
 *  +----------------------------------------------------------------------
 *  | demo [ DruidStatFilter ]
 *  +----------------------------------------------------------------------
 *  | Copyright (c) 2018- strgeon All rights reserved.
 *  +----------------------------------------------------------------------
 *  | Licensed ( https://www.apache.org/licenses/LICENSE-2.0 )
 *  +----------------------------------------------------------------------
 *  | Author: strgeon <rnbug@qq.com> (2019-01-04)
 *  +----------------------------------------------------------------------
 *  | Remarks:
 *  |    1. edit me...
 *  +----------------------------------------------------------------------
 */



import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName = "druidWebStatFilter", urlPatterns = "/*",
        initParams = {
                @WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")// 忽略资源
        })
public class DruidStatFilter extends WebStatFilter {

}
