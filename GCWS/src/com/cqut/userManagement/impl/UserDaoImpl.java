package com.cqut.userManagement.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.management.relation.Role;

import com.cqut.common.util.DBUtil;
import com.cqut.userManagement.dao.UserManagementDao;
import com.cqut.userManagement.entity.role;
import com.cqut.userManagement.entity.RoleAll;
import com.cqut.userManagement.entity.User;
import com.cqut.userManagement.entity.UserRole;



/**
 * 
 * @author lxh
 * @date 2018.6.28
 *
 */
public class UserDaoImpl implements UserManagementDao {

	/**
	 * @author lxh
	 * @date 2018.6.28
	 * @return
	 */
	@Override
	public ArrayList<User> getAll() {
		String sql = "SELECT * from user WHERE user.is_delete = 0;";
		ArrayList<User> userList = new ArrayList<User>();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				Integer id = rs.getInt(1);
				Integer roleId = rs.getInt(2);
				String account = rs.getString(3);
				String userName = rs.getString(4);
				String password = rs.getString(5);
				String phoneNumber = rs.getString(6);
				Byte isLock = rs.getByte(7);
				Byte isAssociates = rs.getByte(8);
				Date createTime = rs.getDate(9);
				Byte isDelete = rs.getByte(10);
				String remark = rs.getString(11);
				User user = new User(id, roleId, account, userName, password, phoneNumber, isLock, isAssociates, createTime, isDelete, remark);
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

	@Override
	public ArrayList<UserRole> getAllUserRole() {
		
		return null;
	}
	
	public User getId(String account){
		String sql = "select * from user where account="+account+"";
		Connection connection; 
		User user=null;
		
		try {
			System.out.println(sql);
			connection = DBUtil.open();
			Statement  statement =  connection.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			 while (rs.next()) {  
				 Integer id = rs.getInt(1);
					Integer roleId = rs.getInt(2);
					String Account = rs.getString(3);
					String userName = rs.getString(4);
					String password = rs.getString(5);
					String phoneNumber = rs.getString(6);
					Byte isLock = rs.getByte(7);
					Byte isAssociates = rs.getByte(8);
					Date createTime = rs.getDate(9);
					Byte isDelete = rs.getByte(10);
					String remark = rs.getString(11);
					 user = new User(id, roleId, Account, userName, password, phoneNumber, isLock, isAssociates, createTime, isDelete, remark);
			   }
			 
		     } catch (Exception e) {
				e.printStackTrace();
	         }  
		return user;
	
	}

	@Override
	public ArrayList<role> getAllRole() {
		
		String sql = "SELECT role.id,user.id ,role_name,user_name,account FROM `user` JOIN role ON `user`.role_id = role.id";
		
		ArrayList<role> roleList = new ArrayList<role>();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				Integer id = rs.getInt(1);
				
				Integer uId = rs.getInt(2);
				
				String roleName = rs.getString(3);
				
				String userName = rs.getString(4);
			
				String account = rs.getString(5);
				
				role role1 = new role(id, uId,roleName, userName, account);
				roleList.add(role1);
			}
			return roleList;
		} catch(Exception e) {
			e.printStackTrace();
			return roleList;
			
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public ArrayList<RoleAll> getRoleAll() {
	
	String sql = "SELECT * from role ";
		
		ArrayList<RoleAll> roleList = new ArrayList<RoleAll>();
		Connection connection = DBUtil.open();
		try{
			
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				int id = rs.getInt(1);
				
				String roleName = rs.getString(2);
				
				Date   createTime = rs.getDate(3);
				
				Byte isDelete = rs.getByte(4);
			
				String remark = rs.getString(5);
				RoleAll role1 = new RoleAll(id, roleName, createTime, isDelete,remark);
				roleList.add(role1);
			}
			return roleList;
		} catch(Exception e) {
			e.printStackTrace();
			return roleList;
			
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public boolean role_allocaion(int roleId, int userId) {
		String sql = "update user set role_id = "+roleId+" where id = "+userId+" ";
		Connection connection = DBUtil.open();
		try
		{
			Statement statement =  connection.createStatement();
			statement.execute(sql);
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.close(connection);
		}
		return true;
	}
	
	

}
