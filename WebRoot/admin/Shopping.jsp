<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Shopping.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <style type="text/css">
       
body {      
      background-color: pink; 
	 }
#myid1 {
	position: absolute;
	left: 400px; 
	top: 59px;
	z-index: 2;
	
}

#myid2 {
	position: absolute;
	left: 100px;
	top: 40px;
	z-index: 1;
	background-image: url(./images/9.bmp);
	background-repeat: no-repeat;
}
#myid3{
	position: absolute;
	left: 100px;
	top:120px;
	z-index: 2;
	background-repeat: no-repeat; 
}#m{
    position: absolute;
	left: 170px;
	top: 210px; 
	z-index: 2;
    background-attachment:fixed;
     background-color: pink;
}      
  #shop5{
   position: absolute;
	left: 130px;
	top: 60px; 
  
  }#shop0{
   position: absolute;
	left: 295px;
	top: 175px; 
  
  }
  </style>
   
  </head>
  
  <body>

            <img src="./images/shop.bmp" width="783px" height="575px" id="shop5"  />
            
            <marquee  id="shop0" scrollamount="" scrolldelay="300" width="300" height="30"
			loop="-1" direction="right" behavior="alternate">
			<img alt="" src=" ./images5/666.jpg"> 
			<img alt="" src=" ./images5/95.jpg"> 
			<img alt="" src=" ./images5/59.jpg"> 
			<img alt="" src=" ./images5/45.jpg"> 
			<img alt="" src=" ./images5/book9.jpg"> 
			<img alt="" src=" ./images5/5.jpg"> 
			<img alt="" src=" ./images5/0.gif"> 
		
		</marquee>
		    <table id="m" border="1" width="121" bgcolor="yellow">
		          
				         <tr height="42">
				                <td  >
				                      <a  href="${pageContext.request.contextPath }/customerLogin.action ">
				                      		
				                      		<img alt="" src="./images/M.png">
				                      </a>
				                 </td>
				         </tr>
				         <tr>
				             <td></td>
				         </tr>
				         <tr height="42">
				             <td  >
				                       <a  href="${pageContext.request.contextPath }/customerAdd1.action ">
				                            <img alt="" src="./images/W.png">
				                       </a>
			                     </td>
				          </tr>
				         <tr>
				              <td></td>
				         </tr>
				         <tr height="42">
				        
		                <td  >
		                			  <a  href="${pageContext.request.contextPath }/Login.action ">
				                      <img alt="" src="./images/Well.png">
		                      </a>
		                </td>
		         </tr>
		         
		   </table>
		  
   
         
         <form action="CustomerServletRegister" method="post" name="myform1">
		   <table  height="5">
       				<tr>
       				      <td width="555"></td>
       				      <td valign="bottom" height="5"><img alt="" src="./images/index_03.gif"> 
       				          <a  href="./myCart/index.jsp ">
								     	    我的购物车
								</a>
       				       </td> 
       			      <td valign="bottom"> <a   href="queryOrder.action"> 我的订单</a> </td>
       				      <td valign="bottom">欢迎</td>
       				      <td valign="bottom"><%=request.getSession().getAttribute("zhanghao")%>!</td>
       				      <td><button><img src="./images/ht_02_02.gif" /></button></td>
       				</tr>
       		</table>
       		
       		<table border="0" width="500" id="myid1">
				<tr height="30">
					<td  width="300" valign="bottom">
					    <input type="text" size="35" align="right"> 
					    <button href="https://hao.360.cn/?src=lm&ls=n3b2c32a798" >搜索</button>
					</td>
					<td align="left"  valign="top"  >
					    <a href="https://hao.360.cn/?src=lm&ls=n3b2c32a798" >高级搜索</a>
					</td>
				</tr>
				<tr>
				    <td valign="bottom">热搜商品：
				          <a href="https://hao.360.cn/?src=lm&ls=n3b2c32a798">软件</a>
				    </td>
					<td align="left" valign="top">
					      <a href="https://hao.360.cn/?src=lm&ls=n3b2c32a798">使用帮助</a>
					</td>

				</tr>
			</table>
		   
		    <table width="830" height="110"  id="myid2">
					<tr >
						<td width="300"></td>
					</tr>
			</table>
		<table  id="myid3" background="./images/12.png">
	 			<tr>
	 				<td width="80" ><a href="./admin/Shopping.jsp">首页</a></td>
	 				<td width="80" >
	 				     <a  href="./good/GoodBrowse.jsp ">新品上市</a> 
	 				</td>
	 				<td width="80" ><a  href="./good/GoodBrowse.jsp ">热销商品</a> </td>
	 				<td width="80" ><a  href="./good/GoodBrowse.jsp ">推荐商品</a></td>
	 				<td width="80" ><a  href="./good/GoodBrowse.jsp ">人气商品</a></td>
	 				<td width="200" ></td>
	 		        <td width="200"  ></td>
	 			</tr>
	 	</table>
       	</form>	
 			
  </body>
</html>
