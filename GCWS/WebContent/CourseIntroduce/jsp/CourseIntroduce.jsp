<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/CourseIntroduce/css/CourseIntroduce.css" />

<head>
    <meta charset="utf-8">
    <title>通用课程网站系统</title>
  
    <script type="text/javascript">
        var selectedLi;
 
        function change(page) {
            if (selectedLi == null) {
                selectedLi = page;
                selectedLi.className = null;
            } else {
                selectedLi.className = null;
                selectedLi = page;
            }
            page.className = "li";
            // 在同一目录下 创建1.html 2.html 3.html 取消注释下面的iframe 可使用此方法进行切换
             document.getElementById('content').src = page.rel;
           // document.getElementById('container').innerHTML = "#######" + page.rel;
 
        }
 
    </script>
</head>
<body>
<ul id="menu">

    <li><a onclick="change(this)" href="javascript:;" rel="<%=request.getContextPath()%>/CourseIntroduce">课程简介</a></li>
    <li><a onclick="change(this)" href="javascript:;" rel="<%=request.getContextPath()%>/CourseIntroduceTeachWay">教学方法</a></li>
    <li><a onclick="change(this)" href="javascript:;" rel="<%=request.getContextPath()%>/CourseArrange">课程安排</a></li>
    <li><a onclick="change(this)" href="javascript:;" rel="<%=request.getContextPath()%>/CourseOutline">课程大纲</a></li>
    <li><a onclick="change(this)" href="javascript:;" rel="<%=request.getContextPath()%>/CourseIntroduceMisStatement">理念与目标</a></li>
    <li><a onclick="change(this)" href="javascript:;" rel="<%=request.getContextPath()%>/CourseIntroduceActive">课程动态</a></li>
    
    
</ul>
<div id="container" class="container">

     <iframe id="content" class="iframe" src="<%=request.getContextPath()%>/CourseIntroduce"></iframe> 
</div>
<script type="text/javascript">
    var ul = document.getElementById("menu");
    var li = ul.getElementsByTagName("li")[0];
    selectedLi = li.getElementsByTagName("a")[0];
</script>
</body>
</html>