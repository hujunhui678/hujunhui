package cn.atc.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateConverter {
	/**
	 * ��ȡ����ʱ��,�������
	 * 
	 * @return���س�ʱ���ʽ yyyy-MM-dd HH:mm:ss
	 */
	public static Date getSqlDate() {
		Date sqlDate = new Date(new Date().getTime());
		return sqlDate;
	}

	/**
	 * ��ȡ��ǰʱ�䣬����String
	 * 
	 * @return���س�ʱ���ʽ yyyy-MM-dd HH:mm:ss
	 */
	public static String getDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = formatter.format(new Date());
		return date;
	}

	/**
	 * ��ȡ��ǰʱ�䣬����String
	 * 
	 * @return���س�ʱ���ʽ yyyy��MM��dd�� HHʱmm��ss��
	 */
	public static String getDateByChinese() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��ss��");
		String date = formatter.format(new Date());
		return date;
	}

	/**
	 * ��ȡ����ʱ��
	 * 
	 * @throws ParseException
	 * 
	 * @return���ض�ʱ���ʽ yyyy-MM-dd
	 */
	public static Date getNowDateShort() throws ParseException {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		Date currentTime_2 = formatter.parse(dateString);
		return currentTime_2;
	}

	/**
	 * ��ȡ����ʱ��
	 * 
	 * @return ���ض�ʱ���ַ�����ʽyyyy-MM-dd
	 */
	public static String getStringDateShort() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * ��ȡʱ�� Сʱ:��;�� HH:mm:ss
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
	   * �õ�������ʱ��
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
