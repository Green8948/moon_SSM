package com.wat.ssm.controller;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.wat.ssm.mapper.ProductMapper;
import com.wat.ssm.mapper.ProductMapperCustomer;
import com.wat.ssm.po.Product;
import com.wat.ssm.po.Uploadfile;
import com.wat.ssm.service.ProductService;
import com.wat.ssm.service.impl.ProductServiceImpl;

@Controller
public class   ProductController 
{
	   @Autowired
	   ProductService     productService;
	   @RequestMapping("/queryProduct")
	   public ModelAndView handleRequest(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
		       int   totalPage=getTotalPage();  //��ȡ�ܹ���ҳ��
			   int  page=1;
		       int  index=(page-1)*5;
		       List<Product>    list=productService.findProductByPage(index);
		       System.out.println("list.size()="+list.size());
		      
		     //����modelAndView׼��������ݣ�������ͼ
				ModelAndView    modelAndView=new   ModelAndView();
				//�������
				modelAndView.addObject("productList",list);
				modelAndView.addObject("page", page);   
				modelAndView.addObject("totalPage", totalPage);   //��jsp������ 
				//������ͼ
				modelAndView.setViewName("/product/productAll");   //
				return modelAndView;
	   } 
	   public   int    getTotalPage(){
		        int   num=productService.findAll();   //��ȡ�ܹ�������
		        int   totalPage=0;
		        if(num%5==0){
		        	 totalPage=num/5;
		        }else{
		        	 totalPage=num/5+1;
		        }
		        return totalPage;
	   }
	   @RequestMapping("/productAction_findByPageLast")
	   public ModelAndView handleRequest2(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
		       int   totalPage=getTotalPage();  //��ȡ�ܹ���ҳ��
			   int  page=totalPage;
		       int  index=(page-1)*5;
		       List<Product>    list=productService.findProductByPage(index);
		       System.out.println("list.size()="+list.size());
		      
		     //����modelAndView׼��������ݣ�������ͼ
				ModelAndView    modelAndView=new   ModelAndView();
				//�������
				modelAndView.addObject("productList",list);
				modelAndView.addObject("page", page);   
				modelAndView.addObject("totalPage", totalPage);   //��jsp������ 
				//������ͼ
				modelAndView.setViewName("/product/productAll");   //
				return modelAndView;
	   } 
	   @RequestMapping("/productAction_findByPageXia")
	   public ModelAndView productAction_findByPageXia(@RequestParam(value="page",required=true) Integer page )throws Exception {
		       System.out.println("page="+page);
		       
		       int   totalPage=getTotalPage();  //��ȡ�ܹ���ҳ��
		       
		       if(page>=totalPage){
		    	      page=page;
		       }else{
		    	      page=page+1;
		       }
		       int  index=(page-1)*5;
		       List<Product>    list=productService.findProductByPage(index);
		       System.out.println("list.size()="+list.size());
		      
		     //����modelAndView׼��������ݣ�������ͼ
				ModelAndView    modelAndView=new   ModelAndView();
				//�������
				modelAndView.addObject("productList",list);
				modelAndView.addObject("page", page);   
				modelAndView.addObject("totalPage", totalPage);   //��jsp������ 
				//������ͼ
				modelAndView.setViewName("/product/productAll");   //
				return modelAndView;
	   } 
	   @RequestMapping("/productAction_findByPageShang")
	   public ModelAndView productAction_findByPageShang(@RequestParam(value="page",required=true) Integer page )throws Exception {
		       System.out.println("page="+page);
		       
		       int   totalPage=getTotalPage();  //��ȡ�ܹ���ҳ��
		       
		       if(page<=1){
		    	      page=page;
		       }else{
		    	      page=page-1;
		       }
		       int  index=(page-1)*5;
		       List<Product>    list=productService.findProductByPage(index);
		       System.out.println("list.size()="+list.size());
		      
		     //����modelAndView׼��������ݣ�������ͼ
				ModelAndView    modelAndView=new   ModelAndView();
				//�������
				modelAndView.addObject("productList",list);
				modelAndView.addObject("page", page);   
				modelAndView.addObject("totalPage", totalPage);   //��jsp������ 
				//������ͼ
				modelAndView.setViewName("/product/productAll");   //
				return modelAndView;
	   } 
	   @RequestMapping("/productAdd1")
	   public    String    productAdd1(){
		   System.out.println("productAdd1()");
		      return  "/product/productAdd";     //����ת��WEB-INF/productAdd.jsp
	   }
	   @RequestMapping("/productAdd2")
	   public    String     productAdd2(HttpServletRequest request,
			   HttpServletResponse response,Product  product,Uploadfile    uploadFile,
			   MultipartFile   product_pic){
		   System.out.println("productAdd2()"); 
		      String    path=request.getContextPath();
		        System.out.println("path="+path);
		        
		        //��ȡͼƬ��ԭʼ����
		        String   originalFileName=product_pic.getOriginalFilename();
		        System.out.println("originalFileName="+originalFileName);
		        
		        
		        //����ͼƬΨһ��ʶ
		        int    index=originalFileName.lastIndexOf(".");  //��ȡ.���±�
		        String houzuiming=originalFileName.substring(index);//��ȡ.jpg,.png,.bmp;
		        UUID  str=UUID.randomUUID();   //����Ψһ��ʶ��UUID��
		        String newFileName =str  +houzuiming;
		        uploadFile.setPath(newFileName);
		        
		        
		        //����ͼƬ����Ŀ��   
		         //�洢ͼƬ������·��
				String pic_path ="E:\\forever\\seniorProject\\moon_SSM\\WebRoot\\pic\\";
//		        String pic_path=".\\WebRoot\\pic\\";
		        
				File newFile = new File(pic_path+newFileName);  //����ͼƬ
				
				try {
					//���ڴ��е�����д�����
					product_pic.transferTo(newFile);       //����ͼƬ����д������    
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
		        
		        //��ȡ��Ʒ�����ƣ���𣬲ɹ��۸��г��۸����ۼ۸��Ƿ��Ƽ����Ա�˵��
		        System.out.println(product.getName()+"   "+product.getCategoryid()+"   "+product.getBaseprice()+"   "+product.getMarketprice()+"    "+product.getSellprice()+"    "+product.getCommend()+"   "+product.getDescription()+"   "+product.getSexrequest());
		        
		        productService.addProduct(product, uploadFile);
		        
		        return  "/product/updateSuccess";
		       
	   }
	   //������get����Ҳ����post����
	   @RequestMapping(value="/productAction_update",method={RequestMethod.POST,RequestMethod.GET})
	   public String productAction_update(Model model,@RequestParam(value="id",required=true) Integer id )throws Exception {
		        System.out.println("id="+id);
		        Product   product=productService.findProductById(id);
		        
		        model.addAttribute("product", product);
		        
		        return "/product/productUpdate";
	   }
	   @RequestMapping("/productUpdate2")
	   public     String    productUpdate2(HttpServletRequest request,HttpServletResponse response,Product  product,Uploadfile    uploadFile,MultipartFile   product_pic){
		        System.out.println(1234);
		   
		        String    path=request.getContextPath();
		        System.out.println("path="+path);
		        
		        //��ȡͼƬ��ԭʼ����
		        String   originalFileName=product_pic.getOriginalFilename();
		        System.out.println("originalFileName="+originalFileName);
		        
		        
		        //����ͼƬΨһ��ʶ
		        int    index=originalFileName.lastIndexOf(".");  //��ȡ.���±�
		        String houzuiming=originalFileName.substring(index);//��ȡ.jpg,.png,.bmp;
		        UUID  str=UUID.randomUUID();   //����Ψһ��ʶ��UUID��
		        String newFileName =str  +houzuiming;
		        
		        uploadFile.setPath(newFileName);
		        //����ͼƬ����Ŀ��
		         //�洢ͼƬ������·��
		
				String pic_path ="E:\\forever\\seniorProject\\moon_SSM\\WebRoot\\pic\\";
		        
				File newFile = new File(pic_path+newFileName);  //����ͼƬ
				try {
					//���ڴ��е�����д�����
					product_pic.transferTo(newFile);       //����ͼƬ����д������    
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
		        
		        //��ȡ��Ʒ�����ƣ���𣬲ɹ��۸��г��۸����ۼ۸��Ƿ��Ƽ����Ա�˵��
		        System.out.println(product.getId()+"    "+product.getName()+"   "+product.getCategoryid()+"   "+product.getBaseprice()+"   "+product.getMarketprice()+"    "+product.getSellprice()+"    "+product.getCommend()+"   "+product.getDescription()+"   "+product.getSexrequest());
		        int   num=productService.updateProduct(product, uploadFile);
		        
		        return  "/product/updateSuccess";
	   }
	   @RequestMapping("/productAction_delete")
	   public String productAction_delete(Model model,@RequestParam(value="id",required=true) Integer id)throws Exception {
//		        System.out.println("id="+id);
		        int  num=productService.deleteProduct(id);
		        return "/product/deleteSuccess";
	   }
}








