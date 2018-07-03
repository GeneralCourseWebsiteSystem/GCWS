package com.cqut.messageManagement.dao;

import java.util.ArrayList;

import com.cqut.messageManagement.entity.Message;
import com.cqut.messageManagement.entity.MessageUser;
/**
 * 
 * @author cgx
 *
 */

public interface MessageManagementDao {
	
	/**
	 * 获取所有留言前台
	 */
	public ArrayList<Message> getAll();
	
	/**
	 * 是否删除留言
	 * @return
	 */
	public Boolean is_delete(int id,int IF);
	
	/**
	 * 增加一条留言
	 */
	public boolean add_message(Message msg);
	
	/**
	 * 获取所有信息后台
	 */
	public ArrayList<MessageUser> getAllList();
	
	
	
	/**
	 * 获取留言用户信息
	 */
	public ArrayList<MessageUser> getUserMessage(Integer index, Integer limit, String str);
	
	/**
	 * 获取所有留言条数
	 * @param str
	 * @return
	 */
	public Integer getUserMessageSize(String str);
}
