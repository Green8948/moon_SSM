package com.wat.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wat.ssm.po.Category;
import com.wat.ssm.service.CategoryService;
@Controller
public class CategoryController {
	   @Autowired
	   CategoryService    categoryService;
	   @RequestMapping("/queryCategory")
	   public ModelAndView handleRequest(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
		   System.out.println("good luck");
		       int   totalPage=getTotalPage();  //获取总共的页数
			   int  page=1;
		       int  index=(page-1)*5;
		       java.util.List<Category>    list=categoryService.findCategoryByPage(index);
		    	System.out.println("CategoryController_list.size()="+list.size());
		      
		     //创建modelAndView准备填充数据，设置视图
				ModelAndView    modelAndView=new   ModelAndView();
				//填充数据
				modelAndView.addObject("CategoryList",list);
				modelAndView.addObject("page", page);   
				modelAndView.addObject("totalPage", totalPage);   //给jsp传参数 
				//设置视图
				modelAndView.setViewName("/order/CategoriesAll");   //
				return modelAndView;
	   } 
	   public   int    getTotalPage(){
	        int   num=categoryService.findAll();   //获取总共的行数
	        int   totalPage=0;
	        if(num%5==0){
	        	 totalPage=num/5;
	        }else{
	        	 totalPage=num/5+1;
	        }
	        return totalPage;
}
	   @RequestMapping("/categoryAdd0")
	   public    String    productAdd1(){
		      return  "/order/CategoryAdd";     //是跳转到WEB-INF/productAdd.jsp
	   }
	  // @RequestMapping("/categoryAdd5")
	  /* public    String     productAdd2(HttpServletRequest request,HttpServletResponse response,Product  product,Uploadfile    uploadFile,MultipartFile   product_pic){
		        String    path=request.getContextPath();
		        System.out.println("path="+path);
		        
		        //获取图片的原始名称
		        String   originalFileName=product_pic.getOriginalFilename();
		        System.out.println("originalFileName="+originalFileName);
		        
		        
		        //生成图片唯一标识
		        int    index=originalFileName.lastIndexOf(".");  //获取.的下标
		        String houzuiming=originalFileName.substring(index);//获取.jpg,.png,.bmp;
		        UUID  str=UUID.randomUUID();   //生成唯一标识的UUID。
		        String newFileName =str  +houzuiming;
		        uploadFile.setPath(newFileName);
		        
		        
		        //保存图片到项目中
		         //存储图片的物理路径
				String pic_path ="D:\\myGirl\\moonWorkspaces\\Test3Springmvc4SSMSHOP\\WebRoot\\pic\\";
//		        String pic_path=".\\WebRoot\\pic\\";
		        
				File newFile = new File(pic_path+newFileName);  //创建图片
				
				try {
					//将内存中的数据写入磁盘
					product_pic.transferTo(newFile);       //创建图片并且写入数据    
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
		        
		        //获取商品：名称，类别，采购价格，市场价格，销售价格，是否推荐，性别，说明
		        System.out.println(product.getName()+"   "+product.getCategoryid()+"   "+product.getBaseprice()+"   "+product.getMarketprice()+"    "+product.getSellprice()+"    "+product.getCommend()+"   "+product.getDescription()+"   "+product.getSexrequest());
		        
		        productService.addProduct(product, uploadFile);
		        
		        return  "/updateSuccess";
		       
	   }	   
	   */
	   
	   
	   
}
