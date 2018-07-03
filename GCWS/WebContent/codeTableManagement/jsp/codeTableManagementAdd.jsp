<%@page import="com.cqut.codeTableManagement.impl.CodeTableImpl"%>
<%@page import="com.cqut.codeTableManagement.entity.CodeTable"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	ArrayList<CodeTable> cdList = (ArrayList<CodeTable>)new CodeTableImpl().getNullParentCode();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=basePath %>codeTableManagement/css/codeTableManagement.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>codeTableManagement/js/codeTableManagement.js"></script>
<title>码表数据新增</title>
</head>
<body>
	<div class="articleHead">
		<div class="curLocation articleDetail">
			<p><a href="<%=basePath %>CodeTableManagementServlet">码表管理</a> >> <a>新增</a></p>
		</div>
	</div>
	<form name="codeTableManageForm" action="<%=basePath %>CodeTableManagementAdd" onsubmit="return validate(this);" method="get">
	<table class="moduleDetailTable">
		<tr>
			<td class="leftTd">*码表名</td>
			<td style="width: 40%;"><input class="inputText" type="text" name="paramName" /> </td>	
		</tr>
		<tr>
			<td class="leftTd">*码表内容:</td>
			<td style="widht: 40%;"><input class="inputText"  type="text" name="paramText"/> </td>
		</tr>
		<tr>
			<td class="leftTd">*所属码表数据:</td>
			<td>
				<select class="inputText"  name="parentCode">
					<option value="">第一级码表</option>
					<%for(int i = 0; i < cdList.size(); i++) { %>
					<option value="<%=cdList.get(i).getParamCode() %>"><%=cdList.get(i).getParamText() %></option>
					<%} %>
				</select>
			</td>
		</tr>
		<tr>
			<td class="leftTd">等级:</td>
			<td>
				<input class="inputText" type="text" name="level"/>
			</td>
		</tr>
		<tr>
			<td class="leftTd">*是否有孩子节点:</td>
			<td>
				否<input type="radio" name="hasChild" value="0"/>
				是<input type="radio" name="hasChild" value="1"/>
			</td>
		</tr>
		<tr>
			<td class="leftTd">备注:</td>
			<td>
				<textarea class="inputText ta" rows="200" cols="150" name="remark"></textarea>
			</td>
		</tr>
	</table>
	<input class="returnBT formBT" type="button" onclick="window.location.href='<%=basePath %>CodeTableManagementServlet'" value="返回">
	<input class="submitBT formBT" type="submit" value="提交">
</form>
</body>
</html>