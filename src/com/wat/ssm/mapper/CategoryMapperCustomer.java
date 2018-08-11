package com.wat.ssm.mapper;

import java.util.List;

import com.wat.ssm.po.Category;

public interface CategoryMapperCustomer {
    public   List<Category>    findCategoryByPage(int  index);
    public   List<Category>    findAll();
}
