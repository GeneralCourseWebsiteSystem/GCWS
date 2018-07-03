package com.cqut.teachTeamManagement.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.cqut.common.util.DBUtil;
import com.cqut.teachTeamManagement.dao.TeachTeamDao;
import com.cqut.teachTeamManagement.entity.Teacher;


public class TeachTeamDaoImpl implements TeachTeamDao{

	@Override
	public ArrayList<Teacher> getAll(int id) {
		String sql = "SELECT t.teacher_introduce,u.id,u.user_name  from teacher_attached t,user u where t.user_id=u.id and t.course_id="+id+" and t.is_delete=0";
		ArrayList<Teacher> userList = new ArrayList<Teacher>();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				String teacherintroduce= rs.getString(1);
				Integer userid = rs.getInt(2);
				String username = rs.getString(3);
				Teacher user = new Teacher(userid,teacherintroduce,username);
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

}
