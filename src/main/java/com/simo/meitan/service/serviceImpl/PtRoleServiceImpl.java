package com.simo.meitan.service.serviceImpl;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simo.meitan.model.PtOrgan;
import com.simo.meitan.utils.UUIDUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.simo.meitan.model.PtRole;
import com.simo.meitan.mapper.PtRoleMapper;
import com.simo.meitan.service.PtRoleService;
import org.springframework.util.StringUtils;

@Service
public class PtRoleServiceImpl implements PtRoleService{

    @Resource
    private PtRoleMapper ptRoleMapper;

    @Override
    public int deleteByPrimaryKey(String roleUuid) {
        return ptRoleMapper.deleteByPrimaryKey(roleUuid);
    }

    @Override
    public int insert(PtRole record) {
        return ptRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(PtRole record) {
        return ptRoleMapper.insertSelective(record);
    }

    @Override
    public PtRole selectByPrimaryKey(String roleUuid) {
        return ptRoleMapper.selectByPrimaryKey(roleUuid);
    }

    @Override
    public int updateByPrimaryKeySelective(PtRole record) {
        return ptRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PtRole record) {
        return ptRoleMapper.updateByPrimaryKey(record);
    }

	@Override
    public PageInfo<PtRole> selectAllByRoleNameLikeAndRoleIdLike(
            String likeRoleName,
            String likeRoleId,
            Integer page,
            Integer size){


        PageHelper pageHelper=new PageHelper();
        pageHelper.startPage(page,size);
        List<PtRole> ptRoleList=null;

        ptRoleList=ptRoleMapper.selectAllByRoleNameLikeAndRoleIdLike(
                likeRoleName,
                likeRoleId
        );
        return new PageInfo<>(ptRoleList);
    }



}
