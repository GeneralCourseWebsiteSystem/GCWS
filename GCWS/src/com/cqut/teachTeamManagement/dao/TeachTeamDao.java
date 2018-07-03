package com.cqut.teachTeamManagement.dao;

import java.util.ArrayList;

import com.cqut.teachTeamManagement.entity.Teacher;



/**
 * 
 * @author 
 * @date 2018.6.28
 *
 */
public interface TeachTeamDao {
	
	/**
	 * 获取所有用户
	 */
	public ArrayList<Teacher> getAll(int id);
	
	/**
	 * 获取所有用户及其角色
	 * @return
	 */
	
}
