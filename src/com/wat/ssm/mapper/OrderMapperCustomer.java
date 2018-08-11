package com.wat.ssm.mapper;

import java.util.List;

import com.wat.ssm.po.Order;



public interface OrderMapperCustomer {
       public   List<Order>    findOrderByPage(int  index);
       public   List<Order>    findAll();
}
