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
    <div class="mainTop">
	   <div class="maintitle"><h3>教学团队</h3>
	   </div>
	   <div class="titleline"></div>
	</div>
	<% for(int i=0;i<tlist.size();i++ ){%>
	<div class="teacher">
	    <div class="teachername">
	         <img src="../../common/image/5.jpg" />
	        <h1><%=tlist.get(i).getUseranme() %></h1>
	    </div>
	    <div class="teacherline"></div>
	    <div class="teacherintroduce"><h2>&nbsp;&nbsp;&nbsp;&nbsp;<%=tlist.get(i).getTeacherIntroduce() %></h2></div>
	</div>
    <%} %>
</div>

</body>
</html>