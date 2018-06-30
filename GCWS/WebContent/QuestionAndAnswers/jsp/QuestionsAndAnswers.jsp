<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.* "%>
	  <%@page import="com.cqut.messageManagement.entity.Message" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	List<Message> list1 = (List<Message>)request.getAttribute("MessageList");	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=path %>/QuestionAndAnswers/css/questionsAndAnswers.css" />
<title>通用课程网站系统</title>
</head>

<body>
  <div class="top_content">
       	<table border='0' cellspacing='5' width="800">
		<tr>
			<td class="title">用户</td>
			<td class="title">发表内容</td>
			<td class="title">发表时间</td>
	
		</tr>
	    
<%for(int i=0 ;i<list1.size();i++) {%>
		<tr>
			
			<td><%=list1.get(i).getId() %></td>
			<td><%=list1.get(i).getMessage_content() %></td>
			<td><%=list1.get(i).getCreate_time() %></td>
			
		</tr>
		<%} %>
	</table>
	</div>
	
	<hr style=" height:2px;border:none;border-top:2px dotted #185598;width:800px;margin-left:0px;" />
	<br/>
	 <form action="<%=request.getContextPath()%>/messageManagement"method="post">
		    <textarea name="input_content" class="input_box">你想说......</textarea>
			<input type="submit" name="publish" value="发表" />
	</form>


</body>
</html>