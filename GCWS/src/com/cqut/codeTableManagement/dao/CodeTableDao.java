package com.cqut.codeTableManagement.dao;

import java.util.ArrayList;

import com.cqut.codeTableManagement.entity.CodeTable;

/**
 * @author lxh
 * @date 2018.7.3
 */
public interface CodeTableDao {

	/**
	 * 获取所有的码表
	 * @return
	 */
	public ArrayList<CodeTable> getAllCodeTable();
	
	/**
	 * 根据id找到对应码表信息
	 * @param id
	 * @return
	 */
	public CodeTable getById(String id);
	
	/**
	 * 获取所有上级为null的码表值
	 * @return
	 */
	public ArrayList<CodeTable> getNullParentCode();
	
	/**
	 * 根据上级节点获取子节点码表信息
	 * @param parentCode
	 * @return
	 */
	public ArrayList<CodeTable> getByParentCode(String parentCode);
	
	/**
	 * 新增一个码表数据
	 * @return
	 */
	public Boolean addACodeTable(CodeTable codeTable);
	
	/**
	 * 更新码表信息
	 * @param codeTable
	 * @return
	 */
	public Boolean updateACodeTable(CodeTable codeTable);
	
	/**
	 * 根据id删除码表数据
	 * @param id
	 * @return
	 */
	public Boolean deleteById(String id);
	
	/**
	 * 根据编码找到对应的码表字段
	 * @param paramCode
	 * @return
	 */
	public CodeTable getByPrarmCode(String paramCode);
}
