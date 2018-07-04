<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
        <%@page import="com.cqut.courseIntroduce.entity.CourseActive"%>
        <%@page import="com.cqut.courseIntroduce.entity.ArticleContent"%>
        <% 
List<CourseActive> list = (List<CourseActive>) request.getAttribute("ActiveContent");
List<ArticleContent> content = (List<ArticleContent>) request.getAttribute("ArticleContent");
       
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="word-break:break-all">
<%=content.get(0).getArticleContent() %>
<br/>
<%=list.get(0).getCreateTime() %>
</div>
</body>
</html>