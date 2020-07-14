package com.simo.meitan.service.serviceImpl;
import java.util.List;

import com.simo.meitan.dto.UserDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.simo.meitan.mapper.AdminUserMapper;
import com.simo.meitan.model.AdminUser;
import com.simo.meitan.service.AdminUserService;
@Service("AdminUserServiceImpl")
public class AdminUserServiceImpl implements AdminUserService , UserDetailsService {

    @Resource
    private AdminUserMapper adminUserMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return adminUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(AdminUser record) {
        return adminUserMapper.insert(record);
    }

    @Override
    public int insertSelective(AdminUser record) {
        return adminUserMapper.insertSelective(record);
    }

    @Override
    public AdminUser selectByPrimaryKey(Integer id) {
        return adminUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(AdminUser record) {
        return adminUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AdminUser record) {
        return adminUserMapper.updateByPrimaryKey(record);
    }

	@Override
	public AdminUser selectOneByUsername(String username){
		 return adminUserMapper.selectOneByUsername(username);
	}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO userDTO=new UserDTO();
        AdminUser adminUser=selectOneByUsername(username);
        userDTO.setUsername(adminUser.getUsername());
        userDTO.setPassword(adminUser.getPassword());
        List<GrantedAuthority> authorities= AuthorityUtils.commaSeparatedStringToAuthorityList((adminUser.getRole()));
        userDTO.setAuthorities(authorities);
        return  userDTO;
    }
}
