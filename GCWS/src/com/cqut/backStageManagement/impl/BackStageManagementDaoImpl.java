package com.cqut.backStageManagement.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cqut.backStageManagement.dao.BackStageManagementDao;
import com.cqut.backStageManagement.entity.BackRole;
import com.cqut.backStageManagement.entity.BackUser;
import com.cqut.common.util.DBUtil;
import com.cqut.userManagement.entity.RoleAll;
import com.cqut.userManagement.entity.RoleUserLink;
import com.cqut.userManagement.entity.User;




/**
 * 
 * @author 
 * @date 2018.6.28
 *
 */
public class BackStageManagementDaoImpl implements BackStageManagementDao {

	/**
	 * @author 
	 * @date 2018.6.28
	 * @return
	 */
	@Override
	public ArrayList<BackUser> getAll() {
		String sql = "SELECT * from user WHERE is_delete = 0 AND is_lock = 0";
		ArrayList<BackUser> userList = new ArrayList<BackUser>();
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
				BackUser user = new BackUser(id, roleId, account, userName, password, phoneNumber, isLock, isAssociates, createTime, isDelete, remark);
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
	public BackUser getId(String myaccount){
		String sql = "select * from user where account='"+myaccount+"' and is_delete = 0 AND is_lock = 0";
		BackUser user = new BackUser();
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
			    user = new BackUser(id, roleId, account, userName, password, phoneNumber, isLock, isAssociates, createTime, isDelete, remark);
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
	public RoleUserLink getUserRole(int userid){
		String sql = "SELECT role.id, `user`.id, role.role_name, `user`"
				+ ".user_name, `user`.account FROM `user`, role WHERE "
				+ "`user`.role_id = role.id AND `user`.is_delete = 0 AND "
				+ "`user`.id = '"+ userid +"';";
		RoleUserLink role = new RoleUserLink();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				Integer roleId = rs.getInt(1);
				Integer userId = rs.getInt(2);
				String roleName = rs.getString(3);
				String userName = rs.getString(4);
				String account = rs.getString(5);
				role = new RoleUserLink(roleId, userId, roleName, userName, account);
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
