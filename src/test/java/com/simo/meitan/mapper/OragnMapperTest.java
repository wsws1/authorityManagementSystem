package com.simo.meitan.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class OragnMapperTest {

    @Autowired
    PtOrganMapper mapper;
    @Test
    public void testDelete(){
        String key="bbbb";
        int recode=-1;
        Map<String,Object> map=new HashMap<>();
        map.put("organUUID",key);
        map.put("recode",recode);
        mapper.deleteOrgan(map);
        recode=(Integer) map.get("recode");
        System.out.println("recode "+recode);
    }
}
