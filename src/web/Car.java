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
			     
			    System.out.println("������handleRequest����");
			    List<Car>    list=new  ArrayList<Car>();
			    
			    Car     car5=new  Car();
			    car5.setItem(item);
			    car5.setMount(mount);
			    car5.setUnit(unit);
			    car5.setUserID(userID);
			    list.add(car5);
			
			    
			    //����modelAndview����׼��������ݣ�������ͼ
			    ModelAndView     mav=new   ModelAndView();
			    mav.addObject("list",list);     //�����ݸ�jsp
			    mav.setViewName("./myCart/add");//��ת��jsp
		     	return mav;
		}
	 
 //Hashtable list=new Hashtable();  //ɢ�б���Ʒ�б�
 Hashtable list= new Hashtable();
 
 String item="Welcome";
 String mount="0";  //��Ʒ����
 String unit=null;  //��Ʒ��λ
 String userID;  //�û�
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
