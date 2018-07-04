package com.cqut.programManagement.dao;

import java.util.ArrayList;

import com.cqut.programManagement.entity.Program;

public interface ProgramDao {

	/**
	 * 获取所有的栏目
	 * @param index
	 * @param limit
	 * @param str
	 * @return
	 */
	public ArrayList<Program> getAllProgram(Integer index, Integer limit, String str);
	
	/**
	 * 获取没有限制的条数
	 * @return
	 */
	public ArrayList<Program> getAllProgramWithNoLimit();
	
	/**
	 * 获取栏目条数
	 * @param str
	 * @return
	 */
	public Integer getProgramSize(String str);
	
	/**
	 * 根据id找到栏目信息
	 * @param id
	 * @return
	 */
	public Program getById(String id);
	
	/**
	 * 添加一个栏目
	 * @param program
	 * @return
	 */
	public Boolean addAProgram(Program program);
	
	/**
	 * 更新一个栏目
	 * @param program
	 * @return
	 */
	public Boolean updateAProgram(Program program);
	
	/**
	 * 根据id删除一个栏目
	 * @param id
	 * @return
	 */
	public Boolean deleteById(String id);
}
