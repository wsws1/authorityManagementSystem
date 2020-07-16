package com.simo.meitan.service;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.simo.meitan.model.PtDuty;

public interface PtDutyService{


    int deleteByPrimaryKey(String dutyid);

    int insert(PtDuty record);

    int insertSelective(PtDuty record);

    PtDuty selectByPrimaryKey(String dutyid);

    int updateByPrimaryKeySelective(PtDuty record);

    int updateByPrimaryKey(PtDuty record);



    PageInfo<PtDuty> selectAllByNameLikeAndOrganUuidLikeAndRoleUuidLike(
	        String likeName,
            String likeOrganUuid,
            String likeRoleUuid,
            Integer page,
            Integer size);



	List<PtDuty> selectAllByOrganUuid(String organUuid);


}
