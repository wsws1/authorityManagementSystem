package com.simo.meitan.service;

import com.github.pagehelper.PageInfo;
import com.simo.meitan.model.PtUser;
public interface PtUserService{


    int deleteByPrimaryKey(String userUuid);

    int insert(PtUser record);

    int insertSelective(PtUser record);

    PtUser selectByPrimaryKey(String userUuid);

    int updateByPrimaryKeySelective(PtUser record);

    int updateByPrimaryKey(PtUser record);


    PageInfo<PtUser> selectAllByUserNameLikeAndOrganUuidLikeAndDutyUuidLike(
            String userName,
            String organUuid,
            String dutyUuid,
            Integer page,
            Integer size
    );
}
