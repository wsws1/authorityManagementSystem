package com.simo.meitan.service.serviceImpl;
import java.util.List;

import com.simo.meitan.dto.PtRoleDTO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.simo.meitan.mapper.PtRoleResMapper;
import com.simo.meitan.model.PtRoleRes;
import com.simo.meitan.service.PtRoleResService;
@Service
public class PtRoleResServiceImpl implements PtRoleResService{

    @Resource
    private PtRoleResMapper ptRoleResMapper;

    @Override
    public int insert(PtRoleRes record) {
        return ptRoleResMapper.insert(record);
    }

    @Override
    public int insertSelective(PtRoleRes record) {
        return ptRoleResMapper.insertSelective(record);
    }

	@Override
	public List<String> selectAllByRoleUuid(String roleUuid){
		 return ptRoleResMapper.selectAllByRoleUuid(roleUuid);
	}

    @Override
    public int addResListByRoleUuid(PtRoleDTO ptRoleDTO) {
        ptRoleResMapper.deleteByRoleUuid(ptRoleDTO.getRoleUuid());
        if(ptRoleDTO.getResList()==null||ptRoleDTO.getResList().size()==0){
            return  0;
        }
        return ptRoleResMapper.addRes(ptRoleDTO.getRoleUuid(),ptRoleDTO.getResList());
    }

	@Override
	public int deleteByRoleUuid(String roleUuid){
		 return ptRoleResMapper.deleteByRoleUuid(roleUuid);
	}



}
