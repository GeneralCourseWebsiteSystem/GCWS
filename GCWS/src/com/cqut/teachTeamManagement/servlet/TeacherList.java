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
import com.cqut.teachTeamManagement.entity.TeacherInfor;
import com.cqut.teachTeamManagement.impl.TeachTeamDaoImpl;
import com.cqut.userManage.impl.UserManageDaoImpl;
import com.cqut.userManagement.entity.User;

/**
 * Servlet implementation class TeacherList
 */
@WebServlet("/TeacherList")
public class TeacherList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherList() {
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
		
		TeachTeamDaoImpl teachTeamDaoImpl = new TeachTeamDaoImpl();
		UserManageDaoImpl userManageDaoImpl = new UserManageDaoImpl();
		ArrayList<TeacherInfor> teacherInfors = new ArrayList<>();
		ArrayList<Teacher> teachers = teachTeamDaoImpl.findTeacherByCourse(courseId);
		for(Teacher teacher: teachers) {
			User user = userManageDaoImpl.findById(teacher.getId());
			TeacherInfor teacherInfor = new TeacherInfor();
			teacherInfor.setTeacherName(user.getUserName());
			teacherInfor.setTeacherPhone(user.getPhoneNumber());
			teacherInfor.setTeacherIntroduce(teacher.getTeacher_introduce());
			teacherInfor.setTeacherAchievement(teacher.getTeacher_achieve());
			teacherInfors.add(teacherInfor);
		}
		request.setAttribute("teacherInfors", teacherInfors);
		request.getRequestDispatcher("/teachTeam/jsp/teachTeam.jsp").forward(request, response);
	}

}
