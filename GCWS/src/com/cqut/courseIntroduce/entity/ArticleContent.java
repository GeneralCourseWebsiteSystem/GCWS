package com.cqut.courseIntroduce.entity;

import java.util.Date;

public class ArticleContent {
private String ArticleContent;
private Date   createTime;
public ArticleContent(String articleContent, Date createTime) {
	super();
	ArticleContent = articleContent;
	this.createTime = createTime;
}
public String getArticleContent() {
	return ArticleContent;
}
public void setArticleContent(String articleContent) {
	ArticleContent = articleContent;
}
public Date getCreateTime() {
	return createTime;
}
public void setCreateTime(Date createTime) {
	this.createTime = createTime;
}




}
