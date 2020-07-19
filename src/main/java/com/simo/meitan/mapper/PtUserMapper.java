package com.simo.meitan.mapper;

import com.simo.meitan.model.PtUser;
import org.apache.ibatis.annotations.Param;import java.util.List;

public interface PtUserMapper {
    int deleteByPrimaryKey(@Param("userUuid") String userUuid, @Param("username") String username);

    int insert(PtUser record);

    int insertSelective(PtUser record);

//    PtUser selectByPrimaryKey(@Param("userUuid") String userUuid, @Param("username") String username);

    int updateByPrimaryKeySelective(PtUser record);

    int updateByPrimaryKey(PtUser record);

    int deleteByPrimaryKey(String userUuid);

    PtUser selectByPrimaryKey(String userUuid);

    List<PtUser> selectAllByUsernameLikeAndOrganUuidLikeAndDutyUuidLike(@Param("likeUsername") String likeUsername, @Param("likeOrganUuid") String likeOrganUuid, @Param("likeDutyUuid") String likeDutyUuid);

    PtUser selectOneByUsername(@Param("username") String username);
}