package com.simo.meitan.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.simo.meitan.model.Contents;

public interface ContentsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Contents record);

    int insertSelective(Contents record);

    Contents selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Contents record);

    int updateByPrimaryKey(Contents record);

    List<Contents> selectAllByBookid(@Param("bookid")Integer bookid);



}