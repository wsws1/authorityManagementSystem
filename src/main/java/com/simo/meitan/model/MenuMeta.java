package com.simo.meitan.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MenuMeta  {

    private String title;

    private String icon;

    private Boolean noCache;
}