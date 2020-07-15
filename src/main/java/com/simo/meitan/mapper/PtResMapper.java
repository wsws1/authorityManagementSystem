package com.simo.meitan.mapper;
import com.simo.meitan.model.PtOrgan;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

import com.simo.meitan.model.PtRes;

public interface PtResMapper {
    int deleteByPrimaryKey(String resUuid);

    int insert(PtRes record);

    int insertSelective(PtRes record);

    PtRes selectByPrimaryKey(String resUuid);

    int updateByPrimaryKeySelective(PtRes record);

    int updateByPrimaryKey(PtRes record);

    List<PtRes> selectAllByResNameLikeAndResUrlLikeAndResType(@Param("likeResName")String likeResName,@Param("likeResUrl")String likeResUrl,@Param("resType")String resType);

    void deleteRes(Map<String,Object> delVO);

    PtRes selectPtResTressByParentUUID(String resUuid);

}