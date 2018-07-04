package com.cqut.programManagement.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqut.programManagement.entity.Program;
import com.cqut.programManagement.impl.ProgramImpl;

/**
 * Servlet implementation class ProgramManagementAdd
 */
@WebServlet("/ProgramManagementAdd")
public class ProgramManagementAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProgramManagementAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Program program = new Program();
		ProgramImpl programImpl = new ProgramImpl();
		String programName = request.getParameter("programName");
		String programPath = request.getParameter("programPath");
		String programCode = request.getParameter("programCode");
		String remark = request.getParameter("remark");
		program.setProgramName(programName);
		program.setProgramPath(programPath);
		program.setProgramCode(programCode);
		program.setIsDelete(Byte.valueOf("0"));
		program.setRemark(remark);
		programImpl.addAProgram(program);
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
