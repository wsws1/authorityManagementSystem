package com.simo.meitan.service.serviceImpl;

import com.simo.meitan.dto.PtRoleDTO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.simo.meitan.mapper.PtRolesMenusMapper;
import com.simo.meitan.model.PtRolesMenus;
import com.simo.meitan.service.PtRolesMenusService;

import java.util.List;

@Service
public class PtRolesMenusServiceImpl implements PtRolesMenusService{

    @Resource
    private PtRolesMenusMapper ptRolesMenusMapper;

    @Override
    public int deleteByPrimaryKey(String roleUuid,String menuUuid) {
        return ptRolesMenusMapper.deleteByPrimaryKey(roleUuid,menuUuid);
    }

    @Override
    public int insert(PtRolesMenus record) {
        return ptRolesMenusMapper.insert(record);
    }

    @Override
    public int insertSelective(PtRolesMenus record) {
        return ptRolesMenusMapper.insertSelective(record);
    }


    @Override
    public List<String> getPermissionListByRoleUuid(String roleUuid) {
        return ptRolesMenusMapper.getPermissionListByRoleUuid(roleUuid);
    }
    @Override
    public int addMenuListByRoleUuid(PtRoleDTO ptRoleDTO) {
        ptRolesMenusMapper.deleteByRoleUuid(ptRoleDTO.getRoleUuid());
        if(ptRoleDTO.getMenuList()==null||ptRoleDTO.getMenuList().size()==0){
            return  0;
        }
        return ptRolesMenusMapper.addMenus(ptRoleDTO.getRoleUuid(),ptRoleDTO.getMenuList());
    }

    @Override
    public int deleteByRoleUuid(String roleUuid) {
        return ptRolesMenusMapper.deleteByRoleUuid(roleUuid);
    }

    @Override
    public List<String> getSelectedMenuUuidByRoleUuid(String roleUuid) {
        return ptRolesMenusMapper.selectAllByRoleUuid(roleUuid);
    }
}
