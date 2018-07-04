package com.cqut.courseIntroduce.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cqut.courseIntroduce.entity.ArticleContent;
import com.cqut.courseIntroduce.entity.CourseActive;
import com.cqut.courseIntroduce.impl.CourseIntroduceDaoImpl;

/**
 * Servlet implementation class CourseIntroduceActiveContent
 */
@WebServlet("/CourseIntroduceActiveContent")
public class CourseIntroduceActiveContent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CourseIntroduceActiveContent() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Integer courseId1=1;
		
		HttpSession session = request.getSession();
		int courseId1 = (Integer) session.getAttribute("courseId");
		String title = (request.getParameter("name"));
		
		
		List<CourseActive> ActiveContent = new CourseIntroduceDaoImpl().getIntroduceActive(courseId1);
		List<ArticleContent> ArticleContent = new CourseIntroduceDaoImpl().getArticleContent(title);
		
		 request.setAttribute("ActiveContent", ActiveContent);
		 request.setAttribute("ArticleContent", ArticleContent);
		 request.getRequestDispatcher("CourseIntroduce/jsp/ActiveContent.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
