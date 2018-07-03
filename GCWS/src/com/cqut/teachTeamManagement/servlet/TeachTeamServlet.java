package com.cqut.teachTeamManagement.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cqut.teachTeamManagement.entity.Teacher;
import com.cqut.teachTeamManagement.impl.TeachTeamDaoImpl;

/**
 * Servlet implementation class TeachTeamServlet
 */
@WebServlet("/TeachTeamServlet")
public class TeachTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeachTeamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=gb2312");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String courseid = request.getParameter("id");
		int id=Integer.parseInt(courseid);
		
		TeachTeamDaoImpl teachTeamDao=new TeachTeamDaoImpl();
		ArrayList<Teacher> tlist=teachTeamDao.getAll(id);
		
		session.setAttribute("tlist", tlist); 
		response.sendRedirect("TeachTeam/jsp/teachTeam.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
