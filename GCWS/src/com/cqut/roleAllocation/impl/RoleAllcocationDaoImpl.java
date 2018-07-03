package com.cqut.roleAllocation.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cqut.common.util.DBUtil;
import com.cqut.userManagement.entity.RoleAll;

/**
 * 
 * @author cgx
 * @date 2018/6/29
 *
 */
public class RoleAllcocationDaoImpl {
	/**
	 * 实现角色分配
	 */
	
	public boolean role_allocaton(int userId, int roleId) {
		String sql = "UPDATE User SET role_id = " + roleId + " WHERE id = " + userId + " ";

		Connection connection = DBUtil.open();
		try {
			Statement statement = connection.createStatement();
			statement.execute(sql);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBUtil.close(connection);
		}
		return true;
	}

	/**
	 * 对角色的删除
	 */

	public boolean role_delete(int roleId) {
		String sql = "UPDATE role SET is_delete = 1 WHERE id = " + roleId + " ";

		Connection connection = DBUtil.open();
		try {
			Statement statement = connection.createStatement();
			statement.execute(sql);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBUtil.close(connection);
		}
		return true;
	}

	/**
	 * 对角色的新增
	 */

	public boolean role_add(RoleAll roleAll) {
		String sql = "INSERT INTO role VALUES (" + roleAll.getId() + ",'" + roleAll.getRoleName() + "','"
				+ roleAll.getCreateTime() + "'," + roleAll.getIsDelete() + ",'" + roleAll.getRemark() + "')";

		Connection connection = DBUtil.open();
		try {
			Statement statement = connection.createStatement();
			statement.execute(sql);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBUtil.close(connection);
		}
		return true;
	}

	/**
	 * 根据id查询该角色
	 */
	public List<RoleAll> findRoleNameById(int Id) {
		String sql = "select * from role where id= "+Id+" ";
		ArrayList<RoleAll> newRoleList = new ArrayList<RoleAll>();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				Integer id = rs.getInt(1);
				String roleName = rs.getString(2);
				Date createTime = rs.getDate(3);
				Byte isDelete = rs.getByte(4);
				String remark = rs.getString(5);
				RoleAll newRole = new RoleAll(id, roleName, createTime, isDelete, remark);
				newRoleList.add(newRole);
			}
			return newRoleList;
		} catch(Exception e) {
			e.printStackTrace();
			return newRoleList;
		} finally {
			DBUtil.close(connection);
		}

	}

	/**
	 * 对角色的修改
	 */

	public boolean role_update(Integer id,String roleName,String remark) {
		String sql = "update role set role_name = '"+roleName+"', remark='"+remark+"' where id="+id+";";

		Connection connection = DBUtil.open();
		try {
			Statement statement = connection.createStatement();
			statement.execute(sql);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBUtil.close(connection);
		}
		return true;
	}
}
