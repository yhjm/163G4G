<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'result.jsp' starting page</title>
    
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
   用户名:
	<s:property value="user.uname" />
	<br /> 
	密码:
	<s:property value="user.upwd" />
	<br /> 
	性别:
	<s:property value="user.sex" />
	<br /> 
	住址:
	<s:property value="user.address" />
	<br /> 
	年龄:
	<s:property value="user.age" />
	<br />
	<br />
	<br />
	<br />
	登录时间:<s:property value="date" />
  </body>
</html>
