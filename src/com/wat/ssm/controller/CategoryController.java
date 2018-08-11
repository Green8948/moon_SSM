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
		       int   totalPage=getTotalPage();  //��ȡ�ܹ���ҳ��
			   int  page=1;
		       int  index=(page-1)*5;
		       java.util.List<Category>    list=categoryService.findCategoryByPage(index);
		    	System.out.println("CategoryController_list.size()="+list.size());
		      
		     //����modelAndView׼��������ݣ�������ͼ
				ModelAndView    modelAndView=new   ModelAndView();
				//�������
				modelAndView.addObject("CategoryList",list);
				modelAndView.addObject("page", page);   
				modelAndView.addObject("totalPage", totalPage);   //��jsp������ 
				//������ͼ
				modelAndView.setViewName("/order/CategoriesAll");   //
				return modelAndView;
	   } 
	   public   int    getTotalPage(){
	        int   num=categoryService.findAll();   //��ȡ�ܹ�������
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
		      return  "/order/CategoryAdd";     //����ת��WEB-INF/productAdd.jsp
	   }
	  // @RequestMapping("/categoryAdd5")
	  /* public    String     productAdd2(HttpServletRequest request,HttpServletResponse response,Product  product,Uploadfile    uploadFile,MultipartFile   product_pic){
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
				String pic_path ="D:\\myGirl\\moonWorkspaces\\Test3Springmvc4SSMSHOP\\WebRoot\\pic\\";
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
		        
		        return  "/updateSuccess";
		       
	   }	   
	   */
	   
	   
	   
}
