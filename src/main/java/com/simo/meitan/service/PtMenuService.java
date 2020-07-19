package com.simo.meitan.service;

import com.github.pagehelper.PageInfo;
import com.simo.meitan.model.PtMenu;
import com.simo.meitan.vo.MenuVO;
import org.omg.PortableInterceptor.INACTIVE;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.List;

public interface PtMenuService{


    int deleteByPrimaryKey(String menuUuid);

    int addMenu(PtMenu record);

    int insertSelective(PtMenu record);

    PtMenu selectByPrimaryKey(String menuUuid);

    int updateByPrimaryKeySelective(PtMenu record);

    int updateByPrimaryKey(PtMenu record);

    List<PtMenu> selectPtResTressByParentUUID();

    List<PtMenu> getRoleSelectedMenuForest(String roleUuid);

    public PageInfo<PtMenu> selectPtMenuByTitleLikeAndType(String menuName, Integer menuType, Integer page, Integer size);
}
