package com.wat.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@Autowired  
	@RequestMapping("/Login")
	public    String    adminAdd1(){
		   System.out.println("adminAdd1()");
          return  "/admin/Login";   //ÊÇÌø×ªµ½WEB-INF/productAdd.jsp
		      
	}
	@RequestMapping("/AdminLogin2")
	public    String     customerAdd2
	(HttpServletRequest request,HttpServletResponse response){
		   System.out.println("customerAdd2()"); 
		     
		        
		        return  "/product/productAll";
		       
	}
}
