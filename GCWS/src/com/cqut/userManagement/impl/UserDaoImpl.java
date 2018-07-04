package com.cqut.userManagement.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import com.cqut.common.util.DBUtil;
import com.cqut.common.util.StringUtil;
import com.cqut.userManagement.dao.UserManagementDao;
import com.cqut.userManagement.entity.RoleUserLink;
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
				String atName = rs.getString(7);
				Byte isLock = rs.getByte(8);
				Byte isAssociates = rs.getByte(9);
				Date createTime = rs.getDate(10);
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
					String atName = rs.getString(7);
					Byte isLock = rs.getByte(8);
					Byte isAssociates = rs.getByte(9);
					Date createTime = rs.getDate(10);
					Byte isDelete = rs.getByte(11);
					String remark = rs.getString(12);
					user = new User(id, roleId, Account, userName, password, phoneNumber, atName, isLock, isAssociates, createTime, isDelete, remark);
			   }
			 
		     } catch (Exception e) {
				e.printStackTrace();
	         }  
		return user;
	
	}
	

	@Override
	public ArrayList<RoleUserLink> getAllRole(Integer index, Integer limit, String str) {
		
		String sql = "SELECT r.id, u.id, r.role_name, u.user_name, u.account "
				+ "FROM `user` u, role r WHERE u.role_id = r.id AND u.is_delete = 0 "
				+ "AND r.role_name LIKE '%"+StringUtil.emptyOrNull(str)+"%' LIMIT "+index+", "+limit+";";
		
		ArrayList<RoleUserLink> roleList = new ArrayList<RoleUserLink>();
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
				
				RoleUserLink role1 = new RoleUserLink(id, uId,roleName, userName, account);
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
	public Integer getAllRoleNum(String str) {
String sql = "SELECT r.id, u.id, r.role_name, u.user_name, u.account "
		+ "FROM `user` u, role r WHERE u.role_id = r.id AND u.is_delete = 0 "
		+ "AND r.role_name LIKE '%"+StringUtil.emptyOrNull(str)+"%' ;";
		
		ArrayList<RoleUserLink> roleList = new ArrayList<RoleUserLink>();
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
				
				RoleUserLink role1 = new RoleUserLink(id, uId,roleName, userName, account);
				roleList.add(role1);
			}
			return roleList.size();
		} catch(Exception e) {
			e.printStackTrace();
			return roleList.size();
			
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public ArrayList<RoleAll> getRoleAll() {
	
	String sql = "SELECT * from role where is_delete = 0";
		
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
		String sql = "update user set role_id ="+roleId+" where id ="+userId+" ";
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

	public ArrayList<RoleUserLink> getAllRoleA() {
     String sql = "SELECT role.id,user.id ,role_name,user_name,account FROM `user` JOIN role ON `user`.role_id = role.id  ";
		
		ArrayList<RoleUserLink> roleList = new ArrayList<RoleUserLink>();
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
				
				RoleUserLink role1 = new RoleUserLink(id, uId,roleName, userName, account);
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

	/**
	 * 
	 * @author 刘华
	 * 通过角色id获得角色的是所有信息
	 */
	@Override
	public RoleAll getRoleId(int id) {
		Connection connection  = DBUtil.open();
		String sql = "select * from `role` where id = "+id;
		System.out.println(sql);
		RoleAll role = new RoleAll();
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rSet = pstmt.executeQuery();
			while(rSet.next()) {
				role.setId(rSet.getInt(1));
				role.setRoleName(rSet.getString(2));
				role.setCreateTime((java.util.Date)rSet.getDate(3));
				role.setIsDelete(rSet.getByte(4));
				role.setRemark(rSet.getString(5));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(connection);
		}
		return role;
	}
	
	//角色管理查询分页查询所有的角色
	public ArrayList<RoleAll> getRoleAllManage(Integer index, Integer limit, String str) {
		
		String sql = "SELECT r.id,r.role_name,r.create_time,r.is_delete,r.remark " + 
				"from role r " + 
				"where is_delete = 0				 " + 
				"AND r.role_name " + 
				"LIKE '%"+StringUtil.emptyOrNull(str)+"%'" +
				"LIMIT 0, 10;";
			
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

    //分页模糊搜索数量
public Integer getRoleAllManage(String str) {
		
		String sql = "SELECT * from role where is_delete = 0"+
		"AND role.role_name LIKE '%"+StringUtil.emptyOrNull(str)+"%' ";
			
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
				return roleList.size();
			} catch(Exception e) {
				e.printStackTrace();
				return roleList.size();
				
			} finally {
				DBUtil.close(connection);
			}
		}

	
	

}
