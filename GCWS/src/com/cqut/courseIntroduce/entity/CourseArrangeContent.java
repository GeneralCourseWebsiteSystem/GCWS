package com.cqut.courseIntroduce.entity;

import java.util.Date;

public class CourseArrangeContent {
	
	private Integer courseId;
	
	private String  arrangePath;
	
	private Date    createTime;
	
	private Byte    isDelete;
	
	private String  remark;

	public CourseArrangeContent(Integer courseId, String arrangePath, Date createTime, Byte isDelete,String remark) {
		super();
		this.courseId = courseId;
		this.arrangePath = arrangePath;
		this.createTime = createTime;
		this.isDelete = isDelete;
		this.setRemark(remark);
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getArrangePath() {
		return arrangePath;
	}

	public void setArrangePath(String arrangePath) {
		this.arrangePath = arrangePath;
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
