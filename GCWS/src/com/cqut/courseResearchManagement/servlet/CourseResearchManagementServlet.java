package com.cqut.courseResearchManagement.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cqut.courseResearchManagement.entity.CourseResearch;
import com.cqut.courseResearchManagement.impl.CourseResearchManagementDaoImpl;

/**
 * Servlet implementation class CourseResearchManagementServlet
 */
@WebServlet("/CourseResearchManagementServlet")
public class CourseResearchManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseResearchManagementServlet() {
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
		 String courseid =request.getParameter("id");
		 System.out.print(courseid);
		 CourseResearchManagementDaoImpl courseDao=new CourseResearchManagementDaoImpl();
		 ArrayList<CourseResearch> clist=courseDao.getAll(courseid);
	//	 System.out.print(clist.get(0).getName()+"\n");
		 session.setAttribute("clist", clist); 
		 session.setAttribute("courseid",courseid); 
		// response.sendRedirect("CourseResearch/jsp/courseResearch.jsp");
		 request.getRequestDispatcher("CourseResearch/jsp/courseResearch.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
