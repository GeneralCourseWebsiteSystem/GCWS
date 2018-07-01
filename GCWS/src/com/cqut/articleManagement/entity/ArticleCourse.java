package com.cqut.articleManagement.entity;

import java.util.Date;

/**
 * 文章课程前台展示类
 * @author lxh
 * @date 2018.6.30
 */
public class ArticleCourse {
	
	private Integer id;
	
	private String articleName;
	
	private Byte articleType;
	
	private String articleContent;
	
	/** course.id */
	private Integer courseId;
	
	/** course.name */
	private String courseName;
	
	/** user.id */
	private Integer authorId;
	
	/** user.name */
	private String authorName;
	
	private Byte checkState;
	
	private Date createTime;
	
	private Date finishTime;
	
	private Byte isDelete;
	
	private String remark;

	public ArticleCourse() {
		super();
	}

	public ArticleCourse(Integer id, String articleName, Byte articleType, String articleContent, Integer courseId,
			String courseName, Integer authorId, String authorName, Byte checkState, Date createTime, Date finishTime, Byte isDelete,
			String remark) {
		super();
		this.id = id;
		this.articleName = articleName;
		this.articleType = articleType;
		this.articleContent = articleContent;
		this.courseId = courseId;
		this.courseName = courseName;
		this.authorId = authorId;
		this.authorName = authorName;
		this.checkState = checkState;
		this.createTime = createTime;
		this.finishTime = finishTime;
		this.isDelete = isDelete;
		this.remark = remark;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public Byte getArticleType() {
		return articleType;
	}

	public void setArticleType(Byte articleType) {
		this.articleType = articleType;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Byte getCheckState() {
		return checkState;
	}

	public void setCheckState(Byte checkState) {
		this.checkState = checkState;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public Byte getIsDelete() {
		return isDelete;
	}
	
	public void setIdDelete(Byte isDelete) {
		this.isDelete = isDelete;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
