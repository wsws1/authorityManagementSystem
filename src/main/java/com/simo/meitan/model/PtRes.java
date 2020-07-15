package com.simo.meitan.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
    * 资源表
    */
@Data
@NoArgsConstructor
public class PtRes {
    private String resUuid;

    /**
    * 菜单类别id
    */
    private String id;

    private String resId;

    private String resName;

    private String resUrl;

    private String resType;

    private String parentUuid;

    private String order;

    private List<PtRes> children;
}