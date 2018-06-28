package com.cqut.common.util;

import com.cqut.common.util.SqlUtilDao;
import com.cqut.common.util.DBUtil;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SqlUtilDaoImpl implements SqlUtilDao {
    @Override
    public Boolean add(Object object) throws IllegalAccessException, SQLException {
        Class clazz = object.getClass();
        //获取实体属性
        Field[] fields = clazz.getDeclaredFields();
        //申明StringBuffer的Sql
        StringBuffer sql = new StringBuffer();

        //拼接Sql
        sql.append("insert into ");
        sql.append(clazz.getSimpleName().toLowerCase());
        sql.append(" (");
        for(Field field:fields)
        {
            field.setAccessible(true);
            if("id".equals(field.getName()))
            {
                continue;
            }
            String fieldName = field.getName();
            sql.append(fieldName).append(",");
        }
        sql.deleteCharAt(sql.length()-1);

        sql.append(") values (");

        for(Field field:fields)
        {
            if("id".equals(field.getName()))
            {
                continue;
            }
            field.setAccessible(true);
            Object value = field.get(object);
            String valueString ="";
            if(value instanceof String)
            {
                valueString="'"+value+"'";
            }
            else
            {
                valueString=value.toString();
            }
            sql.append(valueString).append(",");
        }
        sql.deleteCharAt(sql.length()-1);
        sql.append(")");
        String resuleSql = sql.toString();
        new DBUtil();
        Connection connection = DBUtil.open();
        Statement statement =  connection.createStatement();
        try {
            System.out.println(sql);
            statement.execute(resuleSql);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtil.close(connection);
        }
        return true;
    }

    @Override
    public Boolean update(Object object) throws SQLException, IllegalAccessException {
        Class clazz = object.getClass();
        //获取实体属性
        Field[] fields = clazz.getDeclaredFields();
        //申明StringBuffer的Sql
        StringBuffer sql = new StringBuffer();

        //声明id
        Integer id = 0;

        //拼接Sql
        sql.append("update `");
        sql.append(clazz.getSimpleName().toLowerCase() + "`");
        sql.append(" set ");
        for(Field field:fields)
        {
            field.setAccessible(true);
            if("id".equals(field.getName()))
            {
                continue;
            }
            String fieldName = "`" + field.getName() + "`";

            field.setAccessible(true);
            Object value = field.get(object);
            String valueString ="";
            if(value instanceof String)
            {
                valueString="'"+value+"'";
            }
            else
            {
                valueString=value.toString();
            }
            sql.append(fieldName + "=" + valueString).append(",");
        }
        sql.deleteCharAt(sql.length()-1);
        sql.append(" where id = " + id.toString());
        String resuleSql = sql.toString();
        new DBUtil();
        Connection connection = DBUtil.open();
        Statement statement =  connection.createStatement();
        try {
            System.out.println(sql);
            statement.execute(resuleSql);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtil.close(connection);
        }
        return true;
    }

    @Override
    public Boolean delete(int id, Object object) throws SQLException {
        Class clazz = object.getClass();
        StringBuffer sql = new StringBuffer();

        //拼接Sql
        sql.append("delete from `");
        sql.append(clazz.getSimpleName().toLowerCase() + "`");
        sql.append(" where id = " + id);

        String resuleSql = sql.toString();
        new DBUtil();
        Connection connection = DBUtil.open();
        Statement statement =  connection.createStatement();
        try {
            System.out.println(sql);
            statement.execute(resuleSql);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtil.close(connection);
        }
        return true;
    }

    @Override
    public Object getStudentById(int id) {
        return null;
    }

    @Override
    public ArrayList<Object> query(Object object) throws SQLException {
        Class clazz = object.getClass();
        //获取实体属性
        Field[] fields = clazz.getDeclaredFields();
        //申明StringBuffer的Sql
        StringBuffer sql = new StringBuffer();

        //获取对象属性
        Class<?> attribute = object.getClass();

        //拼接Sql
        sql.append("select ");
        for(Field field:fields)
        {
            field.setAccessible(true);
            String fieldName = "`" + field.getName() + "`";
            sql.append(fieldName).append(",");
        }
        sql.deleteCharAt(sql.length()-1);

        sql.append(" from `" + clazz.getSimpleName() + "`");

        //将Sql解析为String类型
        String resuleSql = sql.toString();
        new DBUtil();
        Connection connection = DBUtil.open();
        Statement statement =  connection.createStatement();
        try {
            System.out.println(sql);
            //执行Sql语句
            ResultSet resulSet = statement.executeQuery(resuleSql);
            ArrayList<Object> list=new ArrayList();
            while(resulSet.next()) {
                Object obj = attribute.newInstance();
                for (int i = 0; i < fields.length; i++) {
                    //获取属性类型
                    String type = fields[i].getType().getSimpleName();
                    //获取属性名
                    String tName = fields[i].getName();
                    //给该属性赋值
                    if("String".equals(type)){
                        fields[i].set(obj, resulSet.getString(tName));
                    }else if("Date".equals(type)){
                        fields[i].set(obj, resulSet.getDate(tName));
                    }else if("int".equals(type)){
                        fields[i].set(obj, resulSet.getInt(tName));
                    }else if("Integer".equals(type)) {
                        fields[i].set(obj, resulSet.getInt(tName));
                    }else if("double".equals(type)){
                        fields[i].set(obj, resulSet.getDouble(tName));
                    }else if("float".equals(type)){
                        fields[i].set(obj, resulSet.getFloat(tName));
                    }
                }
                list.add(obj);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.close(connection);
        }
    }

    @Override
    public ArrayList<Object> queryByCondition(Object object, String name, Integer condition) throws SQLException {
        Class clazz = object.getClass();
        //获取实体属性
        Field[] fields = clazz.getDeclaredFields();
        //申明StringBuffer的Sql
        StringBuffer sql = new StringBuffer();

        //获取对象属性
        Class<?> attribute = object.getClass();

        //拼接Sql
        sql.append("select ");
        for(Field field:fields)
        {
            field.setAccessible(true);
            String fieldName = "`" + field.getName() + "`";
            sql.append(fieldName).append(",");
        }
        sql.deleteCharAt(sql.length()-1);

        sql.append(" from `" + clazz.getSimpleName() + "`");
        sql.append(" where " + name + " = " + condition);

        //将Sql解析为String类型
        String resuleSql = sql.toString();
        new DBUtil();
        Connection connection = DBUtil.open();
        Statement statement =  connection.createStatement();
        try {
            System.out.println(sql);
            //执行Sql语句
            ResultSet resulSet = statement.executeQuery(resuleSql);
            ArrayList<Object> list=new ArrayList();
            while(resulSet.next()) {
                Object obj = attribute.newInstance();
                for (int i = 0; i < fields.length; i++) {
                    //获取属性类型
                    String type = fields[i].getType().getSimpleName();
                    //获取属性名
                    String tName = fields[i].getName();
                    //给该属性赋值
                    if("String".equals(type)){
                        fields[i].set(obj, resulSet.getString(tName));
                    }else if("Date".equals(type)){
                        fields[i].set(obj, resulSet.getDate(tName));
                    }else if("int".equals(type)){
                        fields[i].set(obj, resulSet.getInt(tName));
                    }else if("Integer".equals(type)){
                        fields[i].set(obj, resulSet.getInt(tName));
                    }else if("double".equals(type)){
                        fields[i].set(obj, resulSet.getDouble(tName));
                    }else if("float".equals(type)){
                        fields[i].set(obj, resulSet.getFloat(tName));
                    }
                }
                list.add(obj);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.close(connection);
        }
    }

    @Override
    public Integer getLargestId(Object obj) throws SQLException {
        Class clazz = obj.getClass();
        //申明StringBuffer的Sql
        StringBuffer sql = new StringBuffer();
        //拼接Sql
        sql.append("select max(id) ");
        sql.append("from `" + clazz.getSimpleName() + "`");
        //将Sql解析为String类型
        String resuleSql = sql.toString();
        new DBUtil();
        Connection connection = DBUtil.open();
        Statement statement =  connection.createStatement();
        //执行Sql语句
        ResultSet resulSet = statement.executeQuery(resuleSql);
        resulSet.next();
        return resulSet.getInt(1);
    }

    @Override
    public Boolean countAdd(Object object, String name, Integer id) throws SQLException {
        Class clazz = object.getClass();
        //申明StringBuffer的Sql
        StringBuffer sql = new StringBuffer();
        //拼接Sql
        sql.append("update `");
        sql.append(clazz.getSimpleName().toLowerCase() + "`");
        sql.append(" set " + "`" + name + "`" + " = `" + name + "` + 1");

        //将Sql解析为String类型
        String resuleSql = sql.toString();
        new DBUtil();
        Connection connection = DBUtil.open();
        Statement statement =  connection.createStatement();
        System.out.println(sql);
        //执行Sql语句
        statement.execute(resuleSql);
        return true;
    }


}