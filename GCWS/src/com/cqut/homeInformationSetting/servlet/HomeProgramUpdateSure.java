package com.cqut.homeInformationSetting.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqut.homeInformationSetting.entity.HomeProgram;
import com.cqut.homeInformationSetting.impl.HomeProgramImpl;

/**
 * Servlet implementation class HomeProgramUpdateSure
 */
@WebServlet("/HomeProgramUpdateSure")
public class HomeProgramUpdateSure extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeProgramUpdateSure() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		HomeProgramImpl homeProgramImpl = new HomeProgramImpl();
		HomeProgram homeProgram = homeProgramImpl.getById(id);
		String programId = request.getParameter("programId");
		String isShow = request.getParameter("isShow");
		String showNo = request.getParameter("showNo");
		String width = request.getParameter("width");
		String height = request.getParameter("height");
		String cssName = request.getParameter("cssName");
		String remark = request.getParameter("remark");
		homeProgram.setProgramId(Integer.valueOf(programId));
		homeProgram.setIsShow(Byte.valueOf(isShow));
		homeProgram.setShowNo(Integer.valueOf(showNo));
		homeProgram.setWidth(width);
		homeProgram.setHeight(height);
		homeProgram.setCssName(cssName);
		homeProgram.setRemark(remark);
		homeProgramImpl.updateHomeProgram(homeProgram);
		request.getRequestDispatcher("HomeProgramServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
