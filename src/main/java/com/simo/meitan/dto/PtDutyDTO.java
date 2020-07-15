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
     * 角色ID
     */
    private String roleUuid;
}