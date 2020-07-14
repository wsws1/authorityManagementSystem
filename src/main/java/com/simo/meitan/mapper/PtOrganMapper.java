package com.simo.meitan.mapper;
import java.util.List;

import com.simo.meitan.model.PtOrgan;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface PtOrganMapper {

    int insert(PtOrgan record);

    int insertSelective(PtOrgan record);

    PtOrgan selectPtOrganTressByParentUUID(String organUuid);

    int updateByPrimaryKeySelective(PtOrgan record);

    int updateByPrimaryKey(PtOrgan record);

    void deleteOrgan(Map<String,Object> delVO);

    PtOrgan selectOneByOrganUuid(@Param("organUuid")String organUuid);

    List<PtOrgan> selectAllByOrganNameLikeAndAccountCodeLikeAndInUseOrderByModtimeAsc(
            @Param("likeOrganName")String likeOrganName,
            @Param("likeAccountCode")String likeAccountCode,
            @Param("inUse")Boolean inUse);

    List<PtOrgan> selectAllByOrganNameLikeAndAccountCodeLikeAndInUseOrderByModtimeDesc(
            @Param("likeOrganName")String likeOrganName,
            @Param("likeAccountCode")String likeAccountCode,
            @Param("inUse")Boolean inUse);


}