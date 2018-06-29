package com.cqut.courseForStage.entity;

import org.omg.CORBA.BAD_POLICY_TYPE;

/**
 * 
 * @author 刘华
 * 前台首页所需的课程表
 *
 */
public class CourseForStage {
	private Integer id;
	private String course_name;
	private String create_time;
	private byte is_delete;
	private String remark;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
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
	public CourseForStage() {
		super();
	}
	public CourseForStage(Integer id, String course_name, String create_time, byte is_delete, String remark) {
		super();
		this.id = id;
		this.course_name = course_name;
		this.create_time = create_time;
		this.is_delete = is_delete;
		this.remark = remark;
	}
}
