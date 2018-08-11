package com.wat.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wat.ssm.mapper.CategoryMapper;
import com.wat.ssm.mapper.CategoryMapperCustomer;
import com.wat.ssm.po.Category;
import com.wat.ssm.po.Order;
import com.wat.ssm.service.CategoryService;



public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryMapperCustomer     categoryMapperCustomer;

	@Autowired
	CategoryMapper              categoryMapper;
	
	
	@Override
	public int addCategory(Category category5) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Category findCategoryById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateCategory(Category category5) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCategory(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	
   
	@Override
	public int findAll() {
		List<Category>    list=categoryMapperCustomer.findAll();
				
		int   num=list.size();
		return num;
	}

	@Override
	public java.util.List<Category> findCategoryByPage(int index) {
		java.util.List<Category>    list=categoryMapperCustomer.findCategoryByPage(index);
		System.out.println("CategoryServiceImpl  list.size()="+list.size());
		return list;
	}



}
