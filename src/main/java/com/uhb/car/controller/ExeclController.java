package com.uhb.car.controller;

import com.uhb.car.util.excel.ExcelUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName:execl导出
 * @Author: hlq
 * @Date: 2019/3/15 11:22
 * @Version 1.0
 */

@Controller
public class ExeclController {

    @RequestMapping(value = "/daoexecl", method = RequestMethod.GET)
    public void exportExcelData(HttpServletRequest request, HttpServletResponse response){
        // 定义表的标题
        String title = "U惠保保单列表一览";
        //定义表的列名
        String[] rowsName = new String[] { "订单号", "投保单号", "险种名称", "投保人", "车牌号", "保费", "车船税", "生效日期", "应付金额" };
        //定义表的内容
        List<Object[]> dataList = new ArrayList<Object[]>();
        Object[] objs = new Object[9];
        objs[0] = "测试";
        objs[1] = 11;
        objs[2] = "111";
        objs[3] = "测试";
        objs[4] = "测试";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(2018-12-24);
        objs[5] = date;
        objs[6] = "测试";
        objs[7] = "测试";
        objs[8] = "测试";
        dataList.add(objs);
        // 创建ExportExcel对象
        ExcelUtil excelUtil = new ExcelUtil();
        SimpleDateFormat der = new SimpleDateFormat("yyyy_MM_dd_HH_MM_SS");
        try{
            String fileName= new String("U惠保保单文档.xls".getBytes("UTF-8"),"iso-8859-1");
            String fileNametwo=der.format(new Date())+fileName;
            /**
             * @parameter
             *  title 标题
             *  rowsName 表头名
             *  dataList 数据
             *  fileNametwo 文件名
             */
            excelUtil.exportExcel(title,rowsName,dataList,fileNametwo,response);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
