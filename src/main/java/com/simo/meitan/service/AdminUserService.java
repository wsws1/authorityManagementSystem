package com.simo.meitan.service;

import com.simo.meitan.model.AdminUser;
public interface AdminUserService{


    int deleteByPrimaryKey(Integer id);

    int insert(AdminUser record);

    int insertSelective(AdminUser record);

    AdminUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdminUser record);

    int updateByPrimaryKey(AdminUser record);



	AdminUser selectOneByUsername(String username);






}
