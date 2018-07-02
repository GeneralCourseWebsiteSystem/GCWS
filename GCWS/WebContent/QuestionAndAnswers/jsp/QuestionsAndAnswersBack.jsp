<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"  import ="java.text.SimpleDateFormat"%>
    
       <%@page import="com.cqut.messageManagement.entity.Message" %>
<%
	List<Message> list = (List<Message>)request.getAttribute("MessageList");	
	int pageIndex = 1;
	Integer totalPage = Integer.parseInt(request.getAttribute("totalPage")+"");
	Integer pageMegNum = Integer.parseInt(request.getAttribute("pageMegNum")+"");
	if(request.getAttribute("pageIndex")==null){
		pageIndex = 1;
	}else{
		pageIndex = Integer.parseInt(request.getAttribute("pageIndex")+"");
	}
	
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>留言管理</title>
</head>
<body>
     <table align='center' border='1' cellspacing='0'  width="1000">
    <tr class="one">
         
        <td >用户id号</td>
        <td >发表内容</td>
        <td >课程id</td>
        <td >发表时间</td>
        <td >是否展示在前台</td>
       
    </tr>
     <%for(int i=(pageIndex-1)*pageMegNum;i<pageIndex*pageMegNum&&i<list.size();i++){%>
        <tr height="50" class="two">
        
            <td class="exchange"><%=list.get(i).getAuthor()%></td>
            <td><%=list.get(i).getMessage_content()%></td>
            <td class="exchange"><%=list.get(i).getCourse_id()%></td>
            <td><%=df.format(list.get(i).getCreate_time())%></td>
            <%if (list.get(i).getIs_delete()==0) {%>
            <td>是</td>
            <%} else {%>
            <td>否</td>
            <% }%> 
            
            
            <td>
             
            <form action="addOrderItem" method="post">
          
           <a href="<%=request.getContextPath() %>/messageManagementBack?code=delete&name=<%=list.get(i).getAuthor()%>&IF=<%=list.get(i).getIs_delete() %> ">切换</a>
           
            </form>
            </td>
 
        </tr>
    <%} %>
    
</table>
<div class="page">
	                    <a  class="footpage" href="<%=request.getContextPath() %>/messageManagementBack?pageIndex=<%=pageIndex%>&pageTurn=up">&emsp;上一页</a>
						<span>&emsp;第<%=pageIndex%>页&emsp;</span>			
						<a href="<%=request.getContextPath() %>/messageManagementBack?pageIndex=<%=pageIndex%>&pageTurn=down">下一页</a>
						<span>&emsp;共<%=totalPage%>页</span>
					</div>
</body>
</html>