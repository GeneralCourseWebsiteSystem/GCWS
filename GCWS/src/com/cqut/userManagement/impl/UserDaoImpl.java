package com.cqut.userManagement.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cqut.userManagement.DBUtil.DBUtil;
import com.cqut.userManagement.dao.UserManagementDao;
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
			connection =DBUtil.getConnection();
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

}
