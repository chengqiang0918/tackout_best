package com.sl.tackout.controller;

import com.sl.tackout.pojo.OrderTable;
import com.sl.tackout.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by happy on 2019/8/27.
 */
@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;


    @RequestMapping("my_order")//我的近一个月订单
    public String myOrder (HttpSession session, Model model){
        String  userName = (String) session.getAttribute("userName");
        List<OrderTable> orderList = orderService.findUserOrder(userName);
        model.addAttribute("orderList",orderList);
        return "my_order";
    }
}
