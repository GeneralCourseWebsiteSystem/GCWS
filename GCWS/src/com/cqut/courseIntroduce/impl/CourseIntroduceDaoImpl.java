package com.cqut.courseIntroduce.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cqut.common.util.DBUtil;
import com.cqut.courseIntroduce.dao.CourseIntroduceDao;
import com.cqut.courseIntroduce.entity.ArticleContent;
import com.cqut.courseIntroduce.entity.CourseActive;
import com.cqut.courseIntroduce.entity.CourseArrangeContent;
import com.cqut.courseIntroduce.entity.CourseIntroduceContent;
import com.cqut.courseIntroduce.entity.CourseOutlineContent;

public class CourseIntroduceDaoImpl implements CourseIntroduceDao {

	@Override
	public List<CourseIntroduceContent> getIntroduceContentInfo(Integer courseId1) {
		String sql = "select * from course_introduce where course_id ="+courseId1+" ";
		
		ArrayList<CourseIntroduceContent> IntroduceContentInfo = new ArrayList<CourseIntroduceContent>();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				Integer  id = rs.getInt(1);
				Integer  courseId =rs.getInt(2);
				String   courseInfo = rs.getString(3);
				String   teachWay = rs.getString(4);
				String   misStatement = rs.getString(5);			
				Date createTime = rs.getTimestamp(6);
				Byte isDelete = rs.getByte(7);
				String remark =rs.getString(8);
				CourseIntroduceContent messageUser1 = new CourseIntroduceContent(id,courseId,courseInfo,teachWay,misStatement,createTime,isDelete,remark);
				IntroduceContentInfo.add(messageUser1);
			}
			return IntroduceContentInfo;
		} catch(Exception e) {
			e.printStackTrace();
			return IntroduceContentInfo;
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public List<CourseArrangeContent> getArrangeContent(Integer courseId1) {
        String sql = "select c.course_id ,c.arrange_path,c.create_time,c.is_delete,c.remark from course_arrange c where course_id ="+courseId1+" ";
		
		ArrayList<CourseArrangeContent> ArrangeContent = new ArrayList<CourseArrangeContent>();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				Integer  courseId = rs.getInt(1);
				String   arrangePath = rs.getString(2);			
				Date createTime = rs.getTimestamp(3);
				Byte isDelete = rs.getByte(4);
				String remark =rs.getString(5);
				CourseArrangeContent messageUser1 = new CourseArrangeContent(courseId,arrangePath,createTime,isDelete,remark);
				ArrangeContent.add(messageUser1);
			}
			return ArrangeContent;
		} catch(Exception e) {
			e.printStackTrace();
			return ArrangeContent;
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public List<CourseOutlineContent> getOutlineContent(Integer courseId1) {
		 String sql = "select c.course_id,c.course_stage,c.stage_no,c.stage_info,c.is_delete,c.remark,c.create_time from course_outline c where course_id = "+courseId1+";";
			
			ArrayList<CourseOutlineContent> OutlineContent = new ArrayList<CourseOutlineContent>();
			Connection connection = DBUtil.open();
			try{
				PreparedStatement pstm = connection.prepareStatement(sql);
				ResultSet rs = pstm.executeQuery();
				
				while(rs.next()){
					Integer  courseId = rs.getInt(1);
					String   courseStage = rs.getString(2);
					Integer  stageNo = rs.getInt(3);		
					String   stageInfo =rs.getString(4);
					Byte isDelete = rs.getByte(5);
					String remark =rs.getString(6);
					Date createTime = rs.getTimestamp(7);
					CourseOutlineContent messageUser1 = new CourseOutlineContent(courseId, courseStage, stageNo, stageInfo, isDelete, remark, createTime);
					OutlineContent.add(messageUser1);
				}
				return OutlineContent;
			} catch(Exception e) {
				e.printStackTrace();
				return OutlineContent;
			} finally {
				DBUtil.close(connection);
			}
	}

	@Override
	public List<CourseActive> getIntroduceActive(Integer courseId) {
		 String sql = "SELECT a.article_name,a.article_content,u.user_name,a.finish_time,a.create_time,a.remark  "
		 		+ "FROM article a, course_article ca, `user` u "
		 		+ "WHERE ca.article_id = a.id "
		 		+ "AND a.auther_id = u.id "
		 		+ "AND a.is_delete = 0 "
		 		+ "AND a.article_type = 1 "
		 		+ "AND ca.course_id = "+courseId+" ;";
			
			ArrayList<CourseActive> OutlineContent = new ArrayList<CourseActive>();
			Connection connection = DBUtil.open();
			try{
				PreparedStatement pstm = connection.prepareStatement(sql);
				ResultSet rs = pstm.executeQuery();
				
				while(rs.next()){
					String articleName = rs.getString(1);
					String articleContent = rs.getString(2);
					String userName = rs.getString(3);
					Date   finishTime = rs.getDate(4);	
					Date   createTime = rs.getDate(5);	
					String remark =rs.getString(6);
					
					CourseActive messageUser1 = new CourseActive(articleName, articleContent, userName, finishTime, createTime, remark);
					OutlineContent.add(messageUser1);
				}
				return OutlineContent;
			} catch(Exception e) {
				e.printStackTrace();
				return OutlineContent;
			} finally {
				DBUtil.close(connection);
			}
	}
//查询文章内容

	@Override
	public List<ArticleContent> getArticleContent(String title) {
		 String sql = "select a.article_content,a.finish_time from article a where article_name ='"+title+"';";
				
				ArrayList<ArticleContent> OutlineContent = new ArrayList<ArticleContent>();
				Connection connection = DBUtil.open();
				try{
					PreparedStatement pstm = connection.prepareStatement(sql);
					ResultSet rs = pstm.executeQuery();
					
					while(rs.next()){
						String articleContent = rs.getString(1);
						Date   createTime = rs.getDate(2);
						
						
						ArticleContent messageUser1 = new ArticleContent(articleContent,createTime);
						OutlineContent.add(messageUser1);
					}
					return OutlineContent;
				} catch(Exception e) {
					e.printStackTrace();
					return OutlineContent;
				} finally {
					DBUtil.close(connection);
				}
	}
	

}
