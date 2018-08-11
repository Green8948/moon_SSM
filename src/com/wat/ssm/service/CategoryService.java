package com.wat.ssm.service;

import java.util.List;

import com.wat.ssm.po.Category;

public interface CategoryService {
	 public   List<Category>    findCategoryByPage(int index);
     public   int              addCategory(Category category5);
     public   Category          findCategoryById(int  id);
     public   int              updateCategory(Category category5);
     public   int              deleteCategory(int  id);
     public   int              findAll();
}
