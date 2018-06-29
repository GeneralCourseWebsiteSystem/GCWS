<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="../css/questionsAndAnswers.css" />
<title>通用课程网站系统</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/messageManagement"method="post">
        <textarea rows="20" cols="100"  >
显示所有的聊天信息
sdsdsds
sdsdsd
sdsdsd
        </textarea>
        <br/>

    <p class="title">问题与答疑</p>

		<textarea rows="20" cols="100"></textarea>
		<br/>
		<input class="btn" type="submit" name="yes" value="发表" />
	</form>


</body>
</html>