package com.cqut.courseIntroduce.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cqut.courseIntroduce.entity.CourseIntroduceContent;
import com.cqut.courseIntroduce.impl.CourseIntroduceDaoImpl;

/**
 * Servlet implementation class CourseIntroduceTeachWay
 */
@WebServlet("/CourseIntroduceTeachWay")
public class CourseIntroduceTeachWay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseIntroduceTeachWay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取信息
				//int courseId1 =1;
		
		HttpSession session = request.getSession();
		int courseId1 = (Integer) session.getAttribute("courseId");
				
				List<CourseIntroduceContent> TeachWay = new CourseIntroduceDaoImpl().getIntroduceContentInfo(courseId1);
				 request.setAttribute("TeachWay", TeachWay);
				 request.getRequestDispatcher("CourseIntroduce/jsp/2.jsp").forward(request, response);
				
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
