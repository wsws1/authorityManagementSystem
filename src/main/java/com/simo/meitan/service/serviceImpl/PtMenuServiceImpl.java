package com.simo.meitan.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simo.meitan.model.PtRes;
import com.simo.meitan.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.simo.meitan.mapper.PtMenuMapper;
import com.simo.meitan.model.PtMenu;
import com.simo.meitan.service.PtMenuService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PtMenuServiceImpl implements PtMenuService{

    @Resource
    private PtMenuMapper ptMenuMapper;


    @Value("${sql.menu.root.uuid}")
    private String menuRootUuid;

    @Override
    public int deleteByPrimaryKey(String menuUuid) {
        int recode=0;
        Map<String,Object> map=new HashMap<>();
        map.put("menuId",menuUuid);
        map.put("recode",recode);
        ptMenuMapper.deleteMenu(map);
        recode=(Integer) map.get("recode");
        return recode;
    }

    @Override
    public int addMenu(PtMenu record) {
        //step1 查询父ID 是否存在
        // 若不在，则错误
        // 若在，更新isParent true
        System.out.println("parent uuid "+record.getParentUuid());
        PtMenu feather=ptMenuMapper.selectByPrimaryKey(record.getParentUuid());
        if (feather==null){
            return 0;
        }
        //step2 插入子组织
        record.setMenuUuid(UUIDUtil.getUUID());
        return ptMenuMapper.insert(record);
    }

    @Override
    public int insertSelective(PtMenu record) {
        return ptMenuMapper.insertSelective(record);
    }

    @Override
    public PtMenu selectByPrimaryKey(String menuUuid) {
        return ptMenuMapper.selectByPrimaryKey(menuUuid);
    }

    @Override
    public int updateByPrimaryKeySelective(PtMenu record) {
        return ptMenuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PtMenu record) {
        return ptMenuMapper.updateByPrimaryKey(record);
    }


    @Override
    public List<PtMenu> selectPtResTressByParentUUID() {
        return ptMenuMapper.selectPtResForestByParentUUID(menuRootUuid);
    }

    @Override
    public List<PtMenu> getRoleSelectedMenuForest(String roleUuid) {

//        List<PtMenu> ptMenuList=ptMenuMapper.selectAllByRoleUuid(roleUuid);
//        List<PtMenu> ptMenuForest=generateMenuTree(ptMenuList);
        return ptMenuMapper.selectPtResForestByParentUUIDAndRoleUuid(menuRootUuid,roleUuid);
    }

    private List<PtMenu> generateMenuTree(List<PtMenu> ptMenuList) {
        List<PtMenu> ptMenuForest = new ArrayList<>();
        //儿子表
        Set<String> ids = new HashSet<>();
        for (PtMenu menuDTO : ptMenuList) {
            if (menuDTO.getParentUuid() == menuRootUuid) {
                ptMenuForest.add(menuDTO);
            }
            for (PtMenu it : ptMenuList) {
                if (menuDTO.getMenuUuid().equals(it.getParentUuid())) {
                    if (menuDTO.getChildren() == null) {
                        menuDTO.setChildren(new ArrayList<>());
                    }
                    menuDTO.getChildren().add(it);
                    ids.add(it.getMenuUuid());
                }
            }
        }
        if(ptMenuForest.size() == 0){
            ptMenuForest = ptMenuList.stream().filter(s -> !ids.contains(s.getMenuUuid())).collect(Collectors.toList());
        }

        return ptMenuForest;
    }

    @Override
    public PageInfo<PtMenu> selectPtMenuByTitleLikeAndType(String menuName, Integer menuType,Integer page, Integer size) {
        PageHelper pageHelper=new PageHelper();
        pageHelper.startPage(page,size);
        List<PtMenu> ptMenuList=null;
        ptMenuList=ptMenuMapper.selectAllByTitleLikeAndType(
                menuName,
                menuType
        );
        return new PageInfo<>(ptMenuList);
    }

}
