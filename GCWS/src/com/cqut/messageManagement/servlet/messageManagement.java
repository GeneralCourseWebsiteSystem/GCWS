package com.cqut.messageManagement.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
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

/**
 * Servlet implementation class messageManagement
 */
@WebServlet("/messageManagement")
public class messageManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public messageManagement() {
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
		request.setCharacterEncoding("utf-8");
		if(request.getParameter("publish")!=null) {
			System.out.println("123456");
		String input_content= request.getParameter("input_content");
		Integer id=13;
	    String message_content = input_content;
	    Integer course_id = 2;
	    Integer author = 2;
	   
	    Date create_time = new java.sql.Date(new Date().getTime()); 
	   
	    Byte is_delete = 0;
	    String remark= "新增";
	    
			Message msg = new Message(id, message_content, course_id, author, create_time, is_delete, remark);
			
			Boolean IF = new MessageDaoImpl().add_message(msg);
			
			
			
			
		}
		
		
		//获取所有的message
		ArrayList<Message> MessageList = new MessageDaoImpl().getAll();
		request.setAttribute("MessageList", MessageList);
		request.getRequestDispatcher("QuestionAndAnswers/jsp/QuestionsAndAnswers.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
