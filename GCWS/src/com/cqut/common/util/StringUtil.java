package com.cqut.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author lxh
 *
 */
public class StringUtil {
	
	private static Random random = new Random();
	private static final int DEFAULT_MAX_NUM = 100;
	
	/**
	 * 将java.util.Date转换为java.sql.Date
	 * @param utilDate
	 * @return
	 */
	public static java.sql.Date changeToSqlDate(java.util.Date utilDate){
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}
	
	/**
	 * 将java.util.Date转换为java.sql.Timestamp
	 * @param utilDate
	 * @return
	 */
	public static java.sql.Timestamp changeToTimestampDate(java.util.Date utilDate){
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
		java.util.Date date;
		try {
			date = sdf.parse(StringUtil.dateFormat(utilDate));
			java.sql.Timestamp ts= new java.sql.Timestamp(date.getTime());
			return ts;
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	/**
	 * 将java.sql.Date转换为java.util.Date
	 * @param sqlDate
	 * @return
	 */
	public static java.util.Date changeToUtilDate(java.sql.Date sqlDate){
		java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
		return utilDate;
	}
	
	
	/**
	 * 将string类型的转换为date类型
	 * @param str
	 * @return
	 */
	public static Date stringToDate(String str){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 将date转换为yyyy-mm-dd格式的字符串
	 * @param date
	 * @return
	 */
	public static String dateFormat(Date date){
		SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = format0.format(date.getTime());
        return time;
	}
	
	/**
	 * 生成当前纳秒值的字符
	 */
	public static String createTimestamp() {
	    return String.valueOf(System.nanoTime())
	    		.concat(String.valueOf(random.nextInt(DEFAULT_MAX_NUM)));
	}
	
	/**
	 * 判断是否为null 是则返回空字符串
	 * @param str
	 * @return
	 */
	public static String emptyOrNull(String str) {
		if (str == null) {
			return "";
		} else {
			return str;
		}
	}
	
	/**
	 * 判断是否为null 是则返回/
	 * @param str
	 * @return
	 */
	public static String emptyGetItalic(String str) {
		if (str == null) {
			return "/";
		} else {
			return str;
		}
	}
	
	/**
	 * 获取code增加一的字符串
	 * @param code
	 * @return
	 */
	public static String addANumberByString(String code) {
		 String result = "";
	     // 保留code的位数
	     result = String.format("%0" + code.length() + "d", Integer.parseInt(code) + 1);

	     return result;
	}
}
