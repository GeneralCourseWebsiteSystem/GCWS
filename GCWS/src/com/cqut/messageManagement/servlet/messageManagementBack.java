package com.cqut.messageManagement.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.cqut.messageManagement.entity.Message;
import com.cqut.messageManagement.impl.MessageDaoImpl;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * Servlet implementation class messageManagement
 */
@WebServlet("/messageManagementBack")
public class messageManagementBack extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public messageManagementBack() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//判断参数是否是删除指令
//		String receive = request.getParameter("code");
//		int authorId = Integer.parseInt(request.getParameter("name"));
		


if(request.getParameter("code")!=null){
	int authorId = Integer.parseInt(request.getParameter("name"));
	//进行切换
	int IF =Integer.parseInt(request.getParameter("IF"));

	Boolean pan = new MessageDaoImpl().is_delete(authorId,IF);
	

	
}
 
	
		
		
		//获取所有的message
		ArrayList<Message> MessageList = new MessageDaoImpl().getAllBack();
		
		
		//实现分页
		int pageMegNum = 1;		
		if(request.getParameter("pageMegNum")!=null) {
			pageMegNum = Integer.parseInt(request.getParameter("pageMegNum"));
		}else {
			pageMegNum = 4;//设置每页的显示条数
		}
		
		
		int pageIndex = 1;
		int totalPage = 1;
		if(MessageList.size()%pageMegNum==0) {
			totalPage = MessageList.size()/pageMegNum;
		}else {
			totalPage = MessageList.size()/pageMegNum+1;
		}				
		if(request.getParameter("pageIndex") == null){
			request.setAttribute("pageIndex", 1);
		}else{
			if(request.getParameter("pageTurn")!=null) {
				if(request.getParameter("pageTurn").equals("up")) {
					 pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
					if(Integer.parseInt(request.getParameter("pageIndex"))!=1) {
						pageIndex = pageIndex-1;
						request.setAttribute("pageIndex", pageIndex);
					}else {
						request.setAttribute("pageIndex", pageIndex);
					}
				}else {
					pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
					if(Integer.parseInt(request.getParameter("pageIndex"))!=totalPage) {
						pageIndex = pageIndex+1;				
						request.setAttribute("pageIndex", pageIndex);
					}else {
						request.setAttribute("pageIndex", pageIndex);
					}
				}				
			}else {
				request.setAttribute("pageIndex",1);
			}
		}	
		request.setAttribute("pageMegNum", pageMegNum);
		request.setAttribute("totalPage", totalPage);
		 request.setAttribute("MessageList", MessageList);
		
		
		
		request.getRequestDispatcher("QuestionAndAnswers/jsp/QuestionsAndAnswersBack.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
}
		
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

}
