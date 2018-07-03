<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import=" com.cqut.teachTeamManagement.entity.Teacher"
         import="java.util.ArrayList"
 %>
<%
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
                     + request.getServerName() + ":" + request.getServerPort()  
                     + path + "/";  
  
    ArrayList<Teacher> tlist=( ArrayList<Teacher>)session.getAttribute("tlist");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/TeachTeam/css/teachTeam.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/stageMultiplexing.css">
</head>
<body>

<div class="main">
	<div class="title">
	    <div class="titleLeft">
	         <div class="titleLeftTop">
	         
	         </div>
	         
	    </div>
	      
	    <div class="titleRight">
	    </div>
	</div>
</div>

</body>
</html>