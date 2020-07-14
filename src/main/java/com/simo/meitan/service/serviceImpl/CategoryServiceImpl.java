package com.simo.meitan.service.serviceImpl;
import java.util.List;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.simo.meitan.mapper.CategoryMapper;
import com.simo.meitan.model.Category;
import com.simo.meitan.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public int insert(Category record) {
        return categoryMapper.insert(record);
    }

    @Override
    public int insertSelective(Category record) {
        return categoryMapper.insertSelective(record);
    }

	@Override
	public List<Category> selectByAll(Category category){
		 return categoryMapper.selectByAll(category);
	}

	@Override
	public List<Integer> selectCategory(){
		 return categoryMapper.selectCategory();
	}

	@Override
	public List<Category> selectAll(){
		 return categoryMapper.selectAll();
	}

	@Override
	public List<Category> selectAllOrderByCategory(){
		 return categoryMapper.selectAllOrderByCategory();
	}













}
