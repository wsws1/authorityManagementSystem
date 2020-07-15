package com.simo.meitan.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.simo.meitan.model.PtRole;

public interface PtRoleMapper {
    int deleteByPrimaryKey(String roleUuid);

    int insert(PtRole record);

    int insertSelective(PtRole record);

    PtRole selectByPrimaryKey(String roleUuid);

    int updateByPrimaryKeySelective(PtRole record);

    int updateByPrimaryKey(PtRole record);


    List<PtRole> selectAllByRoleNameLikeAndRoleIdLike(@Param("likeRoleName")String likeRoleName,@Param("likeRoleId")String likeRoleId);



}