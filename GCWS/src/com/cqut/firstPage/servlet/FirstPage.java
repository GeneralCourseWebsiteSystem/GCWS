package com.cqut.firstPage.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cqut.courseIntroduce.entity.CourseActive;
import com.cqut.courseIntroduce.entity.CourseIntroduceContent;
import com.cqut.courseIntroduce.impl.CourseIntroduceDaoImpl;
import com.cqut.teachTeamManagement.entity.Teacher;
import com.cqut.teachTeamManagement.impl.TeachTeamDaoImpl;

/**
 * Servlet implementation class FirstPage
 */
@WebServlet("/FirstPage")
public class FirstPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstPage() {
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
		Integer courseId = Integer.parseInt(String.valueOf(session.getAttribute("courseId")));
		
		CourseIntroduceDaoImpl courseIntroduceDaoImpl = new CourseIntroduceDaoImpl();
		TeachTeamDaoImpl teachTeamDaoImpl = new TeachTeamDaoImpl();
		List<CourseIntroduceContent> courseIntroduceContents = courseIntroduceDaoImpl.getIntroduceContentInfo(courseId);
		ArrayList<Teacher> teachers = teachTeamDaoImpl.findTeacherByCourse(courseId);
		List<CourseActive> courseActives = courseIntroduceDaoImpl.getIntroduceActive(courseId);
		//课程负责人
		request.setAttribute("charge", teachers.get(0).getTeacher_introduce());
		//课程组成员
		request.setAttribute("teachers", teachers);
		//课程简介
		request.setAttribute("courseIntroduce", courseIntroduceContents.get(0).getCourseInfo());
		//课程动态
		request.setAttribute("courseActives", courseActives);
		//教学方法
		request.setAttribute("teachWay", courseIntroduceContents.get(0).getTeachWay());
		
		request.getRequestDispatcher("/FirstPage/jsp/firstPage.jsp").forward(request, response);
	}

}
