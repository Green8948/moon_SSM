package com.wat.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wat.ssm.mapper.ProductMapper;
import com.wat.ssm.mapper.ProductMapperCustomer;
import com.wat.ssm.mapper.UploadfileMapper;
import com.wat.ssm.po.Product;
import com.wat.ssm.po.ProductExample;
import com.wat.ssm.po.Uploadfile;
import com.wat.ssm.po.UploadfileExample;
import com.wat.ssm.service.ProductService;

public class ProductServiceImpl<Example>  implements    ProductService {
	@Autowired
    ProductMapperCustomer     productMapperCustomer;
	@Autowired
	UploadfileMapper          uploadfileMapper;
	@Autowired
    ProductMapper              productMapper;
	/*1.ProductExample example=new ProductExample();*/   
	public List<Product> findProductByPage(int index) {
			List<Product>    list=productMapperCustomer.findProductByPage(index);
			return list;
	}
	public   int              addProduct(Product product,Uploadfile  uploadFile){
		
	/* 2.  example.createCriteria().andBasepriceEqualTo(product.getBaseprice());
		   example.createCriteria().andBasepriceEqualTo(product.getBaseprice()).andBasepriceIn(product.getBaseprice());
		   List<Product>    list=   productMapper.selectByExample(example);
		*/
		
		   uploadfileMapper.insert(uploadFile); //
		   
		   String  path=uploadFile.getPath();//获取图片名称
		   
		   
		   //根据图片名称获取id
		    UploadfileExample   ufe=new  UploadfileExample();
	        UploadfileExample.Criteria    ctt= ufe.createCriteria();
	        ctt.andPathEqualTo(uploadFile.getPath());                        //设置path
	        List<Uploadfile>     list=uploadfileMapper.selectByExample(ufe); //获取path对应的Uploadfile
	        int  id=0;
	        for(Uploadfile   Uploadfile1:   list){ 
	        	    id=Uploadfile1.getId();
	        }
	        
	        
	       System.out.println("ProductServiceImpl===="+id);
		   product.setUploadfileid(id);
		   int  num=productMapper.insert(product);       //添加商品
		   System.out.println("ProductServiceImpl===="+num);
	       return  num;
   }
	public Product findProductById(int id) {
		   Product   product=productMapper.selectByPrimaryKey(id);
		   return product;
	}
	@Override
	public int updateProduct(Product product, Uploadfile uploadfile) {
		   int   id=product.getId(); //
		   
		  
		  
		   //从数据库中查找uploadfileId
		   Product   product2=productMapper.selectByPrimaryKey(id);
		   int       uploadFileId=product2.getUploadfileid();
		
		   //修改图片表中的path,图片的id是没有的
		   uploadfile.setId(uploadFileId);
		   int   num=uploadfileMapper.updateByPrimaryKey(uploadfile);
		   
		   
		   //修改商品表
		   product.setUploadfileid(uploadFileId);
		   int   num2=productMapper.updateByPrimaryKey(product);
		   return num2;
	}
	@Override
	public int deleteProduct(int id) {
		   //获取图片的id,首先获取到商品，商品可以获取uploadFileId
		    Product   product2=productMapper.selectByPrimaryKey(id);
		    int       uploadfileId=product2.getUploadfileid();
		
		   //删除商品
		   int   num=productMapper.deleteByPrimaryKey(id);
		
		   //删除图片,要先获取图片的id
		   int   num2=uploadfileMapper.deleteByPrimaryKey(uploadfileId);
		   return num;
	}
	@Override
	public int findAll() {
			List<Product>    list=productMapperCustomer.findAll();
			int   num=list.size();
			return num;
	}
}
