<%@page import="com.cqut.common.util.StringUtil"%>
<%@page import="com.cqut.moduleManagement.entity.Module"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	Module module = (Module)request.getAttribute("module");
	String parentName;
	Module parentModule = (Module)request.getAttribute("parentModule");
	if(parentModule == null) {
		parentName = "/";
	} else {
		parentName = parentModule.getModuleName();
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=basePath %>ModuleManagement/css/moduleManagement.css" rel="stylesheet" type="text/css" />
<title>模块详情</title>
</head>
<body>
	<div class="articleHead">
		<div class="curLocation articleDetail">
			<p><a href="ModuleManagementServlet">模块管理</a> >> <a>详情</a></p>
		</div>
	</div>
	<form action="" method="get">
		<table class="moduleDetailTable">
			<tr>
				<td class="topTd" colspan="4"><%=module.getModuleName() %></td>
			</tr>
			<tr>
				<td class="leftTd">模块编码:</td><td style="width: 40%;"><%=module.getModuleCode() %> </td>	
				<td class="leftTd">上级节点:</td><td style="widht: 40%;"><%=parentName %></td>
			</tr>
			<tr>
				<td class="leftTd">路由地址:</td><td><%=module.getModulePath() %></td>
				<td class="leftTd">模块等级:</td><td><%=module.getLevel() %></td>
			</tr>
			<tr>
				<td class="leftTd">是否为菜单:</td><td><%=module.getIsMenu() %></td>
				<td class="leftTd">创建时间:</td><td><%=module.getCreateTime() %></td>
			</tr>
			<tr>
				<td class="leftTd">备注:</td><td colspan="2"><%=module.getRemark() %></td>
			</tr>
		</table>
	</form>
	<div class="BT"><p><a href="ModuleManagementServlet">返回</a></p></div>
</body>
</html>