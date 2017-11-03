package com.project.controller;

import com.project.model.UserEntity;
import com.project.service.impl.UserServiceImp;
import com.project.util.DataTypeConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wangchangyuan on 2017/11/3.
 */
@Controller
public class UserController {
    @Autowired
    UserServiceImp userServiceImp;


    //select 展示数据
    String userPage = "user/info";
    @RequestMapping(value = {"user/info", "user/info/"}, method = RequestMethod.GET)
    public String selectModelTask(Model model) {
        model.addAttribute("users", userServiceImp.selectUserInfo());
        return userPage;
    }

    //增加数据到数据库  insert
    @ResponseBody
    @RequestMapping(value = {"/user/addInfo"}, method = RequestMethod.POST)
    public void addModelTask(String user){
        System.out.println("user: " + user);
        UserEntity userEntity = DataTypeConvert.String2User(user);
        System.out.println(userEntity);
        userServiceImp.insertUserInfo(userEntity);
    }
}
