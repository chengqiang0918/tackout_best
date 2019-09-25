package com.sl.tackout.controller;

import com.sl.tackout.pojo.CouponTable;
import com.sl.tackout.pojo.UserTable;
import com.sl.tackout.service.CouponService;
import com.sl.tackout.service.UserService;
import com.sl.tackout.utils.ImgCode;
import com.sl.tackout.utils.MD5;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static javax.print.attribute.standard.MediaPrintableArea.MM;

/**
 * Created by happy on 2019/8/21.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CouponService couponService;
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("reg")
    public String reg() {
        return "reg";
    }

    @RequestMapping("login")
    public String login() {
        return "login";
    }
    @RequestMapping("loginOut")
    public String loginOut() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();//用户登出，清除用户在shiro中的驻留信息
        return "redirect:login";
    }
    @RequestMapping("main")//用户主页面
    public String main() {


        return "main";
    }

    @RequestMapping("user_center")//用户个人中心
    public String userCenter(){
        return "user_center";
    }
    @RequestMapping("personal_info")//个人信息
    public String personalInfo(HttpSession session,Model model){
        String userName = (String) session.getAttribute("userName");
        UserTable userInfo = userService.findUserByLoginName(userName);
        if (userInfo!=null){
            model.addAttribute("userInfo",userInfo);
            return "personal_info";
        }else {
            return "login";
        }
    }
    @RequestMapping("user_info")//修改个人信息
    public String userInfo(UserTable userTable,Model model){
        if (userTable.getUserRealname()!=null || userTable.getUserAdress()!=null
                || userTable.getUserRealname()!="" || userTable.getUserAdress()!=""){
            boolean updateUserInfo = userService.updateUserInfo(userTable);
            if (updateUserInfo){

                return "redirect:findAll";
            }else {

                return "personal_info";
            }
        }else {
            model.addAttribute("error","信息不能为空");
            return "personal_info";
        }
    }





    @RequestMapping("bm_pay")//购买会员
    public String bmPay(){
        return "bm_pay";
    }
    @RequiresPermissions("coupon")
    @RequestMapping("member_coupon")//到优惠券页面
    public String buyingMembers() {
        return "member_coupon";
    }


    @RequestMapping(value = "/confirm_receive/{cvalue}")//给用户领取优惠券
    public String confirmReceive(@PathVariable("cvalue")
        String couponValue, HttpSession session){

        int maxCid = couponService.findMaxCid();

        int cvalue=Integer.parseInt(couponValue);
        String userName = (String) session.getAttribute("userName");
        UserTable userByLoginName = userService.findUserByLoginName(userName);
        int userId = userByLoginName.getUserId();
        Date date = new Date();//当前时间
        Calendar today = Calendar.getInstance();
        today.add(Calendar.DAY_OF_YEAR,7);
        Date time = today.getTime();//七天后的时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowdate = simpleDateFormat.format(date);
        String ftime = simpleDateFormat.format(time);
        CouponTable couponTable = new CouponTable(maxCid + 1, cvalue, nowdate, ftime, 1, userId);

        couponService.addUserCoupon(couponTable);
        return "drink";
    }
    @RequestMapping("my_coupon")//用户查看优惠券
    public String myCoupon(HttpSession session,Model model){
        String userName = (String) session.getAttribute("userName");
        List<CouponTable> allUrCoupon = couponService.findAllUrCoupon(userName);
        model.addAttribute("allUrCoupon",allUrCoupon);
        return "my_coupon";
    }

    @RequestMapping("drink")//点餐
    public String drink(HttpSession session) {
        String userName = (String) session.getAttribute("userName");
        UserTable userInfo = userService.findUserByLoginName(userName);
        if (userInfo.getUserRealname()!=null && userInfo.getUserAdress()!=null){
            return "drink";
        }else {
            return "user_center";
        }

    }
    @RequestMapping("order")//提交订单
    public String pay(HttpSession session,Model model) {
        String userName = (String) session.getAttribute("userName");
        UserTable userInfo = userService.findUserByLoginName(userName);
        model.addAttribute("user",userInfo);

        List<CouponTable> allUrCoupon = couponService.findAllUrCoupon(userName);
        model.addAttribute("allUrCoupon",allUrCoupon);
        return "order";
    }
    @RequestMapping("upAddress")//修改地址
    public String upAddress(HttpSession session,Model model) {
        String userName = (String) session.getAttribute("userName");
        UserTable userInfo = userService.findUserByLoginName(userName);
        model.addAttribute("address",userInfo.getUserAdress());
        return "upAddress";
    }
    @RequestMapping("newAddress")//更换新地址
    public String newAddress(HttpSession session,Model model,String userAddress) {
        System.out.println(userAddress);
        String userName = (String) session.getAttribute("userName");
        boolean updateUserAddress = userService.updateUserAddress(userAddress, userName);
        if (updateUserAddress){
            return "redirect:order";
        }else {

            return "upAddress";
        }

    }

    //验证码显示
    @RequestMapping("getImg")
    public void getImg(HttpServletRequest request, HttpServletResponse response) {
        new ImgCode().getRandcode(request, response);
    }

    //    注册
    @RequestMapping("register")
    public String register(String userName, String userPwd, String userPhone, String userImgCode, Model model, HttpSession session) {
        if (userName != null && userName != "" && userPwd != null && userPwd != "" && userPhone != null && userPhone != "") {
            String imgCode = (String) session.getAttribute(ImgCode.RANDOMCODEKEY);
            if (StringUtils.startsWithIgnoreCase(imgCode,userImgCode)) {//验证码正确

            UserTable userByLoginName = userService.findUserByLoginName(userName);
            if (userByLoginName != null) {
                model.addAttribute("error", "您输入的用户名已存在，请重新输入");
                return "reg";
            } else {
                int UserId = userService.findMaxUserId() + 1;
                String md5Upwd = new MD5().getMD5ofStr(userPwd);
                Date date = new Date();
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
                UserTable userTable = new UserTable(UserId, userName, md5Upwd,null,userPhone,null, date, null);
                boolean b = userService.addUser(userTable);
                if (b) {//添加成功
                    return "login";
                } else {
                    model.addAttribute("error", "注册失败,请再试一遍");
                    return "reg";
                }
            }
        } else {
            model.addAttribute("error", "必填项不能为空");
            return "reg";
        }
        }else {
            model.addAttribute("error", "验证码错误");
            return "reg";
        }
    }

    //    登录验证
    @RequestMapping("isLogin")
    public String isLogin(String userName, String userPwd, String userImgCode, Model model,HttpSession session) {
        if (userName != null && userName != "" && userPwd != null && userPwd != "" && userImgCode != null && userImgCode != "") {
            String imgCode = (String) session.getAttribute(ImgCode.RANDOMCODEKEY);
            if (StringUtils.startsWithIgnoreCase(imgCode, userImgCode)) {//验证码正确
                Subject subject = SecurityUtils.getSubject();
                String md5Upwd = new MD5().getMD5ofStr(userPwd);
                UsernamePasswordToken token = new UsernamePasswordToken(userName, md5Upwd);
                try {
                    subject.login(token);
                    if (subject.isAuthenticated()) {
                        session.setAttribute("userName", userName);
                        return "redirect:findAll";
                    } else {
                        model.addAttribute("error", "登录失败,请再试一遍");
                        return "login";
                    }
                } catch (UnknownAccountException un) {
                    model.addAttribute("error", "用户名不存在");
                    return "login";
                } catch (IncorrectCredentialsException ice) {
                    model.addAttribute("error", "用户名或密码错误");
                    return "login";
//            }catch (AuthorizationException az){//权限不足
//                model.addAttribute("error", "你没有权限");
                } catch (AuthenticationException ae) {//身份验证失败
                    ae.printStackTrace();
                }

            } else {
                model.addAttribute("error", "验证码错误");
                return "login";
            }
        } else {//输入空信息
            model.addAttribute("error", "请输入完整的用户名密码");
            return "login";
        }
        return "login";
    }

}
