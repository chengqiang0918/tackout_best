package com.sl.tackout.controller;

import com.sl.tackout.pojo.RoleTable;
import com.sl.tackout.service.RoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by happy on 2019/8/28.
 */
@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;



    @RequestMapping("determine_purchase")//提交购买会员订单
    public String determinePurchase(HttpSession session, Model model){
        String userName = (String) session.getAttribute("userName");
        Subject subject = SecurityUtils.getSubject();
        //查看当前用户的所有角色
        List<RoleTable> thisUrRole = roleService.findThisUrRole(userName);

        if (thisUrRole.isEmpty()){//没有角色
            boolean addMemberRole = roleService.addMemberRole(userName);
            if (addMemberRole){
                return "redirect:findAll";
            }else {
                model.addAttribute("error","购买失败，请重试");
                return "bm_pay";
            }
        }else {
            for (RoleTable role:thisUrRole) {
                if ("会员".equals(role.getRoleName())){
                    model.addAttribute("error","你已经是会员了，请勿重复购买");
                    return "bm_pay";
                }else {
                    boolean addMemberRole = roleService.addMemberRole(userName);
                    if (addMemberRole){
                        return "main";
                    }else {
                        model.addAttribute("error","购买失败，请重试");
                        return "bm_pay";
                    }
                }
            }
            return "bm_pay";
        }

    }
}
