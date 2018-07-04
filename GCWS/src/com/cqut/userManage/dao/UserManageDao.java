package com.cqut.userManage.dao;

import java.util.ArrayList;

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
	
	/**
	 * 通过条件查找用户
	 * @param key
	 * @param value
	 * @return
	 */
	public ArrayList<User> findByCondition(String key, Object value);
	
	/**
	 * 查找所有用户
	 * @return
	 */
	public ArrayList<User> findAll();
	
	/**
	 * 获得分页所需要展示的用户
	 * @param index
	 * @param limit
	 * @param str
	 * @return
	 */	
	public ArrayList<User> findByLimit(Integer index, Integer limit, String str);
	
	/**
	 * 获得用户的个数
	 * @param str
	 * @return
	 */
	public Integer getSize(String str);
}
