package com.cqut.courseIntroduce.entity;

import java.util.Date;

public class CourseOutlineContent {
	
	private Integer courseId;
	
	private String  courseStage;
	
	private Integer stageNo;
	
	private String  stageInfo;
	
	private Byte    isDelete;
	
	private String  remark;
	
	private Date    createTime;

	public CourseOutlineContent(Integer courseId, String courseStage, Integer stageNo, String stageInfo, Byte isDelete,
			String remark ,Date createTime) {
		super();
		this.courseId = courseId;
		this.courseStage = courseStage;
		this.stageNo = stageNo;
		this.stageInfo = stageInfo;
		this.isDelete = isDelete;
		this.remark = remark;
		this.setCreateTime(createTime);
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseStage() {
		return courseStage;
	}

	public void setCourseStage(String courseStage) {
		this.courseStage = courseStage;
	}

	public Integer getStageNo() {
		return stageNo;
	}

	public void setStageNo(Integer stageNo) {
		this.stageNo = stageNo;
	}

	public String getStageInfo() {
		return stageInfo;
	}

	public void setStageInfo(String stageInfo) {
		this.stageInfo = stageInfo;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	

}
