<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Integer warning = (Integer)request.getAttribute("warning"); 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>通用课程网站系统</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/common/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/login/css/stageLogin.css">

</head>
<body >
<div class="login-form">
	<h1>用户登录</h1>
	<div class="login-top">
			<form action="<%=request.getContextPath()%>/UserManagementServlet" >
				<div class="login-ic">
					<i ></i>
					<input type="text" name="user" value="用户" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'User name';}"/>
					<div class="clear"> </div>
				</div>
				<div class="login-ic">
					<i class="icon"></i>
					<input type="password" name="password" value="密码" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'password';}"/>
					<div class="clear"> </div>
				</div>    
				                                    
			    <div class="log-be">
					    <input type="submit" class="log-bwn" value="登录" >
			    </div>
		
		  </form>
    </div>
			
 </div>		
</body>
</html>