package com.sl.tackout.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class ViewController {
    @RequestMapping("/addview1")
    public String addGoods1(){
        return "add1";
    }
    @RequestMapping("/addview")
    public String addGoods(){
        return "add";
    }
    @RequestMapping("/echartss")
    public String echarts(){
        return "echarts";
    }



}
