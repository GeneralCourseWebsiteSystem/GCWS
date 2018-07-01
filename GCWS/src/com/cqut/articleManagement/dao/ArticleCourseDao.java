package com.cqut.articleManagement.dao;

import java.util.ArrayList;

import com.cqut.articleManagement.entity.ArticleCourse;

/**
 * @author lxh
 * @date 2018.7.1
 *
 */
public interface ArticleCourseDao {
	
	/**
	 * 获取前台展示所有的文章信息
	 * @param index
	 * @param limit
	 * @return
	 */
	public ArrayList<ArticleCourse> getList(Integer index, Integer limit, String str);
	
	/**
	 * 获取所有文章条数
	 * @param str
	 * @return
	 */
	public Integer getAllSize(String str);
	
	/**
	 * 根据id查找文章信息
	 * @param id
	 * @return
	 */
	public ArticleCourse getById(String id);
	
	public Boolean DeleteById(String id);
}
