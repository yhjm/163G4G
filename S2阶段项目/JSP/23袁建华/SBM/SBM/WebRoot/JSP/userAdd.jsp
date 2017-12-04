<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri = "core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    

	<title>Insert title here</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link type="text/css" rel="stylesheet" href="css/style.css">

</head>
<body>
<c:if test="${param.add == 'error' }">
<script type="text/javascript">
window.alert("添加失败");
</script>

</c:if>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">用户管理&gt;&gt;</div>

	</div>
	<form id="frm" name="frm" method="post" action="user?cmd=uploadUser" >
<input type="hidden" name="flag" value="doAdd">
		<div class="content">
			<table class="box">
			<font color="red"></font>
			<tr>
					<td class="field">用户名称：</td>
					<td><input type="text" name="userName" class="text" id="userName" /> <font color="red">*</font></td>
				</tr>
			<tr>
					<td class="field">用户头像：</td>
					<td><input type="file" name="pic" class="text" id="pic" /> <font color="red">*只允许png,jpg,jpeg,gif类型的文件，最大文件大小为5M</font></td>
				</tr>
				<tr>
					<td class="field">用户密码：</td>

					<td><input type="password" name="userPassword" class="text" id="userPassword" /> <font color="red">*</font></td>
				</tr>
			<tr>
					<td class="field">确认密码：</td>
					<td><input type="password" name="userPassword1" class="text"  id="userPassword1" /> <font color="red">*</font></td>
				</tr>

				<tr>
					<td class="field">用户性别：</td>
						<td>
							<select name="userSex" id="userSex">
    						<option value="W">女</option>
    							<option value="M">男</option>
  							</select>
  					</td>
				</tr>

				<tr>
					<td class="field">用户年龄：</td>
					<td><input type="text" name="userAge" class="text" id="userAge"/> <font color="red">*</font></td>
				</tr>
				<tr>
					<td class="field">用户电话：</td>
					<td><input type="text" name="telephone" class="text" id="telephone"/> <font color="red">*</font></td>

				</tr>
				<tr>
					<td class="field">用户地址：</td>
					<td><textarea name="address" id="address" class="text" cols="45" rows="5"></textarea></td>
				</tr>
				<tr>
					<td class="field">用户权限：</td>

					<td><input type="radio" name="type" id="type" value="1" checked="checked"/>普通用户
					<input type="radio" name="type" id="type" value="0" />经理</td>
				</tr>
			</table>
		</div>
		<div class="buttons">
			<input type="button"  value="数据提交" onclick="sub()" class="input-button"/>
			  <input type="button"  onclick="window.location='userAdmin.jsp';" value="返回" class="input-button"/> 
		</div>

	</form>
</div>
<script type="text/javascript">
function checkAge() {
	var userAge = document.getElementById("userAge").value;
	if(userAge > 0 && userAge < 120){
		//满足数据要求
		return true;
	}else{
		return false;
	}
}

function checkEmpty(id) {
	var empty = document.getElementById(id).value;
	if(empty != null && empty != ""){
		return true;
	}else{
		return false;
	}
}
function sub(){
	var frm = document.getElementById("frm");
		if(
				checkEmpty("userName") &&
				checkEmpty("userPassword") &&
				checkEmpty("userPassword1") &&
				checkEmpty("userSex") &&
				checkEmpty("userAge") &&
				checkEmpty("telephone") &&
				checkEmpty("address") &&
				checkEmpty("pic") &&
				checkEmpty("type")	
		){
			if(checkPassword()){		
				if(checkAge()){
					frm.submit();
				}else{
					alert("年龄只能在0-120之间!");
					return false;
				}
			}else{
				alert("密码不一致!");
				return false;
			}
		}else{
			alert("请检查用户信息是否完整!");
			return false;
		}	
}


</script>
</body>
</html>
