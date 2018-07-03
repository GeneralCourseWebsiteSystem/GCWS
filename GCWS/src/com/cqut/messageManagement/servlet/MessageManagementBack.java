package com.cqut.messageManagement.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqut.articleManagement.entity.ArticleCourse;
import com.cqut.articleManagement.impl.ArticleCourseImpl;
import com.cqut.common.util.StringUtil;
import com.cqut.common.util.SysUtil;
import com.cqut.messageManagement.entity.MessageUser;
import com.cqut.messageManagement.impl.MessageDaoImpl;

/**
 * Servlet implementation class MessageManagementBack
 */
@WebServlet("/MessageManagementBack")
public class MessageManagementBack extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MessageManagementBack() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 判断是否进行切换

		if (request.getParameter("code") != null) {
			int Id = Integer.parseInt(request.getParameter("name"));
			// 进行切换
			int IF = Integer.parseInt(request.getParameter("IF"));

			@SuppressWarnings("unused")
			Boolean pan = new MessageDaoImpl().is_delete(Id, IF);

		}

		Integer pageNum = 10;
		Integer curPage = 1;
		String str = request.getParameter("str");
		String scurPage = request.getParameter("curPage");
		MessageDaoImpl messageDaoImpl = new MessageDaoImpl();
		Integer totalNum = messageDaoImpl.getUserMessageSize(str);
		if(scurPage == null){
            curPage = 1;//从第一页开始访问
        }else{
            curPage = Integer.parseInt(scurPage);
        }
		Integer index = (curPage-1) * pageNum;
		ArrayList<MessageUser> MessageList = messageDaoImpl.getUserMessage(index, pageNum, StringUtil.emptyOrNull(str));
		String html = SysUtil.createPage(totalNum, curPage, pageNum, request.getContextPath() + "/MessageManagementBack");
		request.setAttribute("html", html);
		request.setAttribute("str", str);
		request.setAttribute("MessageList", MessageList);
		request.getRequestDispatcher("QuestionAndAnswers/jsp/QuestionsAndAnswersBack.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
