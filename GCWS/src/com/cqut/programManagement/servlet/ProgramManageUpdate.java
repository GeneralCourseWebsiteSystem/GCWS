package com.cqut.programManagement.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqut.programManagement.entity.Program;
import com.cqut.programManagement.impl.ProgramImpl;

/**
 * Servlet implementation class ProgramManageUpdate
 */
@WebServlet("/ProgramManageUpdate")
public class ProgramManageUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProgramManageUpdate() {
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
		Program program = new Program();
		ProgramImpl programImpl = new ProgramImpl();
		String programId = request.getParameter("programId");
		program = programImpl.getById(programId);
		String programName = request.getParameter("programName");
		String programPath = request.getParameter("programPath");
		String programCode = request.getParameter("programCode");
		String remark = request.getParameter("remark");
		program.setProgramName(programName);
		program.setProgramPath(programPath);
		program.setProgramCode(programCode);
		program.setRemark(remark);
		programImpl.updateAProgram(program);
		request.getRequestDispatcher("ProgramManagementServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
