<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <form action="user" method="post">
用户名:<input type="text" name="user.uname"/>
<br/>
密&nbsp&nbsp&nbsp&nbsp码:<input type="password" name="user.upwd"/>
<br/>
年&nbsp&nbsp&nbsp&nbsp龄:<input type="text" name="user.age"/>
<br/>
性&nbsp&nbsp&nbsp&nbsp别:<input type="radio" value="男" name="user.sex"/>男
	<input type="radio" value="女" name="user.sex"/>女
<br/>
住&nbsp&nbsp&nbsp&nbsp址:<input type="text" name="user.address"/> 
<br/>
<input type="submit" value="登录"/>
</form>
  </body>
</html>
