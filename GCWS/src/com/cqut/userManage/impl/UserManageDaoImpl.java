package com.cqut.userManage.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cqut.common.util.DBUtil;
import com.cqut.common.util.StringUtil;
import com.cqut.userManage.dao.UserManageDao;
import com.cqut.userManagement.entity.User;


/**
 * 
 * @author 刘华
 *
 */

public class UserManageDaoImpl implements UserManageDao {

	@Override
	public void addUser(User user) {
		Connection connection = DBUtil.open();
		String sql = "insert into `user` (role_id,account,user_name,password,phone_number,is_lock,is_associates,create_time,is_delete,remark) "
				+ " values(?,?,?,?,?,?,?,?,?,?)";
		System.out.println(sql);

		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
//			pstmt.setInt(1, user.getId());
			pstmt.setInt(1, user.getRoleId());
			pstmt.setString(2, user.getAccount());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getPhoneNumber());
//			pstmt.setString(7, user.getAtName());
			pstmt.setByte(6, user.getIsLock());
			pstmt.setByte(7, user.getIsAssociates());
			pstmt.setDate(8, StringUtil.changeToSqlDate(user.getCreateTime()));
			pstmt.setByte(9, user.getIsDelete());
			pstmt.setString(10, user.getRemark());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(connection);
		}

	}

	@Override
	public void deleteUser(int id) {
		Connection connection = DBUtil.open();
		String sql = "delete from `user` where id = "+id;
		System.out.println(sql);
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(connection);
		}

	}

	@Override
	public void updateUser(User user) {
		Connection connection = DBUtil.open();
		String sql = "update `user` set role_id = '"+user.getRoleId()
		+"', `account` = '"+user.getAccount()
		+"', `user_name` = '"+user.getUserName()
		+"', `password` = '"+user.getPassword()
		+"', phone_number = '"+user.getPhoneNumber()
		+"', is_lock = '"+user.getIsLock()
		+"', is_associates = '"+user.getIsAssociates()
		+"', create_time = '"+(java.sql.Date)user.getCreateTime()
		+"', is_delete = '"+user.getIsDelete()
		+"', remark = '"+user.getRemark()+"' where id = '"+user.getId()+"'";
		System.out.println(sql);
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(connection);
		}

	}

	@Override
	public User findById(int id) {
		Connection connection = DBUtil.open();
		String sql = "select * from `user` where id = "+id;
		System.out.println(sql);
		User user = new User();
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rSet = pstmt.executeQuery();
			while(rSet.next()) {
				user.setId(rSet.getInt(1));
				user.setRoleId(rSet.getInt(2));
				user.setAccount(rSet.getString(3));
				user.setUserName(rSet.getString(4));
				user.setPassword(rSet.getString(5));
				user.setPhoneNumber(rSet.getString(6));
				user.setAtName(rSet.getString(7));
				user.setIsLock(rSet.getByte(8));
				user.setIsAssociates(rSet.getByte(9));
				user.setCreateTime((java.util.Date)rSet.getDate(10));
				user.setIsDelete(rSet.getByte(11));
				user.setRemark(rSet.getString(12));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(connection);
		}
		return user;
	}
	
	@Override
	public ArrayList<User> findByCondition(String key, Object value){
		Connection connection = DBUtil.open();
		String sql = "select * from `user` where "+key+" = "+value;
		System.out.println(sql);
		ArrayList<User> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rSet = pstmt.executeQuery();
			while(rSet.next()) {
				User user = new User();
				user.setId(rSet.getInt(1));
				user.setRoleId(rSet.getInt(2));
				user.setAccount(rSet.getString(3));
				user.setUserName(rSet.getString(4));
				user.setPassword(rSet.getString(5));
				user.setPhoneNumber(rSet.getString(6));
				user.setAtName(rSet.getString(7));
				user.setIsLock(rSet.getByte(8));
				user.setIsAssociates(rSet.getByte(9));
				user.setCreateTime((java.util.Date)rSet.getDate(10));
				user.setIsDelete(rSet.getByte(11));
				user.setRemark(rSet.getString(12));
				list.add(user);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(connection);
		}
		return list;
	}
	
	@Override
	public ArrayList<User> findAll(){
		Connection connection = DBUtil.open();
		String sql = "select * from `user`";
		System.err.println(sql);
		ArrayList<User> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rSet = pstmt.executeQuery();
			while(rSet.next()) {
				User user = new User();
				user.setId(rSet.getInt(1));
				user.setRoleId(rSet.getInt(2));
				user.setAccount(rSet.getString(3));
				user.setUserName(rSet.getString(4));
				user.setPassword(rSet.getString(5));
				user.setPhoneNumber(rSet.getString(6));
				user.setAtName(rSet.getString(7));
				user.setIsLock(rSet.getByte(8));
				user.setIsAssociates(rSet.getByte(9));
				user.setCreateTime((java.util.Date)rSet.getDate(10));
				user.setIsDelete(rSet.getByte(11));
				user.setRemark(rSet.getString(12));
				list.add(user);
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
	public ArrayList<User> findByLimit(Integer index, Integer limit, String str){
		Connection connection = DBUtil.open();
		String sql = "select * from `user` where is_delete = 0 and user_name like '%"+StringUtil.emptyOrNull(str)
					+"%' limit "+index+" ,"+limit+";";
		System.out.println(sql);
		ArrayList<User> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rSet = pstmt.executeQuery();
			while(rSet.next()) {
				User user = new User();
				user.setId(rSet.getInt(1));
				user.setRoleId(rSet.getInt(2));
				user.setAccount(rSet.getString(3));
				user.setUserName(rSet.getString(4));
				user.setPassword(rSet.getString(5));
				user.setPhoneNumber(rSet.getString(6));
				user.setAtName(rSet.getString(7));
				user.setIsLock(rSet.getByte(8));
				user.setIsAssociates(rSet.getByte(9));
				user.setCreateTime((java.util.Date)rSet.getDate(10));
				user.setIsDelete(rSet.getByte(11));
				user.setRemark(rSet.getString(12));
				list.add(user);
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
	public Integer getSize(String str) {
		Connection connection = DBUtil.open();
		String sql = "select * from `user` where user_name like '%"+StringUtil.emptyOrNull(str)+"%'";
		System.out.println(sql);
		ArrayList<User> list =new ArrayList<>();
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rSet = pstmt.executeQuery();
			while(rSet.next()) {
				User user = new User();
				user.setId(rSet.getInt(1));
				user.setRoleId(rSet.getInt(2));
				user.setAccount(rSet.getString(3));
				user.setUserName(rSet.getString(4));
				user.setPassword(rSet.getString(5));
				user.setPhoneNumber(rSet.getString(6));
				user.setAtName(rSet.getString(7));
				user.setIsLock(rSet.getByte(8));
				user.setIsAssociates(rSet.getByte(9));
				user.setCreateTime((java.util.Date)rSet.getDate(10));
				user.setIsDelete(rSet.getByte(11));
				user.setRemark(rSet.getString(12));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(connection);
		}
		return list.size();
	}
}
