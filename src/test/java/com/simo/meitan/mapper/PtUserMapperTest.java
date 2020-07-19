package com.simo.meitan.mapper;

import com.simo.meitan.model.PtUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class PtUserMapperTest {
    @Resource
    PtUserMapper mapper;

    @Test
    public void testGetUserByUserName(){
        String name="admin";
        System.out.println(mapper.selectOneByUsername(name));
    }
}
