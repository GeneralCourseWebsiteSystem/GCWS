package com.cqut.programManagement.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqut.common.util.StringUtil;
import com.cqut.common.util.SysUtil;
import com.cqut.programManagement.entity.Program;
import com.cqut.programManagement.impl.ProgramImpl;

/**
 * Servlet implementation class ProgramManagementServlet
 */
@WebServlet("/ProgramManagementServlet")
public class ProgramManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProgramManagementServlet() {
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
		Integer pageNum = 10;
		Integer curPage = 1;
		String name = request.getParameter("name");
		String scurPage = request.getParameter("curPage");
		ProgramImpl programImpl = new ProgramImpl();
		Integer totalNum = programImpl.getProgramSize(name);
		if(scurPage == null){
            curPage = 1;//从第一页开始访问
        }else{
            curPage = Integer.parseInt(scurPage);
        }
		Integer index = (curPage-1) * pageNum;
		ArrayList<Program> programList = programImpl.getAllProgram(index, pageNum, StringUtil.emptyOrNull(name));
		request.setAttribute("programList", programList);
		String html = SysUtil.createPage(totalNum, curPage, pageNum, request.getContextPath() + "/ProgramManagementServlet");
		request.setAttribute("html", html);
		request.setAttribute("name", name);
		request.getRequestDispatcher("/programManagement/jsp/programManagement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
