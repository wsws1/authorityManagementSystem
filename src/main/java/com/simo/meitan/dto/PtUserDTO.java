package com.simo.meitan.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PtUserDTO {
    private String userUuid;
    /**
     * 机构ID
     */
    private String organUuid;

    private String organName;
    /**
     * 岗位id
     */
    private String dutyUuid;

    /**
     * 岗位名称
     */
    private String dutyName;
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



    /**
     * 姓名
     */
    private String niceName;

    private Boolean isAdmin;

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
}
