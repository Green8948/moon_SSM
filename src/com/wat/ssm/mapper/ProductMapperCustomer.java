package com.wat.ssm.mapper;

import java.util.List;

import com.wat.ssm.po.Product;

public interface ProductMapperCustomer {
       public   List<Product>    findProductByPage(int  index);
       public   List<Product>    findAll();
}
