package com.simo.meitan.service;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.simo.meitan.model.PtRole;
public interface PtRoleService{


    int deleteByPrimaryKey(String roleUuid);

    int insert(PtRole record);

    int insertSelective(PtRole record);

    PtRole selectByPrimaryKey(String roleUuid);

    int updateByPrimaryKeySelective(PtRole record);

    int updateByPrimaryKey(PtRole record);



    PageInfo<PtRole> selectAllByRoleNameLikeAndRoleIdLike(
            String likeRoleName,
            String likeRoleId,
            Integer page,
            Integer size);


}
