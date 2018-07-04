package com.cqut.teachTeamManagement.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cqut.common.util.DBUtil;
import com.cqut.teachTeamManagement.dao.TeachTeamDao;
import com.cqut.teachTeamManagement.entity.Teacher;

/**
 * 
 * @author 刘华
 *
 */

public class TeachTeamDaoImpl implements TeachTeamDao {

	@Override
	public ArrayList<Teacher> findTeacherByCourse(int courseId) {
		Connection connection = DBUtil.open();
		String sql = "select * from `teacher_attached` where course_id = '"+courseId+"' and is_delete = 0";
		System.out.println(sql);
		ArrayList<Teacher> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rSet = pstmt.executeQuery();
			while(rSet.next()) {
				Teacher teacher = new Teacher();
				teacher.setId(rSet.getInt(1));
				teacher.setUser_id(rSet.getInt(2));
				teacher.setCourse_id(rSet.getInt(3));
				teacher.setTeacher_introduce(rSet.getString(4));
				teacher.setTeacher_achieve(rSet.getString(5));
				teacher.setCreate_time(rSet.getDate(6));
				teacher.setIs_delete(rSet.getByte(7));
				teacher.setRemark(rSet.getString(8));
				list.add(teacher);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(connection);
		}
		return list;
	}

}
