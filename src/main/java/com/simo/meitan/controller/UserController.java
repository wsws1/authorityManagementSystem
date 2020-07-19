package com.simo.meitan.controller;

import com.simo.meitan.vo.UserVO;
import com.simo.meitan.model.AdminUser;
import com.simo.meitan.service.AdminUserService;
import com.simo.meitan.utils.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    AdminUserService  userService;
    @GetMapping("/info")
    public RestResponse userInfo(){

        String curUserName=(String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AdminUser adminUser=userService.selectOneByUsername(curUserName);
        UserVO userVO=new UserVO();
        userVO.setId(adminUser.getId());
        userVO.setAvatar(adminUser.getAvatar());
        userVO.setNickname(adminUser.getNickname());
        List<String> roleList=new ArrayList<>();
        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(adminUser.getRole());
        for(GrantedAuthority grantedAuthority :authorities){
            roleList.add(grantedAuthority.getAuthority());
        }
        userVO.setRoles(roleList);
        userVO.setUsername(adminUser.getUsername());
        return RestResponse.succuess(userVO);
    }


    @PostMapping("/logout")
    public RestResponse logout(){
        return RestResponse.succuess();
    }
}
