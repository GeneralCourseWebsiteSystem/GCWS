package com.cqut.moduleManagement.dao;

import java.util.ArrayList;

import com.cqut.moduleManagement.entity.Module;

/**
 * @author lxh
 * 2018.7.2
 */
public interface ModuleDao {
	
	/**
	 * 获取所有模块信息
	 * @return
	 */
	public ArrayList<Module> getAllList();
	
	/**
	 * 根据id找到对应模块信息
	 * @param id
	 * @return
	 */
	public Module getById(String id);
	
	/**
	 * 无斜杠处理的模块信息
	 * @param mid
	 * @return
	 */
	public Module getByIdWithNotItalic(String mid);
	
	
	/**
	 * 添加一个新的模块
	 * @param module
	 * @return
	 */
	public Boolean addAModule(Module module);
	
	/**
	 * 更新一个模块
	 * @param module
	 * @return
	 */
	public Boolean updateAModule(Module module);
	
	/**
	 * 根据id进行删除对应模块
	 * @param id
	 * @return
	 */
	public Boolean deleteById(String id);
	
	/**
	 * 根据模块编码查找模块
	 * @param moduleCode
	 * @return
	 */
	public Module getByModuleCode(String moduleCode);
	
	/**
	 * 根据父模块找到所有的子模块
	 * @param parentCode
	 * @return
	 */
	public ArrayList<Module> getByParentCode(String parentCode);
	
	/**
	 * 获取父模块为空的模块
	 * @return
	 */
	public ArrayList<Module> getNullParentCode();

	/**
	 * 根据角色id获取所有的模块信息
	 * @param roleId
	 * @return
	 */
	public ArrayList<Module> getByRoleId(String roleId);
}
