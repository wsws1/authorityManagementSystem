package com.simo.meitan.service;
import java.util.List;

import com.simo.meitan.model.Category;
public interface CategoryService{


    int insert(Category record);

    int insertSelective(Category record);



	List<Category> selectByAll(Category category);



	List<Integer> selectCategory();



	List<Category> selectAll();



	List<Category> selectAllOrderByCategory();





}
