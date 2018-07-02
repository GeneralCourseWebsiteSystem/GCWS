package com.cqut.articleManagement.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.cqut.articleManagement.dao.ArticleCourseDao;
import com.cqut.articleManagement.entity.ArticleCourse;
import com.cqut.common.util.DBUtil;
import com.cqut.common.util.StringUtil;

public class ArticleCourseImpl implements ArticleCourseDao {

	@Override
	public ArrayList<ArticleCourse> getList(Integer index, Integer limit, String str) {
		String sql = "SELECT a.id, a.article_name, a.article_type, a.article_content, c.id courseId,"
				+ " c.course_name, u.id userId, u.user_name, a.check_state, a.create_time, a.finish_time,"
				+ " a.is_delete, a.remark FROM article a, `user` u, course c, course_article ca WHERE c.id = ca.course_id AND "
				+ "ca.article_id = a.id AND u.id = a.auther_id AND a.is_delete = 0 AND a.article_name LIKE '%" 
				+ StringUtil.emptyOrNull(str) + "%' LIMIT " + index + "," + limit + ";";
		ArrayList<ArticleCourse> acList = new ArrayList<ArticleCourse>();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				Integer id = rs.getInt(1);
				String articleName = rs.getString(2);
				Byte articleType = rs.getByte(3);
				String articleContent = rs.getString(4);
				Integer courseId = rs.getInt(5);
				String courseName = rs.getString(6);
				Integer userId = rs.getInt(7);
				String userName = rs.getString(8);
				Byte checkState = rs.getByte(9);
				Date createTime = rs.getTimestamp(10);
				Date finishTime = rs.getTimestamp(11);
				Byte isDelete = rs.getByte(12);
				String remark = rs.getString(13);
				ArticleCourse ac = new ArticleCourse(id, articleName, articleType, articleContent, courseId, courseName, userId, userName, checkState, createTime, finishTime , isDelete, remark);
				acList.add(ac);
			}
			return acList;
		} catch(Exception e) {
			e.printStackTrace();
			return acList;
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public Integer getAllSize(String str) {
		String sql = "SELECT a.id, a.article_name, a.article_type, a.article_content, c.id courseId,"
				+ " c.course_name, u.id userId, u.user_name, a.check_state, a.create_time, a.finish_time,"
				+ " a.is_delete, a.remark FROM article a, `user` u, course c, course_article ca WHERE c.id = ca.course_id AND "
				+ "ca.article_id = a.id AND u.id = a.auther_id AND a.is_delete = 0 AND a.article_name LIKE '%" 
				+ StringUtil.emptyOrNull(str) + "%';";
		ArrayList<ArticleCourse> acList = new ArrayList<ArticleCourse>();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				Integer id = rs.getInt(1);
				String articleName = rs.getString(2);
				Byte articleType = rs.getByte(3);
				String articleContent = rs.getString(4);
				Integer courseId = rs.getInt(5);
				String courseName = rs.getString(6);
				Integer userId = rs.getInt(7);
				String userName = rs.getString(8);
				Byte checkState = rs.getByte(9);
				Date createTime = rs.getTimestamp(10);
				Date finishTime = rs.getTimestamp(11);
				Byte isDelete = rs.getByte(12);
				String remark = rs.getString(13);
				ArticleCourse ac = new ArticleCourse(id, articleName, articleType, articleContent, courseId, courseName, userId, userName, checkState, createTime, finishTime , isDelete, remark);
				acList.add(ac);
			}
			return acList.size();
		} catch(Exception e) {
			e.printStackTrace();
			return acList.size();
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public ArticleCourse getById(String acid) {
		String sql = "SELECT a.id, a.article_name, a.article_type, a.article_content, c.id courseId,"
				+ " c.course_name, u.id userId, u.user_name, a.check_state, a.create_time, a.finish_time,"
				+ " a.is_delete, a.remark FROM article a, `user` u, course c, course_article ca WHERE c.id = ca.course_id AND "
				+ "ca.article_id = a.id AND u.id = a.auther_id AND a.is_delete = 0 AND a.id = "+ acid +";";
		ArrayList<ArticleCourse> acList = new ArrayList<ArticleCourse>();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				Integer id = rs.getInt(1);
				String articleName = rs.getString(2);
				Byte articleType = rs.getByte(3);
				String articleContent = rs.getString(4);
				Integer courseId = rs.getInt(5);
				String courseName = rs.getString(6);
				Integer userId = rs.getInt(7);
				String userName = rs.getString(8);
				Byte checkState = rs.getByte(9);
				Date createTime = rs.getTimestamp(10);
				Date finishTime = rs.getTimestamp(11);
				Byte isDelete = rs.getByte(12);
				String remark = rs.getString(13);
				ArticleCourse ac = new ArticleCourse(id, articleName, articleType, articleContent, courseId, courseName, userId, userName, checkState, createTime, finishTime , isDelete, remark);
				acList.add(ac);
			}
			return acList.get(0);
		} catch(Exception e) {
			e.printStackTrace();
			return acList.get(0);
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public Boolean DeleteById(String id) {
		String sql = "UPDATE article SET article.is_delete = 1 AND id = ?;";
		if(this.isTeacherExist(id) == false){
			return false;
		}
		Connection connection = DBUtil.open();
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.close(connection);
		}
		
	}
	
	public boolean isTeacherExist(String id) {
		String sql = "SELECT * FROM article WHERE id = ?;";
		Connection connection = DBUtil.open();
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, id);
			ResultSet rs = pstm.executeQuery();
			int count = 0;
			while(rs.next()){
				count++;
			}
			if(count != 0){
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.close(connection);
		}
	}

}
