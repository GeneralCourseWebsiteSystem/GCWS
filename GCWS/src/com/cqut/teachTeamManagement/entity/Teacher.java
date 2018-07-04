package com.cqut.teachTeamManagement.entity;

import java.sql.Date;

/**
 * 
 * 教学团队所需实体
 * @author 刘华
 *
 */

public class Teacher {

	private int id;

	private int user_id;
	
	private int course_id;
	
	private String teacher_introduce;
	
	private String teacher_achieve;
	
	private Date create_time;
	
	private byte is_delete;
	
	private String remark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getTeacher_introduce() {
		return teacher_introduce;
	}

	public void setTeacher_introduce(String teacher_introduce) {
		this.teacher_introduce = teacher_introduce;
	}

	public String getTeacher_achieve() {
		return teacher_achieve;
	}

	public void setTeacher_achieve(String teacher_achieve) {
		this.teacher_achieve = teacher_achieve;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public byte getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(byte is_delete) {
		this.is_delete = is_delete;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Teacher() {
		super();
	}

	public Teacher(int id, int user_id, int course_id, String teacher_introduce, String teacher_achieve,
			Date create_time, byte is_delete, String remark) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.course_id = course_id;
		this.teacher_introduce = teacher_introduce;
		this.teacher_achieve = teacher_achieve;
		this.create_time = create_time;
		this.is_delete = is_delete;
		this.remark = remark;
	}
	
}
