package com.cqut.userManagement.dao;

import java.util.ArrayList;

import com.cqut.userManagement.entity.User;
import com.cqut.userManagement.entity.UserRole;

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
}
