<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/RoleAllocationAdd" method="post">
		<div><input type="text" placeholder="新增角色" name="newRole"></div>
		<div><input type="text" placeholder="备注" name="newRemark"></div>
		<div><input type="submit" name="submit" value="增加"></div>
		<div><a href ="<%=request.getContextPath()%>/RoleAllocationBackManage">取消</a></div>
	</form>
</body>
</html>