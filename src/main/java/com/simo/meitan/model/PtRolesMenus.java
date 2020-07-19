package com.simo.meitan.model;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PtRolesMenus {

    private String roleUuid;

    private String menuUuid;
    @org.springframework.beans.factory.annotation.Autowired
    private com.simo.meitan.mapper.PtRolesMenusMapper ptRolesMenusMapper;
}