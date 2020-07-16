package com.simo.meitan.model;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户
 */
@Data
@NoArgsConstructor
public class PtUser {
    private String userUuid;

    private String id;

    /**
     * 登录名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    private String email;

    private String mobile;

    private Short enabled;

    private Short accountNonExpired;

    private Short credentialsNonExpired;

    private Short accountNonLocked;

    /**
     * 机构ID
     */
    private String organUuid;

    /**
     * 姓名
     */
    private String niceName;

    private Boolean isAdmin;

    /**
     * 1
     */
    private Short maximumsessions;

    /**
     * 注册日期
     */
    private LocalDateTime registerdate;

    /**
     * 最近登陆时间
     */
    private LocalDateTime lastlogintime;

    /**
     * 密保问题
     */
    private String pwdque;

    /**
     * 密保答案
     */
    private String pwdans;

    /**
     * 备注
     */
    private String remark;

    /**
     * 部门ID
     */
    private String depid;

    /**
     * 是否删除
     */
    private Boolean status;

    /**
     * 操作时间
     */
    private LocalDateTime modtime;

    /**
     * 操作人ID
     */
    private String modifierid;

    /**
     * 是否阳光用户（0否1是）
     */
    private Boolean isSum;

    /**
     * 岗位Id
     */
    private String dutyUuid;
}