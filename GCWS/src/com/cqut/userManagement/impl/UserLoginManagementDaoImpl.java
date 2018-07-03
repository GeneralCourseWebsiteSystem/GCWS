package com.cqut.userManagement.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.cqut.common.util.DBUtil;
import com.cqut.userManagement.dao.UserManagementDao;
import com.cqut.userManagement.entity.RoleAll;
import com.cqut.userManagement.entity.RoleUserLink;
import com.cqut.userManagement.entity.User;
import com.cqut.userManagement.entity.UserRole;



/**
 * 
 * @author lxh
 * @date 2018.6.28
 *
 */
public   class UserLoginManagementDaoImpl implements UserManagementDao {

	/**
	 * @author 
	 * @date 2018.6.28
	 * @return
	 *
	 */
	
	@Override
	public ArrayList<User> getAll() {
		String sql = "SELECT * FROM `user` WHERE is_delete = 0;";
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
				String atName = rs.getString(7);
				Byte isLock = rs.getByte(8);
				Byte isAssociates = rs.getByte(9);
				Date createTime = rs.getTimestamp(10);
				Byte isDelete = rs.getByte(11);
				String remark = rs.getString(12);
				User user = new User(id, roleId, account, userName, password, phoneNumber,atName, isLock, isAssociates, createTime, isDelete, remark);
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
	public User getId(String myaccount){
		String sql = "select * from user where account='"+myaccount+"' and is_delete = 0;";
		User user = new User();
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
				String atName = rs.getString(7);
				Byte isLock = rs.getByte(8);
				Byte isAssociates = rs.getByte(9);
				Date createTime = rs.getDate(10);
				Byte isDelete = rs.getByte(11);
				String remark = rs.getString(12);
			    user = new User(id, roleId, account, userName, password, phoneNumber,atName, isLock, isAssociates, createTime, isDelete, remark);
			}
			return user;
		} catch(Exception e) {
			e.printStackTrace();
			return user;
		} finally {
			DBUtil.close(connection);
		}
	}
	
	@Override
	public RoleAll getRoleId(int userid){
		String sql = "select * from role where id="+userid+" and  is_delete = 0";
		RoleAll role = null;
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
                Integer id = rs.getInt(1);
				String rolename = rs.getString(2);
				Date createtime=rs.getDate(3);
				Byte isdelete = rs.getByte(4);
				String remark = rs.getString(5);
				role = new RoleAll(id,rolename,createtime,isdelete,remark);
			}
			return role;
		} catch(Exception e) {
			e.printStackTrace();
			return role;
		} finally {
			DBUtil.close(connection);
		}
	}
	
   public ArrayList<UserRole> getAllUserRole(){
	   return null;
   }
	
	public ArrayList<RoleUserLink> getAllRole(){
		return null;
	}
	
	public ArrayList<RoleAll> getRoleAll(){
		return null;
	}
	
	public boolean role_allocaion(int userId,int roleId){
		return false;
	}

	@Override
	public ArrayList<RoleUserLink> getAllRoleA() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<RoleUserLink> getAllRole(Integer index, Integer limit, String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllRoleNum(String str) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
