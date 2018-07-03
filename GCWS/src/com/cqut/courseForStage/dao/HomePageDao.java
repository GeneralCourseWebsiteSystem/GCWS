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
}
