package com.cqut.authorityManagement.dao;

import java.util.ArrayList;

import com.cqut.authorityManagement.entity.ModuleRole;

/**
 * 
 * @author 刘华
 *
 */

public interface PermissionDao {
	
	/**
	 * 查找所有角色权限
	 * @return
	 */
	public ArrayList<ModuleRole> findAllPermission();
	
	/**
	 * 分配权限
	 * @param moduleRole
	 */
	public void addPermission(ModuleRole moduleRole);
	
	/**
	 * 修改角色的权限
	 * @param moduleRole
	 */
	public void updatePermission(ModuleRole moduleRole);
	
	/**
	 * 删除角色的权限
	 * @param roleId
	 */
	public void deletePermission(int roleId);
	
	/**
	 * 通过角色id查找对应权限
	 * @param roleId
	 * @return
	 */
	public ArrayList<ModuleRole> findByRoleId(int roleId);
}
