<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
        <%@page import="com.cqut.courseIntroduce.entity.CourseOutlineContent"%>
        <% 
List<CourseOutlineContent> list = (List<CourseOutlineContent>) request.getAttribute("Outline");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
课程大纲
<hr style="height:3px;border:none;border-top:3px double red;" />
<div style="word-break:break-all">
课程阶段：<%=list.get(0).getCourseStage() %>
</div>

<div style="word-break:break-all">
阶段内容<%=list.get(0).getStageInfo() %>
</div>

<div style="word-break:break-all">
创建时间:<%=list.get(0).getCreateTime() %>
</div>

<div style="word-break:break-all">
大纲备注<%=list.get(0).getRemark() %>
</div>

</body>
</html>