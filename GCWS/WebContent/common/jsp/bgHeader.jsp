<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String userName = String.valueOf(request.getSession().getAttribute("username"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/common.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="../font-awesome-4.7.0/css/font-awesome.min.css">
<title>header</title>
</head>
<body>
<div class="nav">
	<div class="navTitle">
		<p>通用课程网站后台管理</p>
	</div>
	<div class="loginInfo">
		<p class="navWords">| <a href="#"> 修改密码 </a> | <a href="<%=basePath%>BackManagementQuit"> 退出  </a> | </p>
	</div>
</div>
<div class="userInfo">
	<p class="curUser"><span class="fa fa-user-o"></span><a> 欢迎您，<%=userName %></a></p>
	<p class="backIndex"><a href="<%=basePath %>index.jsp"><span class="fa fa-home fa-lg inde"></span></a></p>
</div>
</body>
</html>