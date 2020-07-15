package com.simo.meitan.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.simo.meitan.model.PtRoleRes;

public interface PtRoleResMapper {
    int insert(PtRoleRes record);

    int insertSelective(PtRoleRes record);

    List<String> selectAllByRoleUuid(@Param("roleUuid")String roleUuid);

    int deleteByRoleUuid(@Param("roleUuid")String roleUuid);


	int addRes(@Param("roleId") String roleId,@Param("resList") List<String> resList);


}