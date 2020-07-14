package com.simo.meitan.service;

import com.github.pagehelper.PageInfo;
import com.simo.meitan.model.Book;
public interface BookService{


    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

	PageInfo<Book> selectAllByTitleLikeAndAuthorLikeAndCategory(
	        String likeTitle,
            String likeAuthor,
            Integer category,
            Integer page,
            Integer size,
            String sort);



}
