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
   <div class="return"><a href="<%=request.getContextPath() %>/CourseResearchManagementServlet?id=<%=courseid %>">返回</a></div>
   <div class="arname"><%=title %></div>
   <div class="content"><p><%=content %></p></div>
   </div>
</div>
</body>
</html>