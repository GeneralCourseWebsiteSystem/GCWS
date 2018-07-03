<%@page import="com.cqut.moduleManagement.impl.ModuleImpl"%>
<%@page import="com.cqut.moduleManagement.entity.Module"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	ArrayList<Module> moduleList = (ArrayList<Module>)new ModuleImpl().getAllList();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=basePath %>ModuleManagement/css/moduleManagement.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>ModuleManagement/js/moduleManagement.js"></script>
<title>模块新增</title>
</head>
<body>
	<div class="articleHead">
		<div class="curLocation articleDetail">
			<p><a href="<%=basePath %>ModuleManagementServlet">模块管理</a> >> <a>新增</a></p>
		</div>
	</div>
	<form name="moduleManageForm" action="<%=basePath %>ModuleManagementAdd" onsubmit="return validate(this);" method="get">
	<table class="moduleDetailTable">
		<tr>
			<td class="leftTd">*模块名</td>
			<td style="width: 40%;"><input class="inputText" type="text" name="moduleName" /> </td>	
		</tr>
		<tr>
			<td class="leftTd">*路由地址:</td>
			<td style="widht: 40%;"><input class="inputText"  type="text" name="modulePath"/> </td>
		</tr>
		<tr>
			<td class="leftTd">*上级模块编码:</td>
			<td>
				<select class="inputText"  name="parentCode">
					<option value="">无上级模块</option>
					<%for(int i = 0; i < moduleList.size(); i++) { %>
					<option value="<%=moduleList.get(i).getModuleCode() %>"><%=moduleList.get(i).getModuleName() %></option>
					<%} %>
				</select>
			</td>
		</tr>
		<tr>
			<td class="leftTd">*是否为菜单:</td>
			<td>
				否<input type="radio" name="isMenu" value="0"/>
				是<input type="radio" name="isMenu" value="1"/>
			</td>
		</tr>
		<tr>
			<td class="leftTd">等级:</td>
			<td>
				<input class="inputText" type="text" name="level"/>
			</td>
		</tr>
		<tr>
			<td class="leftTd">备注:</td>
			<td>
				<textarea class="inputText ta" rows="200" cols="150" name="remark"></textarea>
			</td>
		</tr>
	</table>
	<input class="returnBT formBT" type="button" onclick="window.location.href='<%=basePath %>ModuleManagementServlet'" value="返回">
	<input class="submitBT formBT" type="submit" value="提交">
</form>
	
</body>
</html>