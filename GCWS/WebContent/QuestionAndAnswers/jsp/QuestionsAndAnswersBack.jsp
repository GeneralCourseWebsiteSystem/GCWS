<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"
	import="java.text.SimpleDateFormat"%>

<%@page import="com.cqut.messageManagement.entity.MessageUser"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	List<MessageUser> list = (List<MessageUser>) request.getAttribute("MessageList");
	String str = (String) request.getAttribute("str");
	if (str == null) {
		str = "";
	}
	String html = (String) request.getAttribute("html");
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=basePath%>common/css/page.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>QuestionAndAnswers/css/questionsAndAnswersBack.css" rel="stylesheet" type="text/css" />
<title>留言管理</title>
</head>
<body>
	<div class="articleHead">
		<div class="curLocation articleManage">
			<p><a href="MessageManagementBack">留言管理</a></p>
		</div>
	</div>
	<form class="searchForm" action="" method="get">
		<p>
			留言內容:<input class="searchInput" placeholder="请输入內容" type="text"
				name="str" value="<%=str%>" /> <input class="searchButton"
				type="submit" value="查询" />
		</p>
	</form>
	<table class="qaaTable">
		<tr class="thTr">
			<th style="width: 8%;">用户名</th>
			<th style="width: 20%;">发表内容</th>
			<th style="width: 10%;">课程名</th>
			<th style="width: 13%;">发表时间</th>
			<th style="width: 10%;">是否展示在前台</th>
			<th style="width: 8%;">操作</th>
		</tr>
		<%
			for (int i = 0; i < list.size(); i++) {
		%>
		<tr height="50" class="two">
			<td class="exchange"><%=list.get(i).getUserName()%></td>
			<td><%=list.get(i).getMessageContent()%></td>
			<td class="exchange"><%=list.get(i).getCourseName()%></td>
			<td><%=df.format(list.get(i).getCreateTime())%></td>
			<%
				if (list.get(i).getIsDelete() == 0) {
			%>
			<td>是</td>
			<%
				} else {
			%>
			<td>否</td>
			<%
				}
			%>
			<td>
				<a class="hrefA" href="<%=request.getContextPath()%>/MessageManagementBack?code=delete&name=<%=list.get(i).getMsgId()%>&IF=<%=list.get(i).getIsDelete()%> ">删除</a>
			</td>
		</tr>
		<%
			}
		%>

	</table>
	<div style="width: 97%; margin-left: 1.5%;">
		<c:if test="${not empty html}">
			<div class="page">${html}</div>
		</c:if>
	</div>
</body>
</html>