<%@page import="com.cqut.userManagement.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% User user = (User)request.getAttribute("user"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/userManage/css/userDetail.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="userHeader">
		<div class="curLocation userManage">
			<p>
				<a href="UserManage">人员管理</a> >> <a>编辑</a>
			</p>
		</div>
	</div>
	<form class="user_detail" action="<%=request.getContextPath() %>/UserOperate" method="post">
		<div class="user_id user_infor">
			<label>ID：</label><input type="text" name="userId" value="<%= user.getId() %>" readonly="readonly">
		</div>
		<div class="user_account user_infor">
			<label>账号：</label><input type="text" name="userAccount" value="<%= user.getAccount() %>" readonly="readonly">
		</div>
		<div class="user_name user_infor">
			<label>姓名：</label><input type="text" name="userName" value="<%= user.getUserName() %>" >
		</div>
		<div class="user_phone user_infor">
			<label>电话：</label><input type="text" name="userPhone" value="<%= user.getPhoneNumber() %>" >
		</div>
		<div class="user_role user_infor">
			<label>角色：</label><input type="text" name="userRole" value="<%= user.getRemark() %>" readonly="readonly">
		</div>
		<div class="btn">
			<input type="hidden" name="operate" value="update">
			<p><input type="submit" value="修改"></p>
			<p><a href="UserManage">返回</a></p>
		</div>
	</form>
</body>
</html>