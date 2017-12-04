<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri ="core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'providerAdd.jsp' starting page</title>
     <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">供应商管理&gt;&gt;</div>
	</div>
	<c:if test="${param.add == 'error' }">
		<script type="text/javascript">
		window.alert("添加供应商失败");
		
		</script>
	
	</c:if>
	<form id="form1"   method="post" action="provider?cmd=addProvider" onsubmit="return checkit();">
		<div class="content">
		<font color="red"></font>
		<input name="flag" value="doAdd" type="hidden">
			<table class="box">

			<tbody>
				<tr>
					<td class="field">供应商名称：</td>
					<td>
					<input name="providerName" id="providerName" value="" class="text" type="text">
					 <font color="red">*</font></td>

				</tr>
				<tr>
					<td class="field">供应商描述：</td>
					<td><textarea name="providerDetail" id="providerDetail" cols="45" rows="5"></textarea></td>
				</tr>
				<tr>
					<td class="field">供应商联系人：</td>

					<td><input name="contact" id="contact" value="" class="text" type="text"></td>
				</tr>
				<tr>
					<td class="field">供应商电话：</td>
					<td><input name="telephone" id="telephone" value="" class="text" type="text"></td>
				</tr>
				<tr>
					<td class="field">供应商传真：</td>

					<td><input name="facsimile" id="facsimile" value="" class="text" type="text"></td>
				</tr>
				<tr>
					<td class="field">供应商地址：</td>
					<td><input name="address" id="address" value="" class="text" type="text"></td>
				</tr>
			</tbody></table>
		</div>

		<div class="buttons">
			<input name="button" id="button" value="提交" class="input-button" type="submit"> 
			<input name="button" id="button" onclick="window.location='JSP/providerAdmin.jsp';" value="返回" class="input-button" type="button"> 
		</div>
	</form>
</div>
<script type="text/javascript">
	function checkit(){
		var providerName = document.getElementById("providerName").value;
		var providerDetail = document.getElementById("providerDetail").value;
		var contact = document.getElementById("contact").value;
		var telephone = document.getElementById("telephone").value;
		var facsimile = document.getElementById("facsimile").value;
		var address = document.getElementById("address").value;
		if(provideName != null && providerDetail != null && contact != null && telephone != null && facsimile != null && address != null){
			return true;
		}else{
			return false;
		}
		
	}


</script>

</body>
</html>
