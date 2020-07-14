package com.simo.meitan.mapper;

import com.simo.meitan.model.PtRes;

public interface PtResMapper {
    int deleteByPrimaryKey(String resUuid);

    int insert(PtRes record);

    int insertSelective(PtRes record);

    PtRes selectByPrimaryKey(String resUuid);

    int updateByPrimaryKeySelective(PtRes record);

    int updateByPrimaryKey(PtRes record);
}