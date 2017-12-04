<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加数据</title>
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
<div class="menu">
	<form method="post" action="commonServlet?cmd=selectPage">
		商品名称：<input type="text" name="goodsName" class="input-text" />&nbsp;&nbsp;&nbsp;&nbsp;
		是否付款：<select name="isPayed">
			<option value=""  selected="selected">请选择</option>
			<option value="1">已付款</option>
			<option value="0">未付款</option>
		</select>&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="submit" value="组合查询" class="button" />
	</form>
</div>
<div class="main">
	<div class="optitle clearfix">
		<em><input type="button" name="button" value="添加数据" class="input-button" onclick="location.href='modify.jsp'" /></em>
		<div class="title">账单管理&gt;&gt;</div>
	</div>
	<form method="post"  action = "goods?cmd=goodsByName">
		<div class="content">
			<table class="box">
			<tr>
					<td class="field">商品ID：</td>
					<td>
						<select name="goodsId">
							<c:forEach items="${listsgId }"  var = "goods">
									<option value = "${goods.goodsId }">${goods.goodsId }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="field">商品名称：</td>
					<td><input type="text" name="goodsName" class="text" /></td>
				</tr>
				
				<tr>
					<td class="field">商品数量：</td>
					<td><input type="text" name="businessNum" class="text" /></td>
				</tr>
				<tr>
					<td class="field">供应商ID：</td>
					<td>
						<select name="providerId">
							<c:forEach items="${listp }"  var = "provider">
									<option value = "${provider.providerId }">${provider.providerName }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="field">是否付款：</td>
					<td><select name="isPayed">
						<option value="1">是</option>
                        <option value="0">否</option>
					</select></td>
				</tr>
			</table>
		</div>
		<div class="buttons">
			<input type="submit" name="submit" value="确认" class="input-button" />
			<input type="button" name="button" value="返回" class="input-button" onclick="history.back();" />
		</div>
	</form>
</div>
</body>
</html>
