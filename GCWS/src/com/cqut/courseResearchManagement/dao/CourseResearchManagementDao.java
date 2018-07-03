package com.cqut.courseResearchManagement.dao;

import java.util.ArrayList;

import com.cqut.courseResearchManagement.entity.CourseResearch;
import com.cqut.userManagement.entity.User;

public interface CourseResearchManagementDao {
	
	/**
	 * 获取所有用户
	 */
	public ArrayList<CourseResearch> getAll(String id);
	
	/**
	 * 
	 * 
	 */
}
