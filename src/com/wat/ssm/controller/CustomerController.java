package com.wat.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.wat.ssm.po.Product;
import com.wat.ssm.po.Uploadfile;

@Controller
public class CustomerController {
@Autowired
@RequestMapping("/customerAdd1")
public    String    customerAdd1(){
	   System.out.println("customerAdd1()");
	      return  "/admin/CustomerRegister";     //ÊÇÌø×ªµ½WEB-INF/productAdd.jsp
}
@RequestMapping("/customerAdd2")
public    String     customerAdd2
(HttpServletRequest request,HttpServletResponse response){
	   System.out.println("customerAdd2()"); 
	     
	        
	        return  "/good/GoodBrowse";
	       
}
@RequestMapping("/customerLogin")
public    String     customerLogin
(HttpServletRequest request,HttpServletResponse response){
	   System.out.println("customerLogin()"); 
	     
	        
	        return  "/admin/CustomerLogin";
	       
}
@RequestMapping("/customerLogin2")
public    String     customerLogin2
(HttpServletRequest request,HttpServletResponse response){
	   System.out.println("customerLogin2()"); 
	     
	        
	        return  "/good/GoodBrowse";
	       
}

@RequestMapping("/goodBrowse0")
public    String     goodBrowse0
(HttpServletRequest request,HttpServletResponse response){
	   System.out.println("customerLogin2()"); 
	     
	        
	        return  "/good/MyShoppingCart";
	       
}

@RequestMapping("/CustomerOrder0")
public    String     CustomerOrder0
(HttpServletRequest request,HttpServletResponse response){
	   System.out.println("CustomerOrder0()"); 
	     
	        
	        return  "/good/CustomerOrder";
	       
}
}

