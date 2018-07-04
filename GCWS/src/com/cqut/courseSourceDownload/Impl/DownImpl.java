package com.cqut.courseSourceDownload.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cqut.common.util.DBUtil;
import com.cqut.courseSourceDownload.Dao.DownLoadDao;
import com.cqut.courseSourceDownload.entity.DownLoad;
import com.cqut.userManagement.entity.RoleAll;

public class DownImpl implements DownLoadDao{

	@Override
	public void insertFileName(DownLoad roleAll) {
		String sql = "INSERT INTO course_resourse VALUES (" + roleAll.getId() + "," + roleAll.getCourse_id() + ","
				+ roleAll.getResourse_type() + ",'" + roleAll.getResourse_path()+ "','" + roleAll.getResourse_name() + "',"+roleAll.getCreate_time()+","+roleAll.getIs_delete()+",'"+roleAll.getRemark()+"')";

		Connection connection = DBUtil.open();
		try {
			Statement statement = connection.createStatement();
			statement.execute(sql);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBUtil.close(connection);
		}
		
		
	}

	@Override
	public List<DownLoad> getresourseInfo() {
		String sql = "select * from course_resourse  ";
		ArrayList<DownLoad> newRoleList = new ArrayList<DownLoad>();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				Integer id = rs.getInt(1);
				Integer course_id =rs.getInt(2);
				Byte    resourse_type =rs.getByte(3);
				String resourse_path = rs.getString(4);
				String resourse_name = rs.getString(5);
				Date create_time = rs.getDate(6);
				Byte is_delete = rs.getByte(7);
				String remark = rs.getString(8);
				DownLoad newRole  = new DownLoad(id, course_id, resourse_type, resourse_path, resourse_name, create_time, is_delete, remark);
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
	
}
