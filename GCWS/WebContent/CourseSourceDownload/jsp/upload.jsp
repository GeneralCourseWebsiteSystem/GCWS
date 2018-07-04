
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.* "%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.cqut.courseSourceDownload.entity.DownLoad"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CourseSourceDownload/css/upload.css">
<title>文件上传页面</title>
</head>
<body>
	<%
		List<DownLoad> list1 = (List<DownLoad>) request.getAttribute("Info_all");
		if (request.getParameter("info") != null) {
	%>

	<script type="text/javascript">
		alert("${info}");
	</script>
	<%
		}
	%>

	<!-- 上传文件是上传到服务器上，而保存到数据库是文件名 -->
	<!-- 上传文件是以文件转换为二进制流的形式上传的 -->
	<!-- enctype="multipart/form-data"需要设置在form里面，否则无法提交文件 -->
	<div class="main">
		<div class="mainTop">
			<form action="<%=request.getContextPath()%>/upload" method="post"
				enctype="multipart/form-data">
				<div class="downLoad">
					<p class="word">文件上传</p>
				</div>
				<table class="fileTable">
					<tr>
						<td class="leftTd">文件描述:</td>
						<td class="rightTd"><input type="text" name="desc" /></td>
					</tr>
					<tr>
						<td class="leftTd">上传文件:</td>
						<td class="rightTd"><input type="file" name="file" /></td>
					</tr>
					<tr>
						<td class="leftTd"></td>
						<td class="rightTd"><input type="submit" value="上传文件" /></td>
					</tr>
				</table>
			</form>

			<div class="downLoad">
				<p class="word">下载文件</p>
				<c:forEach items="${files}" var="name">
					<a class="link" href="upload/${name }">${name }</a>
					<br />
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>