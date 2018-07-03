package com.cqut.moduleManagement.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqut.moduleManagement.entity.Module;
import com.cqut.moduleManagement.impl.ModuleImpl;

/**
 * Servlet implementation class ModuleManagementUpdate
 */
@WebServlet("/ModuleManagementUpdate")
public class ModuleManagementUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModuleManagementUpdate() {
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
		String moduleId = request.getParameter("moduleId");
		ModuleImpl moduleImpl = new ModuleImpl();
		Module module = moduleImpl.getById(moduleId);
		Module parentModule = new Module();
		if(module.getParentCode().equals("/") || module.getParentCode() == null) {
			parentModule = null;
		} else {
			parentModule = moduleImpl.getByModuleCode(module.getParentCode());
		}
		
		request.setAttribute("module", module);
		request.setAttribute("parentModule", parentModule);
		request.getRequestDispatcher("/ModuleManagement/jsp/moduleManagementUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
