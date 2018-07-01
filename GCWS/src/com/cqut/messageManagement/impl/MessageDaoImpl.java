package com.cqut.messageManagement.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.cqut.common.util.DBUtil;
import com.cqut.messageManagement.dao.MessageManagementDao;
import com.cqut.messageManagement.entity.Message;



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
		
		
		String sql = "UPDATE Message SET is_delete = 1 WHERE author_id = " +id+ " ";
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
	public ArrayList<Message> getAllBack() {
		String sql = "SELECT * from Message ;";
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


}
