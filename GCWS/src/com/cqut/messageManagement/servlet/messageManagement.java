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
		//获取所有的message
		ArrayList<Message> MessageList = new MessageDaoImpl().getAll();
		request.setAttribute("MessageList", MessageList);
		request.getRequestDispatcher("QuestionAndAnswers/jsp/QuestionsAndAnswers.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
//		request.setCharacterEncoding("utf-8");
//		//获取内容
//		String message_content =request.getParameter("input_content");
//		System.out.println(message_content);
//		
//		//获取用户提交时间
//		Calendar calendar=Calendar.getInstance();
//
//		
//		Integer  id =3;
//		String   message_content1="第三条";
//		Integer  course_id=1;
//		Integer  author_id=3;
//		
//		Date create_time = calendar.getTime();;
//		Byte is_delete=0;
//		String remark="暂无";
//		
//		//插一条数据到数据库中
//		Message msg = new Message(id, message_content1, course_id, author_id, create_time, is_delete, remark);
//		
//		Boolean boolean1 = new MessageDaoImpl().add_message(msg);
//		
//		System.out.println(boolean1);
//		
//		
//		request.getRequestDispatcher("QuestionAndAnswers/jsp/QuestionsAndAnswers.jsp").forward(request, response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
