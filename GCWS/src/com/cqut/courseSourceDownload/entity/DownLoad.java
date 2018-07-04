package com.cqut.courseSourceDownload.entity;

import java.util.Date;

public class DownLoad {
	
	private Integer id;
	
	private Integer course_id;
	
	private Byte    resourse_type;
	
	private String  resourse_path;
	
	private String  resourse_name;
	
	private Date    create_time;
	
	private Byte is_delete;
	
	private String 	remark;

	public DownLoad(Integer id, Integer course_id, Byte resourse_type, String resourse_path, String resourse_name,
			Date create_time, Byte is_delete, String remark) {
		super();
		this.id = id;
		this.course_id = course_id;
		this.resourse_type = resourse_type;
		this.resourse_path = resourse_path;
		this.resourse_name = resourse_name;
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

	public Integer getCourse_id() {
		return course_id;
	}

	public void setCourse_id(Integer course_id) {
		this.course_id = course_id;
	}

	public Byte getResourse_type() {
		return resourse_type;
	}

	public void setResourse_type(Byte resourse_type) {
		this.resourse_type = resourse_type;
	}

	public String getResourse_path() {
		return resourse_path;
	}

	public void setResourse_path(String resourse_path) {
		this.resourse_path = resourse_path;
	}

	public String getResourse_name() {
		return resourse_name;
	}

	public void setResourse_name(String resourse_name) {
		this.resourse_name = resourse_name;
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
