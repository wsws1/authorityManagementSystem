package com.simo.meitan.service;
import java.util.List;

import com.simo.meitan.model.Contents;

public interface ContentsService {


    int deleteByPrimaryKey(Integer id);

    int insert(Contents record);

    int insertSelective(Contents record);

    Contents selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Contents record);

    int updateByPrimaryKey(Contents record);



	List<Contents> selectAllByBookid(Integer bookid);


}




