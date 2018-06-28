package com.cqut.common.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface SqlUtilDao {
    public Boolean add(Object object) throws IllegalAccessException, SQLException;
    public Boolean update(Object object) throws SQLException, IllegalAccessException;
	public Boolean delete(int id, Object object) throws IllegalAccessException, SQLException;
	public Object getStudentById(int id);
    public ArrayList<Object> query(Object object) throws IllegalAccessException, SQLException;
}
