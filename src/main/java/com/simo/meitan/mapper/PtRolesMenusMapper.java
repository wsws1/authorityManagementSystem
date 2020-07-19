package com.simo.meitan.mapper;

import com.simo.meitan.model.PtRolesMenus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PtRolesMenusMapper {
    int deleteByPrimaryKey(@Param("roleUuid") String roleUuid, @Param("menuUuid") String menuUuid);

    int insert(PtRolesMenus record);

    int insertSelective(PtRolesMenus record);

    List<String> getPermissionListByRoleUuid(String roleUuid);

    List<String> selectAllByRoleUuid(@Param("roleUuid")String roleUuid);

    int deleteByRoleUuid(@Param("roleUuid")String roleUuid);

    int addMenus(@Param("roleId") String roleId,@Param("menuList") List<String> menuList);
}