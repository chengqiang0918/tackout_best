package com.sl.tackout.controller;

import com.sl.tackout.pojo.BusinessTable;
import com.sl.tackout.service.BusinessService;
import com.sl.tackout.utils.ImgCode;
import com.sl.tackout.utils.MD5;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by happy on 2019/8/23.
 */
@Controller
public class BusinessController {
    @Autowired
    private BusinessService businessService;

    @RequestMapping("toBt_reg")
    public String toBt_reg(){
        return "business_reg";
    }
    @RequestMapping("toBt_login")
    public String toBtLogin(){
        return "business_login";
    }


    @RequestMapping("business_reg")
    public String businessReg(String btName, String btPwd, String btPhone , String btImgCode, Model model, HttpSession session){
        if (btName==null || btName=="" || btPwd==null || btPwd=="" || btPhone==null || btPhone=="" || btImgCode==null || btImgCode ==""){

            model.addAttribute("error","必填项不能为空");

            return "business_reg";

        }else {
            String imgCode = (String) session.getAttribute(ImgCode.RANDOMCODEKEY);
            if (StringUtils.startsWithIgnoreCase(imgCode,btImgCode)) {//验证码正确

                BusinessTable businessByLoginName = businessService.findBusinessByLoginName(btName);
                if (businessByLoginName!=null){

                    model.addAttribute("error","输入的用户已存在");
                    return "business_reg";
                }else {
                    int tbId = businessService.findMaxBtId()+1;
                    int state=1;
                    String md5BtPwd = new MD5().getMD5ofStr(btPwd);
                    BusinessTable businessTable = new BusinessTable(tbId, md5BtPwd, btPwd, null, btPhone, state, null, null, null);
                    boolean addBt = businessService.addBt(businessTable);
                    if (addBt){

                        return "business_login";
                    }else {
                        model.addAttribute("error", "注册失败,请再试一遍");
                        return "business_reg";
                    }
                }

            }else {
                model.addAttribute("error", "验证码错误");
                return "business_reg";
            }

        }
    }
    @RequestMapping("business_login")
    public String businessLogin(String btName, String btPwd, String btPhone , String btImgCode, Model model, HttpSession session){
        System.out.println(btName);
        System.out.println(btPwd);
        if (btName==null || btName=="" || btPwd==null || btPwd=="" || btImgCode==null || btImgCode ==""){
                model.addAttribute("error","必填项不能为空");
                return "business_login";
            }else {
                String imgCode = (String) session.getAttribute(ImgCode.RANDOMCODEKEY);
                if (StringUtils.startsWithIgnoreCase(imgCode,btImgCode)) {//验证码正确
                    /*String md5BtPwd = new MD5().getMD5ofStr(btPwd);*/
                    boolean btBynp = businessService.findBtBynp(btName, btPwd);
                    if (btBynp){//有此用户
                        return "redirect:indexview3";
                    }else {
                        model.addAttribute("error", "用户名或密码错误");
                        return "business_login";
                    }

                }else {
                    model.addAttribute("error", "验证码错误");
                    return "business_login";
                }

            }

    }



}
