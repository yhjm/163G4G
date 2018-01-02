<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP 'info.jsp' starting page</title>
    
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
   <h2>文件上传和下载</h2>
     当前上传的信息回执显示：<br>  
     用户名：<s:property value="username"/><br><br>
   上传文件的名称：<s:property value="uploadfileFileName"/><br><br>
  上传文件的类型：   <s:property value="uploadfileContentType"/><br><br>
  上传文件的大小：  <s:property value="uploadfile.length()"/><br><br>
   下载上传的文件:<br>
   下载方式一:<a href="/Struts2T7/upfile/${uploadfileFileName }">${uploadfileFileName }</a>
   下载方式二:<a href="/Struts2T7/upfile/<s:property value="uploadfileFileName"/>"><s:property value="uploadfileFileName"/></a>
  <br>

  </body>
</html>
