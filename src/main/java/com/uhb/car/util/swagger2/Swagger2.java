package com.uhb.car.util.swagger2;/*
 *  +----------------------------------------------------------------------
 *  | demo [ Swagger2Condig ]
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



import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class Swagger2 {
    @Bean
    public Docket webApi() {
        //添加head参数start
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name("Authorization").description("令牌")
                .modelRef(new ModelRef("string"))
                .parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        //添加head参数end


        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("应用文档")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.uhb.car.controller"))
                .paths(PathSelectors.any()).build()
                .globalOperationParameters(pars);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API 文档")
                .description("应用基础API")
                .contact(new Contact("Strgeon", "http://baidu.com", "rnbug@qq.com"))
                .version("1.0")
                .build();
    }
}
