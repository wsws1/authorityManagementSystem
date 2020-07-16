package com.simo.meitan.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.simo.meitan.model.PtUser;

public interface PtUserMapper {
    int deleteByPrimaryKey(String userUuid);

    int insert(PtUser record);

    int insertSelective(PtUser record);

    PtUser selectByPrimaryKey(String userUuid);

    int updateByPrimaryKeySelective(PtUser record);

    int updateByPrimaryKey(PtUser record);


    List<PtUser> selectAllByUsernameLikeAndOrganUuidLikeAndDutyUuidLike(@Param("likeUsername")String likeUsername,@Param("likeOrganUuid")String likeOrganUuid,@Param("likeDutyUuid")String likeDutyUuid);



}