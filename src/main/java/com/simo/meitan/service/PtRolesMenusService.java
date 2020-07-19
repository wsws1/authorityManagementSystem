package com.simo.meitan.service;

import com.simo.meitan.dto.PtRoleDTO;
import com.simo.meitan.model.PtRolesMenus;

import java.util.List;

public interface PtRolesMenusService{


    int deleteByPrimaryKey(String roleUuid,String menuUuid);

    int insert(PtRolesMenus record);

    int insertSelective(PtRolesMenus record);

    List<String> getPermissionListByRoleUuid(String roleUuid);



	int deleteByRoleUuid(String roleUuid);

	int addMenuListByRoleUuid(PtRoleDTO ptRoleDTO);

	List<String> getSelectedMenuUuidByRoleUuid(String RoleUuid);
}
