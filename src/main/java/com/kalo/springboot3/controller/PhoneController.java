package com.kalo.springboot3.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kalo.springboot3.entity.People;
import com.kalo.springboot3.mapper.PeopleMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Kalo
 * @create 2019-03-07 15:17
 */

@Controller
public class PhoneController {

    @Autowired
    private PeopleMapper mapper;

    @GetMapping(path = "/people")
    public PageInfo<People> insertPeople(){
        PageHelper.startPage(2,5);
      List<People> peopleList = mapper.findAll();
        PageInfo<People> info = new PageInfo<>(peopleList);
        System.out.println("已执行PageInfo------------");
        return info;
    }


    @GetMapping(value = "/shiro")
    public String shiro(String name,String password){
        System.out.println("+++++++++++++++  进入controller层 +++++++++++");
        System.out.println("name----"+name+"    password-----"+password);
        People people = mapper.findByName(name);
        System.out.println("查出来*******");
        System.out.println(people.toString());
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        Subject subject = SecurityUtils.getSubject();

            subject.login(token);

        System.out.println("---------------- 出controller层 -------------");
        return "shiro.html";
    }

    @RequiresAuthentication()
    //@RequiresPermissions("kalo")
    @GetMapping(path = "/shiroT")
    public String shiroT(){
        System.out.println("+++++++++++++++  进入shiroT方法controller层 +++++++++++");
        System.out.println("---------------- 出controller层 -------------");
        return "kalo.html";
    }
}
