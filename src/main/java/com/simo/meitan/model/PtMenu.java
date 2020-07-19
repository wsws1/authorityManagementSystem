package com.simo.meitan.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 系统菜单
    */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PtMenu {
    /**
    * ID
    */
    private String menuUuid;

    /**
    * 上级菜单ID
    */
    private String parentUuid;

    /**
    * 子菜单数目
    */
    private Integer subCount;

    /**
    * 菜单类型
    */
    private Integer type;

    /**
    * 菜单标题
    */
    private String title;

    /**
    * 组件名称
    */
    private String name;

    /**
    * 组件
    */
    private String component;

    /**
    * 排序
    */
    private Integer menuSort;

    /**
    * 图标
    */
    private String icon;

    /**
    * 链接地址
    */
    private String path;

    /**
    * 是否外链
    */
    private Boolean iFrame;

    /**
    * 缓存
    */
    private Boolean cache;

    /**
    * 隐藏
    */
    private Boolean hidden;

    /**
    * 权限
    */
    private String permission;

    /**
    * 创建者
    */
    private String createBy;

    /**
    * 更新者
    */
    private String updateBy;

    /**
    * 创建日期
    */
    private LocalDateTime createTime;

    /**
    * 更新时间
    */
    private LocalDateTime updateTime;

    List<PtMenu> children;
    private MenuMeta meta;
}