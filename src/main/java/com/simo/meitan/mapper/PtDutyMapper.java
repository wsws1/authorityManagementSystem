package com.simo.meitan.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.simo.meitan.model.PtDuty;

public interface PtDutyMapper {
    int deleteByPrimaryKey(String dutyid);

    int insert(PtDuty record);

    int insertSelective(PtDuty record);

    PtDuty selectByPrimaryKey(String dutyid);

    int updateByPrimaryKeySelective(PtDuty record);

    int updateByPrimaryKey(PtDuty record);

    List<PtDuty> selectAllByNameLikeAndOrganUuidLikeAndRoleUuidLike(@Param("likeName")String likeName,@Param("likeOrganUuid")String likeOrganUuid,@Param("likeRoleUuid")String likeRoleUuid);



}