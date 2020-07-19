package com.simo.meitan.mapper;

import com.simo.meitan.model.PtMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;
import java.util.Map;

public interface PtMenuMapper {
    int deleteByPrimaryKey(String menuUuid);

    int insert(PtMenu record);

    int insertSelective(PtMenu record);

    PtMenu selectByPrimaryKey(String menuUuid);

    int updateByPrimaryKeySelective(PtMenu record);

    int updateByPrimaryKey(PtMenu record);

    List<PtMenu> selectPtResForestByParentUUID(String parentUuid);

    List<PtMenu> selectPtResForestByParentUUIDAndRoleUuid(
            @Param("parentUuid") String parentUuid,
            @Param("roleUuid") String roleUuid);

    List<PtMenu> selectAllByRoleUuid(String roleUuid);

    void deleteMenu(Map<String,Object> delVO);

    List<PtMenu> selectAllByTitleLikeAndType(@Param("name") String name,
                                            @Param("type") Integer type);

}