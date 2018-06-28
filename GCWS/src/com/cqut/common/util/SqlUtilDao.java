package com.cqut.common.util;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SqlUtilDao {
    public Boolean add(Object object) throws IllegalAccessException, SQLException;
    public Boolean update(Object object) throws SQLException, IllegalAccessException;
	public Boolean delete(int id, Object object) throws IllegalAccessException, SQLException;
	public Object getStudentById(int id);
    public ArrayList<Object> query(Object object) throws IllegalAccessException, SQLException;
    public ArrayList<Object> queryByCondition(Object object, String name, Integer condition) throws IllegalAccessException, SQLException;
    public Integer getLargestId(Object obj) throws SQLException;
    public Boolean countAdd(Object obj, String name, Integer id) throws SQLException;
}
