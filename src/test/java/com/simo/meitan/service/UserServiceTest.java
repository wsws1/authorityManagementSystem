package com.simo.meitan.service;

import com.simo.meitan.model.AdminUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    AdminUserService userService;

    @Test
    void testSelectOneUserByUserName(){
        AdminUser user=userService.selectOneByUsername("sang");
        System.out.println(user.getPassword());
    }
}
