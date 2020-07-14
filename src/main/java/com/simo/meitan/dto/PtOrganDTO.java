package com.simo.meitan.dto;

import com.simo.meitan.model.PtOrgan;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class PtOrganDTO {
    private String organUuid;

    private String organCode;

    private String organName;

    private String parentUuid;

    private Boolean inUse;

    /**
     * 描述
     */
    private String description;

    /**
     * 资金账户code
     */
    private String accountCode;

    private String shortname;

}
