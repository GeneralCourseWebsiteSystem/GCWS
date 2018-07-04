package com.cqut.messageManagement.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cqut.messageManagement.entity.Message;
import com.cqut.messageManagement.entity.MessageUser;
import com.cqut.messageManagement.impl.MessageDaoImpl;

/**
 * Servlet implementation class MessageManagement
 */
@WebServlet("/MessageManagement")
public class MessageManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageManagement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		if(request.getParameter("publish")!=null) {
			
		String input_content= request.getParameter("input_content");
		
	    String message_content = input_content;
	    //session获得课程id
	    Integer course_id = 2;
	    //get  ID
	    HttpSession session = request.getSession();
	    String userName = (String) session.getAttribute("username");
	
	    Integer author =new MessageDaoImpl().getIdByName(userName);
	   
	    
	    Date create_time = new java.sql.Date(new Date().getTime()); 
	   
	    Byte is_delete = 0;
	    String remark= "新增";
	    
			Message msg = new Message(null, message_content, course_id, author, create_time, is_delete, remark);
			
			@SuppressWarnings("unused")
			Boolean IF = new MessageDaoImpl().add_message(msg);
		}

		//获取所有的message
		ArrayList<MessageUser> MessageList = new MessageDaoImpl().getAllList();
		request.setAttribute("MessageList", MessageList);
		request.getRequestDispatcher("QuestionAndAnswers/jsp/QuestionsAndAnswers.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
