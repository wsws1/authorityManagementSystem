package com.simo.meitan.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class MenuMetaVO  {

    private String title;

    private String icon;

    private Boolean noCache;
}