package com.simo.meitan.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PtRoleDTO {

    private String roleUuid;

    private String roleId;

    private String roleName;

    private List<String> menuList;
}
