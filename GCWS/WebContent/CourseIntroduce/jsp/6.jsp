<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
        <%@page import="com.cqut.courseIntroduce.entity.CourseActive"%>
        <% 
List<CourseActive> list = (List<CourseActive>) request.getAttribute("Active");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
课程动态
<hr style="height:3px;border:none;border-top:3px double red;" />
<div style="word-break:break-all">
<%for (int i=0;i<list.size();i++) {%>
<a href="<%=request.getContextPath() %>/CourseIntroduceActiveContent?name=<%=list.get(i).getArticleName() %> "><%=list.get(i).getArticleName() %></a>
<br/>
<%} %>
</div>
</body>
</html>