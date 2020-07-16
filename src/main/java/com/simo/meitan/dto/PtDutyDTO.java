package com.simo.meitan.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PtDutyDTO {
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