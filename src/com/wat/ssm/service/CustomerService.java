package com.wat.ssm.service;

import java.util.List;

import com.wat.ssm.po.Customer;

public interface CustomerService {
	 public   List<Customer>    findCustomerByPage(int index);
     public   int              addCustomer(Customer customer5);
     public   Customer          findCustomerById(int  id);
     public   int              updateCustomer(Customer customer5);
     public   int              deleteCustomer(int  id);
     public   int              findAll();
}
