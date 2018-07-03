package com.cqut.messageManagement.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqut.messageManagement.entity.MessageUser;
import com.cqut.messageManagement.impl.MessageDaoImpl;

/**
 * Servlet implementation class MessageManagementBack
 */
@WebServlet("/MessageManagementBack")
public class MessageManagementBack extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageManagementBack() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		//判断是否进行切换

		if(request.getParameter("code")!=null){
			int Id = Integer.parseInt(request.getParameter("name"));
			//进行切换
			int IF =Integer.parseInt(request.getParameter("IF"));

			@SuppressWarnings("unused")
			Boolean pan = new MessageDaoImpl().is_delete(Id,IF);
			

			
		}
		 	
				//获取所有的message
				ArrayList<MessageUser> MessageList = new MessageDaoImpl().getUserMessage();
				
			
				//实现分页
				int pageMegNum = 1;		
				if(request.getParameter("pageMegNum")!=null) {
					pageMegNum = Integer.parseInt(request.getParameter("pageMegNum"));
				}else {
					pageMegNum = 8;//设置每页的显示条数
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
