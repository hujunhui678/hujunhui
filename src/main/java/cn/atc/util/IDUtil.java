package cn.atc.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class IDUtil {
	/**
	 * ͼƬ������
	 */
	public static String genImageName() {
		// ȡ��ǰʱ��ĳ�����ֵ��������
		long millis = System.currentTimeMillis();
		// long millis = System.nanoTime();
		// ������λ�����
		Random random = new Random();
		int end3 = random.nextInt(999);
		// ���������λǰ�油0
		String str = millis + String.format("%03d", end3);
		return str;
	}

	/**
	 * id����
	 */
	public static long genItemId() {
		// ȡ��ǰʱ��ĳ�����ֵ��������
		long millis = System.currentTimeMillis();
		// long millis = System.nanoTime();
		// ������λ�����
		Random random = new Random();
		int end2 = random.nextInt(99);
		// ���������λǰ�油0
		String str = millis + String.format("%02d", end2);
		long id = new Long(str);
		return id;
	}

	public static long getId() {
		// ��λ�������ȡ
		Integer numFour = (int) (Math.random() * 8999) + 1000;
		// �̶���ʽʱ���ȡ
		SimpleDateFormat sdfId = new SimpleDateFormat("yyyyMMddHHmm");
		String time = sdfId.format(new Date());
		// �������/���ⵥ��
		long storeId = Long.parseLong(numFour.toString() + time);
		return storeId;
	}
	
}
