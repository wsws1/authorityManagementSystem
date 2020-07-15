package com.simo.meitan.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PtResDTO {
    private String resUuid;

    private String resName;

    private String resUrl;

    private String resType;

    private String parentUuid;
}
