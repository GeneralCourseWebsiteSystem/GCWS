<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
        <%@page import="com.cqut.courseIntroduce.entity.CourseIntroduceContent"%>
        <% 
List<CourseIntroduceContent> list = (List<CourseIntroduceContent>) request.getAttribute("MisStatement");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
理念与目标
<hr style="height:3px;border:none;border-top:3px double red;" />
<div style="word-break:break-all">
<%=list.get(0).getMisStatement() %>
</div>

</body>
</html>