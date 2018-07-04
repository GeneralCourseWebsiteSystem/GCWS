<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.* "%>
<%@page import="com.cqut.messageManagement.entity.MessageUser"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	List<MessageUser> list1 = (List<MessageUser>) request.getAttribute("MessageList");
	String courseId = String.valueOf(request.getAttribute("courseId"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/QuestionAndAnswers/css/questionsAndAnswers.css" />
<title>通用课程网站系统</title>
</head>

<body>
	<div class="bgColor">
		<div class="top_content">
			<%
				for (int i = 0; i < list1.size(); i++) {
			%>
			<hr style="width:90%;"/>
			<div class="card">
				<div class="cardText">
					<p><%=list1.get(i).getMessageContent()%></p>
				</div>
				<div class="cardInfo">
					<p><%=(i+1)+"#"%> <%=list1.get(i).getUserName()%> | <%=list1.get(i).getCreateTime()%></p>
				</div>
			</div>
			<%
				}
			%>
		</div>
		<br />
		<form class="iSayText" action="<%=request.getContextPath()%>/MessageManagement?id=<%=courseId %>" method="post">
			<table style="width: 100%;">
				<tr>
					<td style="width: 80%;"><textarea name="input_content" class="input_box">你想说......</textarea></td>
					<td style="width: 20%;"><input class="publish" type="submit" name="publish" value="发表" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>