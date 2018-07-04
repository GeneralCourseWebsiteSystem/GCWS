<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
                     + request.getServerName() + ":" + request.getServerPort()  
                     + path + "/";  
  
    String content=( String)session.getAttribute("content");
    String title=( String)session.getAttribute("title");
    String courseid=(String)session.getAttribute("courseid");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/CourseResearch/css/articleShow.css">
<title>Insert title here</title>
</head>
<body>
<div class="main">
   <div class="mainTop">
	   <div class="maintitle"><h3>课程研究</h3>
	   </div>
	   <div class="titleline"></div>
	</div>
   <div class="return"><a href="<%=request.getContextPath() %>/CourseResearchManagementServlet?id=<%=courseid %>"><h1>返回</h1></a></div>
   <div class="arname"><h2><%=title %></h2></div>
   <div class="content">&nbsp;&nbsp;<%=content %></div>
</div>
</body>
</html>