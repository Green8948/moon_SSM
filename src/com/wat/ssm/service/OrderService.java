package com.wat.ssm.service;

import java.util.List;

import com.wat.ssm.po.Order;

public interface OrderService {
     
	   public   List<Order>    findOrderByPage(int index);
       public   int              addOrder(Order order5);
       public   Order          findOrderById(int  id);
       public   int              updateOrder(Order order5);
       public   int              deleteOrder(int  id);
       public   int              findAll();
}
