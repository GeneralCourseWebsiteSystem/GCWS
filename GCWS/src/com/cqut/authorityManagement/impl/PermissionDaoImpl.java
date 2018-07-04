package com.cqut.authorityManagement.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cqut.authorityManagement.dao.PermissionDao;
import com.cqut.authorityManagement.entity.ModuleRole;
import com.cqut.common.util.DBUtil;

public class PermissionDaoImpl implements PermissionDao {

	@Override
	public ArrayList<ModuleRole> findAllPermission() {
		Connection connection = DBUtil.open();
		String sql = "select * from `module_role` where is_delete = 0";
		System.out.println(sql);
		ArrayList<ModuleRole> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rSet = pstmt.executeQuery();
			while(rSet.next()) {
				ModuleRole moduleRole = new ModuleRole();
				moduleRole.setId(rSet.getInt(1));
				moduleRole.setRole_id(rSet.getInt(2));
				moduleRole.setModule_id(rSet.getInt(3));
				moduleRole.setCreate_time(rSet.getDate(4));
				moduleRole.setIs_delete(rSet.getByte(5));
				moduleRole.setRemark(rSet.getString(6));
				list.add(moduleRole);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(connection);
		}
		return list;
	}

	@Override
	public void addPermission(ModuleRole moduleRole) {
		Connection connection = DBUtil.open();
		String sql = "insert into `module_role` (role_id,module_id,create_time,is_delete) values (?,?,?,?)";
		System.out.println(sql);
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, moduleRole.getRole_id());
			pstmt.setInt(2, moduleRole.getModule_id());
			pstmt.setDate(3, moduleRole.getCreate_time());
			pstmt.setByte(4, moduleRole.getIs_delete());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(connection);
		}

	}

	@Override
	public void updatePermission(ModuleRole moduleRole) {
		Connection connection = DBUtil.open();
		String sql = "update `module_role` set module_id = '"+moduleRole.getModule_id()+"' where role_id = '"+moduleRole.getRole_id()+"' and is_delete = 0";
		System.out.println(sql);
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(connection);
		}

	}

	@Override
	public void deletePermission(int roleId) {
		Connection connection = DBUtil.open();
		String sql = "update `module_role` set is_delete = 1 where role_id = '"+roleId+"'";
		System.out.println(sql);
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public ArrayList<ModuleRole> findByRoleId(int roleId) {
		Connection connection = DBUtil.open();
		String sql = "select * from `module_role` where role_id = '"+roleId+"' and is_delete = 0";
		System.out.println(sql);
		ArrayList<ModuleRole> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rSet = pstmt.executeQuery();
			while(rSet.next()) {
				ModuleRole moduleRole = new ModuleRole();
				moduleRole.setId(rSet.getInt(1));
				moduleRole.setRole_id(rSet.getInt(2));
				moduleRole.setModule_id(rSet.getInt(3));
				moduleRole.setCreate_time(rSet.getDate(4));
				moduleRole.setIs_delete(rSet.getByte(5));
				moduleRole.setRemark(rSet.getString(6));
				list.add(moduleRole);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(connection);
		}
		return list;
	}

}
