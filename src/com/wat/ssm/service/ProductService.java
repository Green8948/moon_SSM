package com.wat.ssm.service;
import java.util.List;

import com.wat.ssm.po.Product;
import com.wat.ssm.po.Uploadfile;
public interface ProductService {
       public   List<Product>    findProductByPage(int index);
       public   int              addProduct(Product product,Uploadfile  uploadFile);
       public   Product          findProductById(int  id);
       public   int              updateProduct(Product product,Uploadfile  uploadfile);
       public   int              deleteProduct(int  id);
       public   int              findAll();
}
