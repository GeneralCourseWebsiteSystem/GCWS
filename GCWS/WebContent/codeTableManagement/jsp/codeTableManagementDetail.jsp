<%@page import="com.cqut.codeTableManagement.entity.CodeTable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	CodeTable codeTable = (CodeTable)request.getAttribute("codeTable");
	String parentName;
	CodeTable parentModule = (CodeTable)request.getAttribute("parentCodeTable");
	if(parentModule == null) {
		parentName = "/";
	} else {
		parentName = parentModule.getParamName();
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=basePath %>codeTableManagement/css/codeTableManagement.css" rel="stylesheet" type="text/css" />
<title>码表详情</title>
</head>
<body>
<div class="articleHead">
		<div class="curLocation articleDetail">
			<p><a href="CodeTableManagementServlet">码表管理</a> >> <a>详情</a></p>
		</div>
</div>
<form action="" method="get">
	<table class="moduleDetailTable">
		<tr>
			<td class="topTd" colspan="4"><%=codeTable.getParamName() %></td>
		</tr>
		<tr>
			<td class="leftTd">码表编码:</td><td style="width: 40%;"><%=codeTable.getParamCode() %> </td>	
			<td class="leftTd">上级节点:</td><td style="widht: 40%;"><%=parentName %></td>
		</tr>
		<tr>
			<td class="leftTd">码表内容:</td><td><%=codeTable.getParamText() %></td>
			<td class="leftTd">模块等级:</td><td><%=codeTable.getLevel() %></td>
		</tr>
		<tr>
			<td class="leftTd">是否有孩子节点:</td><td><%=(codeTable.getHasChild() == 0 ? "否" : "是") %></td>
			<td class="leftTd">创建时间:</td><td><%=codeTable.getCreateTime() %></td>
		</tr>
		<tr>
			<td class="leftTd">备注:</td><td colspan="2"><%=(codeTable.getRemark() == null ? "" : codeTable.getRemark()) %></td>
		</tr>
	</table>
</form>
<div class="BT"><p><a href="CodeTableManagementServlet">返回</a></p></div>
</body>
</html>