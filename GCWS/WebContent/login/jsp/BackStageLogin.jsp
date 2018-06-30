<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>通用课程网站后台登录界面</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/login/css/BackStageLogin.css">
</head>
<body>
<div class="header">
        <div class="title-main">
             <h1> 后台管理系统</h1>
        </div>
		<div class="titleline"></div>


     <div class="content">
     <form action="UserManagementServlet">
	     <center>
		 <div class="con">
		 <div class="con_title">
			<span class="con_title_sp">管理员登录</span>
		 </div>
		 <div class="con_panel">
			<div class="con_input">
				<span>用户名：</span><input type="text" name="user"  placeholder="请输入账号"/>
			</div>
			<div class="con_input">
				<span>密&nbsp;&nbsp;&nbsp;&nbsp;码：</span><input type="text" name="password" placeholder="密码"/>
			</div>
			
			<input type="submit" value="登    录" class="submit-btn"/>
		  </div>
	      </div>
	   </center>
	   </form>
    </div>
 </div>
</body>
</html>