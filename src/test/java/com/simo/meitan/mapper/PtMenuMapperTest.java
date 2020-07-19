package com.simo.meitan.mapper;

import com.simo.meitan.service.PtMenuService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class PtMenuMapperTest {

    @Resource
    PtMenuMapper ptMenuMapper;


    @Test
    public void getTree(){
        String parentUuid="1";
//        System.out.println(ptMenuMapper.selectPtResTressByParentUUID(parentUuid));
    }

    @Test
    public void getMenuListByRoleUuid(){
        String roleUuid="f2cf2f624ecd488bad48373e38835edc";
        System.out.println(ptMenuMapper.selectPtResForestByParentUUIDAndRoleUuid("1",roleUuid));
    }

}
