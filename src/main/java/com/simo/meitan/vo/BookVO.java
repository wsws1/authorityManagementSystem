package com.simo.meitan.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
public class BookVO {
    private Integer bookId;
    private String title;
    private String author;
    private String publisher;
    private String language;
    private Integer category;
    private String categoryText;

    private String cover;
    private String path;
    private String originalName;
    private String fileName;
    private String unzipPath;
    private String rootFile;

    private List<ContentVO> contentsTree;
}
