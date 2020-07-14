package com.simo.meitan.service;

import com.simo.meitan.model.PtOrgan;
import com.simo.meitan.utils.UUIDUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PtOrganServiceTest {

    @Autowired
    PtOrganService ptOrganService;

    @Test
    public void testSelectByPrimaryKey(){
        String key="42554f47c8614d7f8da370d8c7803f41";
        PtOrgan ptOrgan=ptOrganService.getOrganTree();
//        System.out.printf(ptOrgan.getOrganName());
        System.out.printf("children list size "+ptOrgan.getChildren().size());
    }

    @Test
    public void testInsert(){
        String key= UUIDUtil.getUUID();
        PtOrgan ptOrgan=new PtOrgan();
        ptOrgan.setOrganUuid(key);
        ptOrganService.addOrgan(ptOrgan);
    }
}
