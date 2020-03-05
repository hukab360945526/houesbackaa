package com.team.houes.houesbacka.controller;

import com.team.houes.houesbacka.entity.Users;
import com.team.houes.houesbacka.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @ClassName UserController
 * @Description
 * @Author HU
 * @Date 2020/2/25 21:48
 */
@RestController
public class UserController {
    @Autowired
    private UsersService usersService;
    //编写注册控制器
    @RequestMapping("/userReg")
    @CrossOrigin(value = "*",allowCredentials = "true")
    public String userReg(Users users){
        int temp=usersService.userRegg(users);
        return "{\"result\":"+temp+"}";//成功1 失败0
    }//{"result":0}

    //编写登入控制器
    @RequestMapping("/userLogin")
    @CrossOrigin(value = "*",allowCredentials = "true")
    public String userLogin(String username,String password, HttpSession session){
       Users user= usersService.Login(username,password);
        if(user==null){
           return "{\"result\":0}";
       }else {
           session.setAttribute("logininfo",user);
           session.setMaxInactiveInterval(6000);
           return "{\"result\":1}";
       }
    }
}
