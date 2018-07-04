package com.cqut.teachTeamManagement.dao;

import java.util.ArrayList;

import com.cqut.teachTeamManagement.entity.Teacher;

/**
 * 
 * @author 刘华
 *
 */

public interface TeachTeamDao {
	
	/**
	 * 通过课程查找教师
	 * @param CourseId
	 * @return
	 */
	public ArrayList<Teacher> findTeacherByCourse(int courseId);
}
