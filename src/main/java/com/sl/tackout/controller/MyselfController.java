package com.sl.tackout.controller;

import com.sl.tackout.pojo.UserTable;
import com.sl.tackout.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyselfController {

    @Autowired
    private UserService userService;
    @RequestMapping("/loadUpdate")
    public String loadUpdate(UserTable userTable){
        boolean bool=userService.updateUserInfo(userTable);
        return bool?"zhanshi":"error";
    }

}
