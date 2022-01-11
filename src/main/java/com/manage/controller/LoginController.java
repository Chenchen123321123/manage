package com.manage.controller;

import com.manage.entity.User;
import com.manage.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    /**
    * @Description: 登录接口
    * @Author:Chenc281
    * @Date:14:11 2021/12/30
    */
    @RequestMapping("/login")
    @ResponseBody
    public HashMap Login(User userLogin){
        User userInfo = loginService.queryUserInfoByLoginId(userLogin.getLogin_id());
        Subject subject = SecurityUtils.getSubject();
        String userName = userLogin.getLogin_id();
        String password = userLogin.getPassword();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        subject.login(token);
        Session session = subject.getSession();
        Serializable sessionId = session.getId();
        HashMap newmap = new HashMap();
        newmap.put("code",userInfo);
        return newmap;
    }
    /**
    * @Description:用户注册接口
    * @Author:Chenc281
    * @Date:14:28 2021/12/31
    */
    @RequestMapping("/register")
    @ResponseBody
    public HashMap Register(User userLogin){
        //根据当前时间生成一个userid
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String userid="";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        userid = sdf.format(date);
        userLogin.setUser_id(userid);
        userLogin.setSalt(userLogin.getLogin_id());
        int result = loginService.insertUserInfo(userLogin);
        HashMap resultMap = new HashMap();
        if(result>0){
            resultMap.put("code","success");
        }
        return resultMap;
    }
}
