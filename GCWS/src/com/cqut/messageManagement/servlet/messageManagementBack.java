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
		//获取所有的message
		ArrayList<Message> MessageList = new MessageDaoImpl().getAll();
		request.setAttribute("MessageList", MessageList);
		request.getRequestDispatcher("QuestionAndAnswers/jsp/QuestionsAndAnswers_back.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
