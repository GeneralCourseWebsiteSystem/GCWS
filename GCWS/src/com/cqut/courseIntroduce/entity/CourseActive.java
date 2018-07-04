package com.cqut.courseIntroduce.entity;

import java.util.Date;

public class CourseActive {
   //三表（用户+文章+课程文章）
	
	
	
	private String   articleName;
	
	private String   articleContent;
	
	private String   userName;
	
	private Date     finishTime;
	
	private Date     createTime;

	private String   remark;

	public CourseActive(String articleName, String articleContent, String userName, Date finishTime, Date createTime,
			String remark) {
		super();
		this.articleName = articleName;
		this.articleContent = articleContent;
		this.userName = userName;
		this.finishTime = finishTime;
		this.createTime = createTime;
		this.remark = remark;
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	
	

}
