package com.simo.meitan.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 角色
    */
@Data
@NoArgsConstructor
public class PtRole {
    private String roleUuid;

    private String roleId;

    private String roleName;
}