package com.cqut.userManagement.dao;

import java.util.ArrayList;

import com.cqut.userManagement.entity.RoleAll;
import com.cqut.userManagement.entity.User;
import com.cqut.userManagement.entity.UserRole;
import com.cqut.userManagement.entity.RoleUserLink;

/**
 * 
 * @author lxh
 * @date 2018.6.28
 *
 */
public interface UserManagementDao {
	
	/**
	 * 获取所有用户
	 */
	public ArrayList<User> getAll();
	
	/**
	 * 获取所有用户及其角色
	 * @return
	 */
	public ArrayList<UserRole> getAllUserRole();
	
	/**
	 * 获取所有的用户角色
	 */
	public ArrayList<RoleUserLink> getAllRoleA();
	
	/**
	 * 获取所有的用户角色分页展示
	 */
	public ArrayList<RoleUserLink> getAllRole(Integer index, Integer limit, String str);
	
	/**
	 * 获取模糊搜索的数量
	 * @param str
	 * @return
	 */
	public Integer getAllRoleNum(String str) ;
	
	/**
	 * 获取所有用户及其角色
	 * @return
	 */
	public ArrayList<RoleAll> getRoleAll();
	
	
	/**
	 * 进行角色分配(传用户id和分配的角色id)
	 */
	public boolean role_allocaion(int userId,int roleId);
		
	/**
	 * 获得用户信息
	 * @param myaccount
	 * @return
	 */
	public User getId(String myaccount);
	
	/**
	 * 获得用户身份
	 * @param id
	 * @return
	 */
	public RoleAll getRoleId(int id);
}
