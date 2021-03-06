package cn.atc.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateConverter {
	/**
	 * 获取现在时间,这个好用
	 * 
	 * @return返回长时间格式 yyyy-MM-dd HH:mm:ss
	 */
	public static Date getSqlDate() {
		Date sqlDate = new Date(new Date().getTime());
		return sqlDate;
	}

	/**
	 * 获取当前时间，返回String
	 * 
	 * @return返回长时间格式 yyyy-MM-dd HH:mm:ss
	 */
	public static String getDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = formatter.format(new Date());
		return date;
	}

	/**
	 * 获取当前时间，返回String
	 * 
	 * @return返回长时间格式 yyyy年MM月dd日 HH时mm分ss秒
	 */
	public static String getDateByChinese() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		String date = formatter.format(new Date());
		return date;
	}

	/**
	 * 获取现在时间
	 * 
	 * @throws ParseException
	 * 
	 * @return返回短时间格式 yyyy-MM-dd
	 */
	public static Date getNowDateShort() throws ParseException {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		Date currentTime_2 = formatter.parse(dateString);
		return currentTime_2;
	}

	/**
	 * 获取现在时间
	 * 
	 * @return 返回短时间字符串格式yyyy-MM-dd
	 */
	public static String getStringDateShort() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 获取时间 小时:分;秒 HH:mm:ss
	 * 
	 * @return
	 */
	public static String getTimeShort() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		Date currentTime = new Date();
		String dateString = formatter.format(currentTime);
		return dateString;
	}
	
	 /**
	   * 得到几天后的时间
	   * @param d
	   * @param day
	   * @return
	   */
	  public static Date getDateAfter(Date d,int day){
	   Calendar now =Calendar.getInstance();
	   now.setTime(d);
	   now.set(Calendar.DATE,now.get(Calendar.DATE)+day);
	   return now.getTime();
	  }
}
