package com.cqut.roleAllocation.dao;

/**
 * 角色分配
 * @author cgx
 * @date 2018/6/29
 *
 */
public interface RoleAllocation {
	
	/**
	 * 进行角色分配(传用户id和分配的角色id)
	 */
	public boolean role_allocaion(int userId,int roleId);
	
	
	
}
