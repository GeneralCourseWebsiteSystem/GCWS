package com.cqut.courseForStage.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cqut.courseForStage.entity.CourseForStage;
import com.cqut.courseForStage.impl.HomePageDaoImpl;
import com.cqut.userManagement.entity.User;

/**
 * Servlet implementation class ChooseCourse
 */
@WebServlet("/ChooseCourse")
public class ChooseCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChooseCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		if(session.getAttribute("userid") == null) {
			response.getWriter().print("<script>alert('请先登录');window.location.href='"+request.getContextPath()+"/HomePage';</script>");
//			response.sendRedirect(request.getContextPath()+"/HomePage");
		}else {
			int id = Integer.parseInt(request.getParameter("id"));
			HomePageDaoImpl homePageDaoImpl = new HomePageDaoImpl();
			CourseForStage courseForStage = homePageDaoImpl.findById(id);
			request.setAttribute("userId", session.getAttribute("userid"));
			request.setAttribute("course", courseForStage);
			request.getRequestDispatcher("../common/jsp/header.jsp").forward(request, response);
		}		
	}

}
