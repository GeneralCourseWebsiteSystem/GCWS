package com.cqut.roleAllocation.dao;

import java.util.List;

import com.cqut.userManagement.entity.RoleAll;

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
	
	/**
	 * 对角色的删除
	 */
	public boolean role_delete(int roleId);
	
	/**
	 * 对角色的新增
	 */
	public boolean role_add(RoleAll roleAll);
	/**
	 * 根据id查询该角色
	 */
	public List<RoleAll> findRoleNameById(int Id);
	/**
	 * 对角色的修改
	 */
    public boolean role_update(Integer id,String  roleName,String remark);
    /**
     * 
     */
	
	
	
	
}
