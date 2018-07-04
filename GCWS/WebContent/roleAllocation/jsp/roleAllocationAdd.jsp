<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% 
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=basePath%>roleAllocation/css/roleAllocationAdd.css"
	rel="stylesheet" type="text/css" />	
<title>Insert title here</title>
</head>
<body>
	<div class="articleHead">
		<div class="curLocation articleDetail">
			<p>
				<a href="RoleAllocationBackManage">角色管理 </a> >> <a>新增</a>
			</p>
		</div>
	</div>
	<form class="programForm" action="<%=request.getContextPath()%>/RoleAllocationAdd" method="post">
		<table class="programTable">
			<tr>
				<td class="leftTd">角色名:</td>
				<td><input class="inputText type="text" placeholder="角色名" name="newRole"></td>
			</tr>
			<tr>
				<td class="leftTd">备注:</td>
				<td><input class="inputText type="text" placeholder="备注" name="newRemark"></td>
			</tr>
			<tr>
				<td class="leftTd"></td>
				<td>
					<input class="submitBT formBT" type="submit" name="submit"  value="保存"class="newAdd">
					<input class="returnBT formBT" type="button" onclick="window.location.href='<%=request.getContextPath()%>/RoleAllocationBackManage'"  value="取消"class="newAdd">
				</td>
			</tr>
	   	</table>
	</form>
</body>
</html>