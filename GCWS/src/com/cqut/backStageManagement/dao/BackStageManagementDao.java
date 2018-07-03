package com.cqut.backStageManagement.dao;

import java.util.ArrayList;

import com.cqut.backStageManagement.entity.BackRole;
import com.cqut.backStageManagement.entity.BackUser;
import com.cqut.userManagement.entity.RoleUserLink;



/**
 * 
 * @author mlh
 * @date 2018.6.28
 *
 */
public interface BackStageManagementDao {
	
	/**
	 * 获取所有用户
	 */
	public ArrayList<BackUser> getAll();
	
	/**
	 * 获得用户身份
	 */
	public RoleUserLink getUserRole(int id);
	/**
	 * 获得用户信息
	 */
	
	public BackUser getId(String myaccount);
	
	
}
