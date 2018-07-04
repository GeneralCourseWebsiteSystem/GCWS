package com.cqut.courseSourceDownload.Dao;

import java.util.List;

import com.cqut.courseSourceDownload.entity.DownLoad;

public interface DownLoadDao {
	
	/**
	 * 增加文件名字
	 * @param name
	 */
	public void insertFileName(DownLoad object);
	
	/**
	 * 获得所有文件资源信息
	 * @return
	 */
	public List<DownLoad> getresourseInfo();
	

}
