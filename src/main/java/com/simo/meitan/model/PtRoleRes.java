package com.simo.meitan.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 角色资源配置
    */
@Data
@NoArgsConstructor
public class PtRoleRes {
    private String roleUuid;

    /**
    * 菜单目录id（树型结构层级编码）
    */
    private String resUuid;
}