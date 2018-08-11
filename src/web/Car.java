package web;
import java.util.*;
import java.awt.RenderingHints.Key;
import java.io.*;

import javax.enterprise.inject.New;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class Car {  
	@RequestMapping("/Add2")
	 public ModelAndView handleRequest(HttpServletRequest arg0,
				HttpServletResponse arg1) throws Exception {
			     
			    System.out.println("进入了handleRequest方法");
			    List<Car>    list=new  ArrayList<Car>();
			    
			    Car     car5=new  Car();
			    car5.setItem(item);
			    car5.setMount(mount);
			    car5.setUnit(unit);
			    car5.setUserID(userID);
			    list.add(car5);
			
			    
			    //创建modelAndview对象准备填充数据，设置视图
			    ModelAndView     mav=new   ModelAndView();
			    mav.addObject("list",list);     //传数据给jsp
			    mav.setViewName("./myCart/add");//跳转到jsp
		     	return mav;
		}
	 
 //Hashtable list=new Hashtable();  //散列表，商品列表
 Hashtable list= new Hashtable();
 
 String item="Welcome";
 String mount="0";  //商品数量
 String unit=null;  //商品单位
 String userID;  //用户
 public void Car(){
 }
 public void setItem(String item) {
  this.item = item;
 }
 public void setMount(String mount) {
  this.mount = mount;
 }
 public void setUnit(String unit) {
  this.unit = unit;
 }
 public String getUserID() {
  return userID;
 }
 public void setUserID(String userID) {
  this.userID = userID;
 }

public Hashtable list_h() {
  return (Hashtable) list;
 }
 public void  dele_h(String s) {
  list.remove(s);
 }
 public void add_h(){

	 
	 
 list.put(item, item);
  System.out.println("item");
 
  list.put(mount, mount);
  System.out.println("mount");
 
  list.put(unit, unit);
  System.out.println("class Car");
 

	 
/*	 // List<Car>    list5=new  ArrayList<Car>();
  
  Car     car=new  Car();
  car.setItem(item);
  car.setMount(mount);
  car.setUnit(unit);
  car.setUserID(userID);
  list.put(car, car);
*/
  
  
  
  
 }
 
 
 
 
 
 
 
 
 
 
}
