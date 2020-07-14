package com.simo.meitan.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 组织机构
 */
@Data
@NoArgsConstructor
public class PtOrgan {
    private String organUuid;

    private String organCode;

    private String organName;

    private String organType;

    private Boolean inUse;

    private String parentUuid;

    /**
     * 是否删除
     */
    private String status;

    /**
     * 创建人ID
     */
    private String modifierid;

    /**
     * 创建时间
     */
    private LocalDateTime modtime;

    /**
     * 描述
     */
    private String description;

    /**
     * 资金账户code
     */
    private String accountCode;

    private String shortname;

    /**
     * 是否为父组织
     */
    private Boolean isParent;

    List<PtOrgan> children;

}