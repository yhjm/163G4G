<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改密码</title>
    
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
  <form id = "frm" action="user?cmd=updatePassword" method="post">
  <table class="list" border="0">
    <tr>
    	<td>用户编号：</td>
    	<td><input type = "text"  readonly="readonly"  value = "${sessionScope.user.userId }"  name = "userId" /></td>
    </tr>
    <tr>
    	<td>原始密码：</td>
    	<td><input type = "password"  id = "oldPwd"/></td>
    </tr>
    <tr>
    	<td>新密码：</td>
    	<td><input type = "password"  id = "newPwd"  name = "newPwd"/></td>
    </tr>
    <tr>
    	<td>确认密码：</td>
    	<td><input type = "password"  id = "renewPwd"/></td>
    </tr>
    <tr>
    	<td>
    		<input type="button" value = "修改"  onclick="check()"/>
    	</td>
    	<td>
    		<input type="button" value = "返回"  onclick="history.back()"/>
    	</td>
    </tr>
    </table>
  </form>
    
    <script type="text/javascript">
    function check(){
    	var oldPwd = document.getElementById("oldPwd").value;
    	var newPwd = document.getElementById("newPwd").value;
    	var renewPwd = document.getElementById("renewPwd").value;
    	var frm = document.getElementById("frm");
    	
    	if(${sessionScope.user.userPassword}==oldPwd){
    		if( newPwd == renewPwd ){
    			frm.submit();
    		}else{
    			window.alert("两次密码输入不一致");
    		}
    	}else{
    		window.alert("原始密码不正确");
    	}
    	
    }
    
    </script>
    
  </body>
</html>
