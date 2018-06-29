package com.cqut.roleAllocation.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cqut.common.util.DBUtil;

/**
 * 
 * @author cgx
 * @date  2018/6/29
 *
 */
public class RoleAllcocationDaoImpl {
	/**
	 * 实现角色分配
	 */
   public boolean role_allocaton(int userId,int roleId) {
	   String sql = "UPDATE User SET role_id = " +roleId+ " WHERE id = "+userId+" ";
	   
	   Connection connection = DBUtil.open();
		try
		{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			DBUtil.close(connection);
		}
		return true;
   }
}
