package com.simo.meitan.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class PtDutyMapperTest {

    @Resource
    PtDutyMapper mapper;
    @Test
    public void  getPtUserById(){
        String key="ajsdvasjhdvsajdv";
        System.out.println(mapper.selectByPrimaryKey(key));
    }
}
