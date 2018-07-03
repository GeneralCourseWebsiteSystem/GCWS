package com.cqut.messageManagement.entity;

import java.util.Date;

public class MessageUser {
  private   Integer msgId;
	
  private   Integer authorId;	
	
  private	String userName;
  
  private   String messageContent;
  
  private   String courseName;
  
  private   Date   createTime;
  
  private   Byte   isDelete;

public MessageUser(Integer msgId,Integer authorId, String userName, String messageContent, String courseName, Date createTime, Byte isDelete) {
	super();
	this.msgId = msgId;
	this.authorId = authorId;
	this.userName = userName;
	this.messageContent = messageContent;
	this.courseName = courseName;
	this.createTime = createTime;
	this.isDelete = isDelete;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getMessageContent() {
	return messageContent;
}

public void setMessageContent(String messageContent) {
	this.messageContent = messageContent;
}

public String getCourseName() {
	return courseName;
}

public void setCourseName(String courseName) {
	this.courseName = courseName;
}

public Date getCreateTime() {
	return createTime;
}

public void setCreateTime(Date createTime) {
	this.createTime = createTime;
}

public Byte getIsDelete() {
	return isDelete;
}

public void setIsDelete(Byte isDelete) {
	this.isDelete = isDelete;
}

public Integer getAuthorId() {
	return authorId;
}

public void setAuthorId(Integer authorId) {
	this.authorId = authorId;
}

public Integer getMsgId() {
	return msgId;
}

public void setMsgId(Integer msgId) {
	this.msgId = msgId;
}

}
