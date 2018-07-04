package com.cqut.homeInformationSetting.dao;

import java.util.ArrayList;

import com.cqut.homeInformationSetting.entity.HomeProgram;

/**
 * @author lxh
 * @date 2018.7.4
 */
public interface HomeInformationDao {

	/**
	 * 获取后台管理的HomeProgram
	 * @param index
	 * @param limit
	 * @param str
	 * @return
	 */
	public ArrayList<HomeProgram> getAllHomeProgram(Integer index, Integer limit, String str);
	
	/**
	 * 获取前台展示所需的条数
	 * @param str
	 * @return
	 */
	public Integer getAllHomeProgramSize(String str);
	
	/**
	 * 获取前台展示的HomeProgram
	 * @return
	 */
	public ArrayList<HomeProgram> getShowHomeProgram();
	
	/**
	 * 更新HomeProgram
	 * @param homeProgram
	 * @return
	 */
	public Boolean updateHomeProgram(HomeProgram homeProgram);
	
	/**
	 * 根据id找到对应的HomeProgram
	 * @param id
	 * @return
	 */
	public HomeProgram getById(String id);
	
	/**
	 * 根据id删除一个首页栏目
	 * @param id
	 * @return
	 */
	public Boolean deleteById(String id);
	
	/**
	 * 添加一个首页栏目
	 * @param homeProgram
	 * @return
	 */
	public Boolean addAHomeProgram(HomeProgram homeProgram);
}
