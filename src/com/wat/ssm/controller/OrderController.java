package com.wat.ssm.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wat.ssm.po.Order;
import com.wat.ssm.service.OrderService;

@Controller
public class OrderController {
	   @Autowired
	   OrderService    orderService;
	   @RequestMapping("/queryOrder")
	   public ModelAndView handleRequest(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
		   System.out.println("good luck");
		       int   totalPage=getTotalPage();  //获取总共的页数
			   int  page=1;
		       int  index=(page-1)*5;
		       java.util.List<Order>    list=orderService.findOrderByPage(index);
		    	System.out.println("list.size()="+list.size());
		      
		     //创建modelAndView准备填充数据，设置视图
				ModelAndView    modelAndView=new   ModelAndView();
				//填充数据
				modelAndView.addObject("orderList",list);
				modelAndView.addObject("page", page);   
				modelAndView.addObject("totalPage", totalPage);   //给jsp传参数 
				//设置视图
				modelAndView.setViewName("/order/orderAll");   //
				return modelAndView;
	   } 
	   public   int    getTotalPage(){
	        int   num=orderService.findAll();   //获取总共的行数
	        int   totalPage=0;
	        if(num%5==0){
	        	 totalPage=num/5;
	        }else{
	        	 totalPage=num/5+1;
	        }
	        return totalPage;
  }
	   @RequestMapping("/myOrder0")
	   public    String    productAdd1(){
		      return  "/order/MyOrder";     //是跳转到WEB-INF/productAdd.jsp
	   }

}
