package com.cqut.courseResearchManagement.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cqut.courseResearchManagement.impl.CourseResearchManagementDaoImpl;

/**
 * Servlet implementation class ArticleShow
 */
@WebServlet("/ArticleShow")
public class ArticleShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleShow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=gb2312");
		 request.setCharacterEncoding("utf-8");
		 HttpSession session = request.getSession();
		 Integer article_id=Integer.parseInt(request.getParameter("show"));
		 String content = new CourseResearchManagementDaoImpl().getContentById(article_id);
		 String title =request.getParameter("title");
		 String courseid =request.getParameter("courseid");
		 
		 session.setAttribute("content", content); 
		 session.setAttribute("title", title);
		 session.setAttribute("courseid", courseid);
		 response.sendRedirect("CourseResearch/jsp/articleShow.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
