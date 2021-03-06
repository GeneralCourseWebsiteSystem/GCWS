package com.cqut.common.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author lh
 *
 */
public class DBUtil {

	//包
	private static String driver = "com.mysql.jdbc.Driver";

	//数据库位置
	private static String url = "jdbc:mysql://localhost:3306/gcws_test?Unicode\\=true&characterEncoding\\=UTF-8";

	//用户名
	private static String username = "root";

	//密码
	private static String password = "root";

	//打开连接
	public static Connection open(){
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, username,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//关闭连接
	public static void close(Connection connection){
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
