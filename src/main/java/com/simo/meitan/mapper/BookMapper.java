package com.simo.meitan.mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.simo.meitan.model.Book;

public interface BookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<Book> selectAllByTitleLikeAndAuthorLikeAndCategory(@Param("likeTitle")String likeTitle,@Param("likeAuthor")String likeAuthor,@Param("category")Integer category);

    List<Book> selectAllByTitleLikeAndAuthorLikeAndCategoryOrderByIdDesc(@Param("likeTitle")String likeTitle,@Param("likeAuthor")String likeAuthor,@Param("category")Integer category);


    List<Book> selectAllByTitleLikeAndAuthorLikeAndCategoryOrderById(@Param("likeTitle")String likeTitle,@Param("likeAuthor")String likeAuthor,@Param("category")Integer category);




}