package com.cqut.courseForStage.dao;

import java.util.ArrayList;

import com.cqut.courseForStage.entity.CourseForStage;

/**
 * 
 * @author 刘华
 *
 */
public interface HomePageDao {
	
	/**
	 * 获取首页展示的所有课程名
	 * @return
	 */
	public ArrayList<CourseForStage> findAllCourse();
	
	/**
	 * 获取分页展示的所有课程
	 * @param index
	 * @param limit
	 * @param str
	 * @return
	 */
	public ArrayList<CourseForStage> findByLimit(Integer index, Integer limit, String str);
	
	/**
	 * 获得课程的个数
	 * @param str
	 * @return
	 */
	public Integer getSize(String str);
	
	/**
	 * 通过id查找课程
	 * @param id
	 * @return
	 */
	public CourseForStage findById(int id);
}
