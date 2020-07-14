package com.simo.meitan.controller;

import com.simo.meitan.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RequestMapping("")
@RestController
public class IndexController {
    @Autowired
    AdminUserService adminUserService;
//    @GetMapping("/login/{id}")
//    public AdminUser login(@PathVariable("id") Integer id){
//        return adminUserService.selectByPrimaryKey(id);
//    }

    @GetMapping("/hello")
    @RolesAllowed("user")
    public String hello(){
        return "hello";
    }
    @GetMapping("/admin")
    @RolesAllowed("admin")
    public String admin(){
        return "admin";
    }
}
