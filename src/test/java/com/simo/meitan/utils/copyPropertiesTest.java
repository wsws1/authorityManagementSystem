package com.simo.meitan.utils;

import com.simo.meitan.dto.PtOrganDTO;
import com.simo.meitan.model.PtOrgan;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

public class copyPropertiesTest {

    @Test
    public  void testCopy(){
        PtOrgan target =new PtOrgan();
        PtOrganDTO ptOrganDTO=new PtOrganDTO();
        ptOrganDTO.setOrganName("123");
        BeanUtils.copyProperties(ptOrganDTO,target);
        System.out.println(target.getOrganName());
    }
}
