package com.sl.tackout.controller;


import com.sl.tackout.pojo.Goods1;
import com.sl.tackout.service.GoodService1;
import com.sl.tackout.service.impl.ReadServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GoodController1 {
    @Autowired
    private GoodService1 goodService1;
    @Autowired
    private ReadServiceimpl readServiceimpl;
    @RequestMapping("indexview3")
    public String loadAll(Model model){
        List<Goods1> goodList1=goodService1.loadAll();
        model.addAttribute("goodList1",goodList1);
        return "index3";
    }
    @RequestMapping("zengjia1")
    public String addGoods1(Goods1 goods1){
        boolean bool=goodService1.addGoods1(goods1);
        return bool?"redirect:indexview3":"error";
    }
    @RequestMapping("shanchu1")
    public String deleteGoods1(int gid){
        boolean bool=goodService1.deleteGoods1(gid);
        return bool?"redirect:indexview3":"error";
    }
    @RequestMapping("xloadById1")
    public String loadById1(int gid,Model model){
       Goods1 goods1= goodService1.loadById1(gid);
       model.addAttribute("goods1",goods1);
        return "edit1";
    }
    @RequestMapping("updateview1")
    public String updateGoods1(Goods1 goods1){
        boolean bool=goodService1.updateGoods1(goods1);
        return bool?"redirect:indexview3":"error";
    }
    @RequestMapping("index4view")
    public String loadAllShanXuan(Model model){
        List<Goods1> goods1s=goodService1.loadAllShanXuan();
       // System.out.println(goods1s);
        model.addAttribute("goods1s",goods1s);
        return "index4";
    }
    @RequestMapping("index5view")
    public String loadAllShanXuan2(Model model){
        List<Goods1> goods2s=goodService1.loadAllShanXuan2();
        model.addAttribute("goods2s",goods2s);
        return "index5";
    }
    @RequestMapping("index6view")
    public String loadAllShanXuan3(Model model){
        List<Goods1> goods3s=goodService1.loadAllShanXuan3();
        model.addAttribute("goods3s",goods3s);
        return "index6";
    }
    @RequestMapping("index7view")
    public String loadAllShanXuan4(Model model){
        List<Goods1> goods4s=goodService1.loadAllShanXuan4();
        model.addAttribute("goods4s",goods4s);
        return "index7";
    }
    @RequestMapping("index8view")
    public String loadAllShanXuan5(Model model){
        List<Goods1> goods5s=goodService1.loadAllShanXuan5();
        model.addAttribute("goods5s",goods5s);
        return "index8";
    }
   @RequestMapping("daobiaoview")
    public String daoChu(){
        List<Goods1> goods1s = goodService1.loadAll();
        readServiceimpl.exportExcel(goods1s);
        return "redirect:indexview3";
    }
    @RequestMapping("mohuchaxun1")
    public String moHuChaXunGoods(String sql,Model model){
        List<Goods1> mohugoods = goodService1.moHuChaXunGoods(sql);
        model.addAttribute("mohugoods",mohugoods);
        return "mohu";
    }
    @RequestMapping("/plshanchuGoods")
    public String deleteplGoods(@RequestParam("ids") List<Integer> ids){
        System.out.println(ids);
        boolean bool= goodService1.deleteplGoods(ids);
        System.out.println(bool);
        return bool?"redirect:/indexview3":"error";
    }
}
