package com.simo.meitan.mapper;
import java.util.List;

import com.simo.meitan.model.Category;

public interface CategoryMapper {
    int insert(Category record);

    int insertSelective(Category record);

    List<Category> selectByAll(Category category);

    List<Integer> selectCategory();

    List<Category> selectAll();

    List<Category> selectAllOrderByCategory();








}