package com.simo.meitan.service;

import com.simo.meitan.model.PtMenu;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class PtMenuServiceTest {


    @Resource
    PtMenuService ptMenuService;

    @Test
    public void testGetMenuForest(){
        String roleUuid="f2cf2f624ecd488bad48373e38835edc";
        List<PtMenu> ptMenus=ptMenuService.getRoleSelectedMenuForest(roleUuid);
        System.out.println(ptMenus);
    }
    @Test
    public void testDelete(){
        String key="32";
        System.out.println(ptMenuService.deleteByPrimaryKey(key));
    }
    @Test
    public void testSelectPtMenuByNameLikeAndType(){
        String title="用户";
        Integer type=0;
//        System.out.println(ptMenuService.selectPtMenuByTitleLikeAndType(title,type));
    }
}
