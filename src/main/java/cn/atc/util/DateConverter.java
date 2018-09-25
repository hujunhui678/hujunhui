package cn.atc.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
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
	 * ��ȡ����ʱ��
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

}
