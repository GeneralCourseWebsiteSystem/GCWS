package com.cqut.userManagement.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.cqut.common.util.DBUtil;
import com.cqut.userManagement.entity.RoleAll;
import com.cqut.userManagement.entity.User;



/**
 * 
 * @author lxh
 * @date 2018.6.28
 *
 */
public   class UserManagementDaoImpl  {

	/**
	 * @author lxh
	 * @date 2018.6.28
	 * @return
	 *
	 */
	
	
	public ArrayList<User> getAll() {
		String sql = "SELECT * from user";
		ArrayList<User> userList = new ArrayList<User>();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				User user = new User(rs.getInt("id"), rs.getInt("role_id"), rs.getString("account"), rs.getString("user_name"), rs.getString("password"), rs.getString("phone_number"), rs.getByte("is_lock"), rs.getByte("is_associates"), rs.getDate("create_time"), rs.getByte("is_delete"),rs.getString("remark"));
				userList.add(user);
			}
			return userList;
		} catch(Exception e) {
			e.printStackTrace();
			return userList;
		} finally {
			DBUtil.close(connection);
		}
	}

	public ArrayList<User> getLoginAll() {
		String sql = "SELECT * FROM `user` WHERE is_delete = 0 AND is_lock = 0;";
		ArrayList<User> userList = new ArrayList<User>();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				User user = new User(rs.getInt("id"), rs.getInt("role_id"), rs.getString("account"), rs.getString("user_name"), rs.getString("password"), rs.getString("phone_number"), rs.getByte("is_lock"), rs.getByte("is_associates"), rs.getDate("create_time"), rs.getByte("is_delete"),rs.getString("remark"));
				userList.add(user);
			}
			return userList;
		} catch(Exception e) {
			e.printStackTrace();
			return userList;
		} finally {
			DBUtil.close(connection);
		}
	}
	
	public User getId(String myaccount){
		String sql = "select * from user where account='"+myaccount+"' and is_delete = 0 AND is_lock = 0";
		User user = new User();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				
				user = new User(rs.getInt("id"), rs.getInt("role_id"), rs.getString("account"), rs.getString("user_name"), rs.getString("password"), rs.getString("phone_number"), rs.getByte("is_lock"), rs.getByte("is_associates"), rs.getDate("create_time"), rs.getByte("is_delete"),rs.getString("remark"));
			}
			return user;
		} catch(Exception e) {
			e.printStackTrace();
			return user;
		} finally {
			DBUtil.close(connection);
		}
	}
	
	public RoleAll getRoleId(int id){
		String sql = "select * from role where id="+id+" and  is_delete = 0";
		RoleAll role = null;
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				
				role = new RoleAll(rs.getInt("id"),rs.getString("role_name"),rs.getDate("create_time"),rs.getByte("is_delete"),rs.getString("remark"));
			}
			return role;
		} catch(Exception e) {
			e.printStackTrace();
			return role;
		} finally {
			DBUtil.close(connection);
		}
	}

}
