package com.cqut.courseForStage.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cqut.common.util.DBUtil;
import com.cqut.common.util.StringUtil;
import com.cqut.courseForStage.dao.HomePageDao;
import com.cqut.courseForStage.entity.CourseForStage;

/**
 * 
 * @author 刘华
 * @date 2018.7.1
 *
 */

public class HomePageDaoImpl implements HomePageDao {
	
	@Override
	public ArrayList<CourseForStage> findAllCourse() {
		Connection connection = DBUtil.open();
		String sql = "select * from `course` where `is_delete` = 0";
		ArrayList<CourseForStage> list = new ArrayList<>();
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rSet = pstmt.executeQuery();
			while(rSet.next()) {
				CourseForStage courseForStage = new CourseForStage();
				courseForStage.setId(rSet.getInt(1));
				courseForStage.setCourse_name(rSet.getString(2));
				courseForStage.setCreate_time((java.util.Date)rSet.getDate(3));
				courseForStage.setIs_delete(rSet.getByte(4));
				courseForStage.setRemark(rSet.getString(5));
				list.add(courseForStage);
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
	public ArrayList<CourseForStage> findByLimit(Integer index, Integer limit, String str){
		Connection connection = DBUtil.open();
		String sql = "select * from `course` where is_delete = 0 and course_name like '%"+StringUtil.emptyOrNull(str)
					+"%' limit "+index+" ,"+limit+";";
		System.out.println(sql);
		ArrayList<CourseForStage> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rSet = pstmt.executeQuery();
			while(rSet.next()) {
				CourseForStage courseForStage = new CourseForStage();
				courseForStage.setId(rSet.getInt(1));
				courseForStage.setCourse_name(rSet.getString(2));
				courseForStage.setCreate_time((java.util.Date)rSet.getDate(3));
				courseForStage.setIs_delete(rSet.getByte(4));
				courseForStage.setRemark(rSet.getString(5));
				list.add(courseForStage);
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
		String sql = "select * from `course` where course_name like '%"+StringUtil.emptyOrNull(str)+"%'";
		System.out.println(sql);
		ArrayList<CourseForStage> list =new ArrayList<>();
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rSet = pstmt.executeQuery();
			while(rSet.next()) {
				CourseForStage courseForStage = new CourseForStage();
				courseForStage.setId(rSet.getInt(1));
				courseForStage.setCourse_name(rSet.getString(2));
				courseForStage.setCreate_time((java.util.Date)rSet.getDate(3));
				courseForStage.setIs_delete(rSet.getByte(4));
				courseForStage.setRemark(rSet.getString(5));
				list.add(courseForStage);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(connection);
		}
		return list.size();
	}
	
	@Override
	public CourseForStage findById(int id) {
		Connection connection = DBUtil.open();
		String sql = "select * from `course` where id = "+id+" and is_delete = 0";
		System.out.println(sql);
		CourseForStage courseForStage = new CourseForStage();
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rSet = pstmt.executeQuery();
			while(rSet.next()) {
				courseForStage.setId(rSet.getInt(1));
				courseForStage.setCourse_name(rSet.getString(2));
				courseForStage.setCreate_time((java.util.Date)rSet.getDate(3));
				courseForStage.setIs_delete(rSet.getByte(4));
				courseForStage.setRemark(rSet.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(connection);
		}
		return courseForStage;
	}
}
