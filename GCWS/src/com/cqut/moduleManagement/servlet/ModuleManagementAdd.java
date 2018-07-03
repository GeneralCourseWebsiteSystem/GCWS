package com.cqut.moduleManagement.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqut.common.util.StringUtil;
import com.cqut.moduleManagement.entity.Module;
import com.cqut.moduleManagement.impl.ModuleImpl;

/**
 * Servlet implementation class ModuleManagementAdd
 */
@WebServlet("/ModuleManagementAdd")
public class ModuleManagementAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModuleManagementAdd() {
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
		Module module = new Module();
		String lastCode = "";
		String moduleName = request.getParameter("moduleName");
		String modulePath = request.getParameter("modulePath");
		String parentCode = request.getParameter("parentCode");
		if(parentCode.equals("") || parentCode == null) {
			parentCode = null;
			ArrayList<Module> list = new ModuleImpl().getNullParentCode();
			if(list.size() == 0) {
				lastCode = "00001";
			} else {
				lastCode = list.get(list.size() - 1).getModuleCode();
				lastCode = lastCode.substring(lastCode.length() - 5, lastCode.length());
				lastCode = StringUtil.addANumberByString(lastCode);
			}
		} else {
			ArrayList<Module> parentChilds = new ModuleImpl().getByParentCode(parentCode);
			if(parentChilds.size() == 0) {
				lastCode = "00001";
			} else {
				lastCode = parentChilds.get(parentChilds.size() - 1).getModuleCode();
				lastCode = lastCode.substring(lastCode.length() - 5, lastCode.length());
				lastCode = StringUtil.addANumberByString(lastCode);
			}
		}
		if(parentCode != null) {
			lastCode = String.valueOf(parentCode) + "" + lastCode;
			module.setParentCode(parentCode);
		}
		Byte isMenu = Byte.valueOf(request.getParameter("isMenu"));
		String level = request.getParameter("level");
		String remark = request.getParameter("remark");
		
		module.setModuleCode(lastCode);
		module.setModuleName(moduleName);
		module.setModulePath(modulePath);
		module.setLevel(level);
		module.setIsMenu(isMenu);
		module.setCreateTime(new Date());
		module.setIsDelete(Byte.valueOf("0"));
		module.setRemark(remark);
		ModuleImpl moduleImpl = new ModuleImpl();
		moduleImpl.addAModule(module);
		request.getRequestDispatcher("ModuleManagementServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
