package com.simo.meitan.mapper;
import org.apache.ibatis.annotations.Param;

import com.simo.meitan.model.AdminUser;

public interface AdminUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminUser record);

    int insertSelective(AdminUser record);

    AdminUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdminUser record);

    int updateByPrimaryKey(AdminUser record);

    AdminUser selectOneByUsername(@Param("username")String username);




}