package com.manage.controller;

import com.manage.entity.User;
import com.manage.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/out")
    @ResponseBody
    public HashMap out(User param){
        System.err.println(param);
        User userInfo = loginService.queryUserInfoByLoginId(param.getLogin_id());
        HashMap newmap = new HashMap();
        newmap.put("code",userInfo);
        System.err.println(newmap);
        return newmap;
    }
}
