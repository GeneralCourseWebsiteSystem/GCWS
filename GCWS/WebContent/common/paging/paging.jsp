<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
    <%@page import="com.cqut.userManagement.entity.UserRole" %>
<%
//接收的参数为存在List中的对象
	List<UserRole> list = (List<UserRole>)request.getAttribute("UserRole");	
	int pageIndex = 1;
	
	Integer totalPage = Integer.parseInt(request.getAttribute("totalPage")+"");
	Integer pageMegNum = Integer.parseInt(request.getAttribute("pageMegNum")+"");
	if(request.getAttribute("pageIndex")==null){
		pageIndex = 1;
	}else{
		pageIndex = Integer.parseInt(request.getAttribute("pageIndex")+"");
	}
	  
	
//将下面的这段代码copy在post方法中（下面的整段代码）
	
//		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
//		List<Teacher> teachers = new TeacherDao().ListTeacher();
//		int pageMegNum = 1;		
//		if(request.getParameter("pageMegNum")!=null) {
//			pageMegNum = Integer.parseInt(request.getParameter("pageMegNum"));
//		}else {
//			pageMegNum = 10;
//		}
		
		
//		int pageIndex = 1;
//		int totalPage = 1;
//		if(teachers.size()%pageMegNum==0) {
//			totalPage = teachers.size()/pageMegNum;
//		}else {
//			totalPage = teachers.size()/pageMegNum+1;
//		}				
//		if(request.getParameter("pageIndex") == null){
//			request.setAttribute("pageIndex", 1);
//		}else{
//			if(request.getParameter("pageTurn")!=null) {
//				if(request.getParameter("pageTurn").equals("up")) {
//					 pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
//					if(Integer.parseInt(request.getParameter("pageIndex"))!=1) {
//						pageIndex = pageIndex-1;
//						request.setAttribute("pageIndex", pageIndex);
//					}else {
//						request.setAttribute("pageIndex", pageIndex);
//					}
//				}else {
//					pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
//					if(Integer.parseInt(request.getParameter("pageIndex"))!=totalPage) {
//						pageIndex = pageIndex+1;				
//						request.setAttribute("pageIndex", pageIndex);
//					}else {
//						request.setAttribute("pageIndex", pageIndex);
//					}
//				}				
//			}else {
//				request.setAttribute("pageIndex",1);
//			}
//		}	
//		request.setAttribute("pageMegNum", pageMegNum);
//		request.setAttribute("totalPage", totalPage);
//		 request.setAttribute("teachers", teachers);
//		request.getRequestDispatcher("listTeacher.jsp").forward(request, response);
//	}
	
%>




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; utf-8">
<link rel="stylesheet"  type="text/css"  href="./css/show.css"/>
<title>公用的分页</title>
</head>
<body >
<div class="Title">
    <h1 >公用的分页</h1>
</div>
<div class="table">
<table align='center' border='1' cellspacing='0'  width="1500">
    <tr class="one">
         
        <td >存放表格的表头</td>
        
    </tr>
     <%for(int i=(pageIndex-1)*pageMegNum;i<pageIndex*pageMegNum&&i<list.size();i++){%>
        <tr height="50" class="two">
        
             
            <td>存放读取出来的数据</td>
 
        </tr>
    <%} %>
    
</table>
</div>
                    <div class="page">
	                    <a  class="footpage" href="./listTeacher?pageIndex=<%=pageIndex%>&pageTurn=up">&emsp;上一页</a>
						<span>&emsp;第<%=pageIndex%>页&emsp;</span>			
						<a href="./listTeacher?pageIndex=<%=pageIndex%>&pageTurn=down">下一页</a>
						<span>&emsp;共<%=totalPage%>页</span>
					</div>
</body>
</html>