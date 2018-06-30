package com.cqut.messageManagement.dao;

import java.util.ArrayList;

import com.cqut.messageManagement.entity.Message;
/**
 * 
 * @author cgx
 *
 */

public interface MessageManagementDao {
	
	/**
	 * 获取所有留言
	 */
	public ArrayList<Message> getAll();
	
	/**
	 * 是否删除留言
	 * @return
	 */
	public Boolean is_delete(int id);
	
	/**
	 * 增加一条留言
	 */
	public boolean add_message(Message msg);
	
	


	
}
