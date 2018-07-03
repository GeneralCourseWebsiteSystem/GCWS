package com.cqut.userManage.dao;

import com.cqut.userManagement.entity.User;

/**
 * 
 * @author 刘华
 * 在user表中操作
 *
 */

public interface UserManageDao {
	/**
	 * 新增一个用户
	 */
	public void addUser(User user);
	
	/**
	 * 删除一个用户
	 */
	public void deleteUser(int id);
	
	/**
	 * 修改用户信息
	 */
	public void updateUser(User user);
	
	/**
	 * 查询一个用户的信息
	 */
	public User findById(int id);
	
}
