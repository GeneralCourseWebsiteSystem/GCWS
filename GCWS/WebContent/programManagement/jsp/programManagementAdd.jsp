<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=basePath %>programManagement/css/programManagement.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>programManagement/js/programManagement.js"></script>
<title>栏目新增</title>
</head>
<body>
	<div class="articleHead">
		<div class="curLocation articleDetail">
			<p><a href="<%=basePath %>ProgramManagementServlet">栏目管理</a> >> <a>新增</a></p>
		</div>
	</div>
	<form class="programForm"  action="<%=basePath %>ProgramManagementAdd" onsubmit="return validate(this);">
		<table class="programTable">
			<tr style="display: none;">
				<td class="leftTd">*栏目Id</td>
				<td class="rightTd">
					<input class="inputText" type="text" name="programId"/> 
				</td>	
			</tr>
			<tr>
				<td class="leftTd">*栏目名:</td>
				<td class="rightTd">
					<input class="inputText" type="text" name="programName"/>
				</td>
			</tr>
			<tr>
				<td class="leftTd">*栏目路径:</td>
				<td class="rightTd">
					<input class="inputText" type="text" name="programPath"/>
				</td>
			</tr>
			<tr>
				<td class="leftTd">栏目代码:</td>
				<td class="rightTd">
					<textarea name="programCode" class="programCode"></textarea>
				</td>
			</tr>
			<tr>
				<td class="leftTd">备注:</td>
				<td class="rightTd">
					<textarea name="remark" class="programCode" style="height: 50px"></textarea>
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