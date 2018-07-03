package com.cqut.courseResearchManagement.entity;

import java.sql.Date;

public class CourseResearch {
    private String articlename;
    private String articlecontent;
    private Date finishtime;
    private String name;
	public String getArticlename() {
		return articlename;
	}
	public void setArticlename(String articlename) {
		this.articlename = articlename;
	}
	public String getArticlecontent() {
		return articlecontent;
	}
	public void setArticlecontent(String articlecontent) {
		this.articlecontent = articlecontent;
	}
	public Date getFinishtime() {
		return finishtime;
	}
	public void setFinishtime(Date finishtime) {
		this.finishtime = finishtime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CourseResearch(String articlename, String articlecontent, Date finishtime, String name) {
		super();
		this.articlename = articlename;
		this.articlecontent = articlecontent;
		this.finishtime = finishtime;
		this.name = name;
	}
	public CourseResearch() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	
}
