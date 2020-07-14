package com.simo.meitan.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ContentVO {
    //树形目录的标题
    private String label;
    //目录文件相对地址
    //admin-upload-ebook/unzip/023de860a20029f7045d4b28e4371afb/titlepage.xhtml
    private  String text;

    private Integer pid;

    //图书文件名
    private String fileName;

    List<ContentVO> children;
}
