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
	
	/**
	 * 根据id删除文章信息
	 * @param id
	 * @return
	 */
	public Boolean DeleteById(String id);
	
	/**
	 * 获取未审核的文章
	 * @param index
	 * @param limit
	 * @param str
	 * @return
	 */
	public ArrayList<ArticleCourse> getUnreviewedArticle(Integer index, Integer limit, String str);
	
	/**
	 * 获取所有未审核的文章条数
	 * @return
	 */
	public Integer getUnreviewedSize(String str);
	
	/**
	 * 根据id和state改变文章的状态
	 * @param id
	 * @param checkState
	 * @return
	 */
	public Boolean changeCheckState(String id, Byte checkState);
}
