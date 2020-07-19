package com.simo.meitan.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simo.meitan.dto.PtUserDTO;
import com.simo.meitan.dto.UserDTO;
import com.simo.meitan.mapper.*;
import com.simo.meitan.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.simo.meitan.service.PtUserService;

import java.util.ArrayList;
import java.util.List;

@Service("UserServiceImpl")
public class PtUserServiceImpl implements PtUserService, UserDetailsService {

    @Resource
    private PtUserMapper ptUserMapper;

    @Resource
    private PtDutyMapper ptDutyMapper;

    @Resource
    private PtRolesMenusMapper ptRolesMenusMapper;

    @Override
    public int deleteByPrimaryKey(String userUuid) {
        return ptUserMapper.deleteByPrimaryKey(userUuid);
    }

    @Override
    public int insert(PtUser record) {
        return ptUserMapper.insert(record);
    }

    @Override
    public int insertSelective(PtUser record) {
        return ptUserMapper.insertSelective(record);
    }

    @Override
    public PtUser selectByPrimaryKey(String userUuid) {
        return ptUserMapper.selectByPrimaryKey(userUuid);
    }

    @Override
    public int updateByPrimaryKeySelective(PtUser record) {
        return ptUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PtUser record) {
        return ptUserMapper.updateByPrimaryKey(record);
    }


    @Override
    public PageInfo<PtUser> selectAllByUserNameLikeAndOrganUuidLikeAndDutyUuidLike(String userName, String organUuid, String dutyUuid, Integer page, Integer size) {
        PageHelper pageHelper=new PageHelper();
        pageHelper.startPage(page,size);
        List<PtUser> ptUserList=null;

        ptUserList=ptUserMapper.selectAllByUsernameLikeAndOrganUuidLikeAndDutyUuidLike(
                userName,
                organUuid,
                dutyUuid
        );
        return new PageInfo<>(ptUserList);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PtUserDTO ptUserDTO=new PtUserDTO();
        PtUser ptUser=ptUserMapper.selectOneByUsername(username);
        BeanUtils.copyProperties(ptUser,ptUserDTO);
        List<String> roleList=new ArrayList<>();

        if(ptUser.getIsAdmin()!=null&&ptUser.getIsAdmin()==true){
            roleList.add("admin");
        }else{
            //if isAdmin false
            //step1 获取dutyUuid

            //step2 根据dutyUuid 获取roleUuid

            //根据roleUuid 获取permisson 关键字  构建roleList
            if(ptUser!=null&&ptUser.getDutyUuid()!=null){
                PtDuty ptDuty=ptDutyMapper.selectByPrimaryKey(ptUser.getDutyUuid());

                if(ptDuty!=null&&ptDuty.getRoleUuid()!=null){
                    roleList=ptRolesMenusMapper.getPermissionListByRoleUuid(ptDuty.getRoleUuid());
                }
            }
        }
        ptUserDTO.setRoles(roleList);
        List<GrantedAuthority> authorities=new ArrayList<>();
        if(roleList.size()>0){
            for (String permission : roleList){
                authorities.add(new GrantedAuthority() {
                    @Override
                    public String getAuthority() {
                        return "ROLE_"+permission;
                    }
                });
            }
        }
        ptUserDTO.setAuthorities(authorities);
        return ptUserDTO;
    }

	@Override
	public PtUser selectOneByUsername(String username){
		 return ptUserMapper.selectOneByUsername(username);
	}

}
