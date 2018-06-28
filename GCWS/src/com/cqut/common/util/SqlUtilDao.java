package com.cqut.common.util;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SqlUtilDao {
	/**
	 * 根据实体属性和实体名添加记录，要求实体属性要和字段一一对应
	 * @Title: SqlUtilDao.java 
	 * @Package com.cqut.common.util 
	 * @Description: TODO()    
	 * @date 2018年6月28日 下午4:05:57 
	 * @version V1.0   
	 * @author 李红
	 */
    public Boolean add(Object object) throws IllegalAccessException, SQLException;
    
    /**
     * 根据实体属性和实体名修改记录，要求实体属性要和字段一一对应
     * @Title: SqlUtilDao.java 
     * @Package com.cqut.common.util 
     * @Description: TODO()    
     * @date 2018年6月28日 下午4:06:59 
     * @version V1.0   
     * @author 李红
     */
    public Boolean update(Object object) throws SQLException, IllegalAccessException;
    
    /**
     * 根据实体属性和实体名删除记录，要求实体属性要和字段一一对应
     * @Title: SqlUtilDao.java 
     * @Package com.cqut.common.util 
     * @Description: TODO()    
     * @date 2018年6月28日 下午4:07:15 
     * @version V1.0   
     * @author 李红
     */
	public Boolean delete(int id, Object object) throws IllegalAccessException, SQLException;
	
	/**
	 * 根据id获取一个对象，对象名为表名
	 * @Title: SqlUtilDao.java 
	 * @Package com.cqut.common.util 
	 * @Description: TODO()    
	 * @date 2018年6月28日 下午4:08:21 
	 * @version V1.0   
	 * @author 李红
	 */
	public Object getObjectById(int id);
	
	/**
	 * 根据实体查询所有对象，对象名为表名
	 * @Title: SqlUtilDao.java 
	 * @Package com.cqut.common.util 
	 * @Description: TODO()    
	 * @date 2018年6月28日 下午5:17:40 
	 * @version V1.0   
	 * @author 李红
	 */
    public ArrayList<Object> query(Object object) throws IllegalAccessException, SQLException;
    
    /**
     * 根据某种条件来查询
     * @Title: SqlUtilDao.java 
     * @Package com.cqut.common.util 
     * @Description: TODO()    
     * @date 2018年6月28日 下午5:18:33 
     * @version V1.0   
     * @author 李红
     */
    public ArrayList<Object> queryByCondition(Object object, String name, Integer condition) throws IllegalAccessException, SQLException;
    public Integer getLargestId(Object obj) throws SQLException;
    public Boolean countAdd(Object obj, String name, Integer id) throws SQLException;
}
