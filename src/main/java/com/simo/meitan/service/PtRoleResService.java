package com.simo.meitan.service;
import java.util.List;

import com.simo.meitan.dto.PtRoleDTO;
import com.simo.meitan.model.PtRoleRes;
public interface PtRoleResService{


    int insert(PtRoleRes record);

    int insertSelective(PtRoleRes record);



	List<String> selectAllByRoleUuid(String roleUuid);




	int deleteByRoleUuid(String roleUuid);

}
