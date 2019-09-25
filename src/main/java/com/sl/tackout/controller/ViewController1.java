package com.sl.tackout.controller;

import com.sl.tackout.service.GoodsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController1 {
    @Autowired
    private GoodsService goodsService;
   /* @Autowired
    private ReadServiceimpl readServiceimpl;*/

    @RequestMapping("/Zaocan")
    public String Zaocan(){
        return "zaocan";
    }
    @RequestMapping("/Miantiao")
    public String Miaotiao(){
        return "miantiao";
    }
    @RequestMapping("/Yinliao")
    public String Yinliao(){
        return "yinliao";
    }
    @RequestMapping("/Rice")
    public String Rice(){
        return "rice";
    }

    @RequestMapping("/Test")
    public String Test(){
        return "test";
    }



}
