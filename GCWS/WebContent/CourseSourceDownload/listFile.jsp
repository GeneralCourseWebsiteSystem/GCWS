<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     
     <% 
     String path = request.getContextPath();
 	 String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
 			+ path + "/";
     %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=basePath%>CourseSourceDownload/css/download.css"
	rel="stylesheet" type="text/css" />	
<title>Insert title here</title>
</head>
<body>
 <!-- 遍历Map集合 -->
11     <c:forEach var="me" items="${fileNameMap}">
12         <c:url value="/courseSourceDownload/Download" var="downurl">
13             <c:param name="filename" value="${me.key}"></c:param>
14         </c:url>
15         ${me.value}<a href="${downurl}">下载</a>
16         <br/>
17     </c:forEach>

</body>
<div class="pick">

</div>
</html>