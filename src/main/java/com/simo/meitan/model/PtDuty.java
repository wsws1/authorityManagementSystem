package com.simo.meitan.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 岗位表（角色和单位的挂接）
    */
@Data
@NoArgsConstructor
public class PtDuty {
    /**
    * 岗位ID
    */
    private String dutyid;

    /**
    * 岗位名称
    */
    private String name;

    /**
    * 组织ID
    */
    private String organUuid;

    /**
     * 组织名称
     */
    private String organName;

    /**
    * 角色ID
    */
    private String roleUuid;

    /**
     * 角色名称
     */
    private String roleName;
}