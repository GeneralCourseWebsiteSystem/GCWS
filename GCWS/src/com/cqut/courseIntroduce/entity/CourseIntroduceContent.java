package com.cqut.courseIntroduce.entity;

import java.util.Date;

public class CourseIntroduceContent {
	private Integer id;
	
	private Integer courseId;
	
	private String  courseInfo;
	
	private String  teachWay;
	
	private String misStatement;
	
	private Date   createTime;
	
	private Byte   isDelete;
	
	private String remark;

	public CourseIntroduceContent(Integer id, Integer courseId, String courseInfo, String teachWay, String misStatement,
			Date createTime, Byte isDelete, String remark) {
		super();
		this.id = id;
		this.courseId = courseId;
		this.courseInfo = courseInfo;
		this.teachWay = teachWay;
		this.misStatement = misStatement;
		this.createTime = createTime;
		this.isDelete = isDelete;
		this.remark = remark;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseInfo() {
		return courseInfo;
	}

	public void setCourseInfo(String courseInfo) {
		this.courseInfo = courseInfo;
	}

	public String getTeachWay() {
		return teachWay;
	}

	public void setTeachWay(String teachWay) {
		this.teachWay = teachWay;
	}

	public String getMisStatement() {
		return misStatement;
	}

	public void setMisStatement(String misStatement) {
		this.misStatement = misStatement;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	

}
