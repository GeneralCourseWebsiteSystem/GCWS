package com.cqut.messageManagement.entity;

import java.util.Date;

public class Message {
	
    private Integer id;
    
    private String  message_content;
    
    private Integer course_id;
    
    private Integer author;
    
    private Date create_time;
    
    private Byte is_delete;
    
    private String remark;

	public Message(Integer id, String message_content, Integer course_id, Integer author, Date create_time,
			Byte is_delete, String remark) {
		super();
		this.id = id;
		this.message_content = message_content;
		this.course_id = course_id;
		this.author = author;
		this.create_time = create_time;
		this.is_delete = is_delete;
		this.remark = remark;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage_content() {
		return message_content;
	}

	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}

	public Integer getCourse_id() {
		return course_id;
	}

	public void setCourse_id(Integer course_id) {
		this.course_id = course_id;
	}

	public Integer getAuthor() {
		return author;
	}

	public void setAuthor(Integer author) {
		this.author = author;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Byte getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(Byte is_delete) {
		this.is_delete = is_delete;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
