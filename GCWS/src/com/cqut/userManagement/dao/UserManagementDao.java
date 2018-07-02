package com.cqut.userManagement.dao;

import java.util.ArrayList;

import com.cqut.userManagement.entity.RoleAll;
import com.cqut.userManagement.entity.User;
import com.cqut.userManagement.entity.UserRole;
import com.cqut.userManagement.entity.role;

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
	public ArrayList<role> getAllRole();
	
	/**
	 * 获取所有用户及其角色
	 * @return
	 */
	public ArrayList<RoleAll> getRoleAll();
	
	
	/**
	 * 进行角色分配(传用户id和分配的角色id)
	 */
	public boolean role_allocaion(int userId,int roleId);
	
	
}
