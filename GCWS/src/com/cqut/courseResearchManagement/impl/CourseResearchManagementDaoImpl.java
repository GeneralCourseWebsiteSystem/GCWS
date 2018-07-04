package com.cqut.courseResearchManagement.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.cqut.backStageManagement.dao.BackStageManagementDao;
import com.cqut.backStageManagement.entity.BackUser;
import com.cqut.common.util.DBUtil;
import com.cqut.courseResearchManagement.dao.CourseResearchManagementDao;
import com.cqut.courseResearchManagement.entity.CourseResearch;

public class CourseResearchManagementDaoImpl implements CourseResearchManagementDao{
	@Override
	public ArrayList<CourseResearch> getAll(String id) {
		String sql = "SELECT  a.article_name, a.article_content, u.user_name,a.finish_time ,a.id FROM article a, `user` u, course_article ca WHERE ca.course_id ="+id+" ANd ca.article_id = a.id AND u.id = a.auther_id AND a.is_delete = 0 AND  a.check_state = 0 AND a.article_type=0 " ;
		ArrayList<CourseResearch> userList = new ArrayList<CourseResearch>();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				String articlename = rs.getString(1);
				String articlecontent= rs.getString(2);
				String username = rs.getString(3);
				Date finishtime=rs.getDate(4);
				Integer article_id = rs.getInt(5);
				CourseResearch user = new CourseResearch(articlename,articlecontent,finishtime,username,article_id);
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
	
	//根据文章id查找内容
	public String getContentById(Integer id) {
		String sql = "select a.article_content from article a where id ="+id+" " ;
		String content = "";
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				
				content= rs.getString(1);
			
				
			}
			return content;
		} catch(Exception e) {
			e.printStackTrace();
			return content;
		} finally {
			DBUtil.close(connection);
		}
	}
	
}
