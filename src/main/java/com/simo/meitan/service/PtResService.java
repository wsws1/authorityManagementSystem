package com.simo.meitan.service;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.simo.meitan.model.PtOrgan;
import com.simo.meitan.model.PtRes;
public interface PtResService{


    int deleteByPrimaryKey(String resUuid);

    int addRes(PtRes record);

    PtRes getResTree();

    int insertSelective(PtRes record);

    PtRes selectByPrimaryKey(String resUuid);

    int updateByPrimaryKeySelective(PtRes record);

    int updateByPrimaryKey(PtRes record);

    PageInfo<PtRes> selectAllByResNameLikeAndResUrlLikeAndResType(String resName, String resUrl, String type, Integer page, Integer size) ;



}
