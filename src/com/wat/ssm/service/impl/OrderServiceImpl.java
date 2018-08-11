package com.wat.ssm.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wat.ssm.mapper.OrderMapper;
import com.wat.ssm.mapper.OrderMapperCustomer;
import com.wat.ssm.po.Order;
import com.wat.ssm.service.OrderService;

public class OrderServiceImpl<Example> implements OrderService{
	@Autowired
    OrderMapperCustomer     orderMapperCustomer;

	@Autowired
    OrderMapper              orderMapper;


	@Override
	public int addOrder(Order order5) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Order findOrderById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateOrder(Order order5) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOrder(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findAll() {
		List<Order>    list=orderMapperCustomer.findAll();
				
		int   num=list.size();
		return num;
	}

	@Override
	public java.util.List<Order> findOrderByPage(int index) {
		java.util.List<Order>    list=orderMapperCustomer.findOrderByPage(index);
		System.out.println("OrderServiceImpl  list.size()="+list.size());
		return list;
	}







}
