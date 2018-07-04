package com.cqut.courseIntroduce.dao;

import java.util.List;

import com.cqut.courseIntroduce.entity.ArticleContent;
import com.cqut.courseIntroduce.entity.CourseActive;
import com.cqut.courseIntroduce.entity.CourseArrangeContent;
import com.cqut.courseIntroduce.entity.CourseIntroduceContent;
import com.cqut.courseIntroduce.entity.CourseOutlineContent;

public interface CourseIntroduceDao {
	/**
	 * 获取课程简介+教学方法+理念与目标
	 */
	public List<CourseIntroduceContent> getIntroduceContentInfo(Integer courseId);
	
	/**
	 * 获取课程安排内容
	 */
	public List<CourseArrangeContent> getArrangeContent(Integer courseId);
	
	/**
	 * 获取课程大纲内容
	 */
	public List<CourseOutlineContent> getOutlineContent(Integer courseId);
	
	/**
	 * 获取课程动态文章
	 */
	public List<CourseActive> getIntroduceActive(Integer courseId);
	/**
	 * 根据Id查询文章内容
	 */
	public List<ArticleContent> getArticleContent(String title);
}
