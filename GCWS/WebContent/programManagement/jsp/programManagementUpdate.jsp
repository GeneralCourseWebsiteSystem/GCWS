<%@page import="com.cqut.programManagement.entity.Program"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	Program program = (Program)request.getAttribute("program");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=basePath %>programManagement/css/programManagement.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>programManagement/js/programManagement.js"></script>
<title>栏目详情</title>
</head>
<body>
	<div class="articleHead">
		<div class="curLocation articleDetail">
			<p><a href="ProgramManagementServlet">栏目管理</a> >> <a>详情</a></p>
		</div>
	</div>
	<form class="programForm" action="ProgramManageUpdate" onsubmit="return validate(this);">
		<table class="programTable">
			<tr style="display: none;">
				<td class="leftTd">*栏目Id</td>
				<td class="rightTd">
					<input class="inputText" type="text" name="programId" value="<%=program.getId() %>" /> 
				</td>	
			</tr>
			<tr>
				<td class="leftTd">*栏目名:</td>
				<td class="rightTd">
					<input class="inputText" type="text" name="programName" value="<%=program.getProgramName() %>" />
				</td>
			</tr>
			<tr>
				<td class="leftTd">*栏目路径:</td>
				<td class="rightTd">
					<input class="inputText" type="text" name="programPath" value="<%=program.getProgramPath() %>" />
				</td>
			</tr>
			<tr>
				<td class="leftTd">栏目代码:</td>
				<td class="rightTd">
					<textarea name="programCode" class="programCode"><%=(program.getProgramCode() == null ? "" : program.getProgramCode()) %></textarea>
				</td>
			</tr>
			<tr>
				<td class="leftTd">备注:</td>
				<td class="rightTd">
					<textarea name="remark" class="programCode" style="height: 100px;">
						<%=(program.getRemark() == null ? "" : program.getRemark()) %>
					</textarea>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input class="returnBT formBT" type="button" onclick="window.location.href='<%=basePath %>ProgramManagementServlet'" value="返回">
					<input class="submitBT formBT" type="submit" value="提交">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>