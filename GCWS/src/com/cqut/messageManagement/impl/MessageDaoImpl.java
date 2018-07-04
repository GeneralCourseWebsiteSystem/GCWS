package com.cqut.messageManagement.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.cqut.common.util.DBUtil;
import com.cqut.common.util.StringUtil;
import com.cqut.messageManagement.dao.MessageManagementDao;
import com.cqut.messageManagement.entity.Message;
import com.cqut.messageManagement.entity.MessageUser;



/**
 * 
 * @author cgx
 * @date 2018.6.29
 *
 */
public class MessageDaoImpl implements MessageManagementDao {

	/**
	 * @author cgx
	 * @date 2018.6.29
	 * @return
	 */
	@Override
	public ArrayList<Message> getAll() {
		String sql = "SELECT * from Message WHERE is_delete = 0;";
		ArrayList<Message> MessageList = new ArrayList<Message>();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				Integer id = rs.getInt(1);
				String message_content = rs.getString(2);
				Integer course_id = rs.getInt(3);
				Integer author = rs.getInt(4);
				Date create_time = rs.getDate(5);
				Byte is_delete = rs.getByte(6);
				String remark = rs.getString(7);
				
				Message message = new Message(id, message_content, course_id, author, create_time, is_delete,remark);
				MessageList.add(message);
			}
			return MessageList;
		} catch(Exception e) {
			e.printStackTrace();
			return MessageList;
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public Boolean is_delete(int id,int IF) {
		
		
		String sql = "UPDATE Message SET is_delete = 1 WHERE id = " +id+ " ";
		if(IF==1) {
			sql ="UPDATE Message SET is_delete = 0 WHERE author_id = " +id+ " ";
		}
		Connection connection = DBUtil.open();
		try
		{
			Statement statement =  connection.createStatement();
			statement.execute(sql);
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			DBUtil.close(connection);
		}
		return true;
	}

	@Override
	public boolean add_message(Message msg) {
		String sql = "INSERT INTO Message VALUES ("+msg.getId()+",'"+msg.getMessage_content()+"',"+msg.getCourse_id()+","+msg.getAuthor()+",'"+msg.getCreate_time()+"',"+msg.getIs_delete()+",'"+msg.getRemark()+"')";
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

	@Override
	public ArrayList<MessageUser> getAllList() {
		String sql = "SELECT m.id, m.author_id, u.user_name, m.message_content, c.course_name,"
				+ " m.create_time, m.is_delete FROM message m, `user` u, course c "
				+ "WHERE m.author_id = u.id AND c.id = m.course_id AND m.is_delete = 0;";
		
		ArrayList<MessageUser> MessageUserList = new ArrayList<MessageUser>();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				Integer  msgId = rs.getInt(1);
				Integer    authorId =rs.getInt(2);
				String userName = rs.getString(3);
				String messageContent = rs.getString(4);
				String courseName = rs.getString(5);			
				Date createTime = rs.getTimestamp(6);
				Byte isDelete = rs.getByte(7);
				MessageUser messageUser1 = new MessageUser(msgId,authorId,userName, messageContent, courseName, createTime, isDelete);
				MessageUserList.add(messageUser1);
			}
			return MessageUserList;
		} catch(Exception e) {
			e.printStackTrace();
			return MessageUserList;
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public ArrayList<MessageUser> getUserMessage(Integer index, Integer limit, String str) {
		String sql = "SELECT m.id, m.author_id, u.user_name, m.message_content, c.course_name,"
				+ " m.create_time, m.is_delete FROM message m, `user` u, course c "
				+ "WHERE m.author_id = u.id AND c.id = m.course_id AND m.is_delete = 0 "
				+ "AND m.message_content LIKE '%" + StringUtil.emptyOrNull(str) + "%' LIMIT "+ index +", " + limit +";";
		
		ArrayList<MessageUser> MessageUserList = new ArrayList<MessageUser>();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				Integer  msgId = rs.getInt(1);
				Integer    authorId =rs.getInt(2);
				String userName = rs.getString(3);
				String messageContent = rs.getString(4);
				String courseName = rs.getString(5);			
				Date createTime = rs.getTimestamp(6);
				Byte isDelete = rs.getByte(7);
				MessageUser messageUser1 = new MessageUser(msgId,authorId,userName, messageContent, courseName, createTime, isDelete);
				MessageUserList.add(messageUser1);
			}
			return MessageUserList;
		} catch(Exception e) {
			e.printStackTrace();
			return MessageUserList;
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public Integer getUserMessageSize(String str) {
		String sql = "SELECT m.id, m.author_id, u.user_name, m.message_content, c.course_name,"
				+ " m.create_time, m.is_delete FROM message m, `user` u, course c "
				+ "WHERE m.author_id = u.id AND c.id = m.course_id AND m.is_delete = 0 "
				+ "AND m.message_content LIKE '%" + StringUtil.emptyOrNull(str) + "%';";
		
		ArrayList<MessageUser> MessageUserList = new ArrayList<MessageUser>();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				Integer  msgId = rs.getInt(1);
				Integer    authorId =rs.getInt(2);
				String userName = rs.getString(3);
				String messageContent = rs.getString(4);
				String courseName = rs.getString(5);			
				Date createTime = rs.getTimestamp(6);
				Byte isDelete = rs.getByte(7);
				MessageUser messageUser1 = new MessageUser(msgId,authorId,userName, messageContent, courseName, createTime, isDelete);
				MessageUserList.add(messageUser1);
			}
			return MessageUserList.size();
		} catch(Exception e) {
			e.printStackTrace();
			return MessageUserList.size();
		} finally {
			DBUtil.close(connection);
		}
	}
	//根据用户名获取authorId
	public Integer getIdByName(String UserName) {
		Integer User_id =1;
		String sql = "select u.id from user u where u.user_name ='"+UserName+"'";
		
		
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			
			while(rs.next()){
				  User_id = rs.getInt(1);
				
				
				
			}
			
			return User_id;
		} catch(Exception e) {
			e.printStackTrace();
			return User_id;
		} finally {
			DBUtil.close(connection);
		}
	}
	


}
