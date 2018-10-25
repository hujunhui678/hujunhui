package cn.atc.util;

public interface JedisClient {
	String set(String key, String value);// �洢ֵ

	String get(String key);// ȡֵ

	long hSet(String hkey, String key, String value);// �洢��ϣֵ

	String hGet(String hkey, String key);// ȡ��ϣֵ

	long incr(String key);// ������

	long expire(String key, int second);// ���øü�����Чʱ�䣬��λΪ��

	long ttl(String key);// �鿴�ü�����Чʱ��

	long del(String key);// ɾ���洢

	long hDel(String hkey, String key);// ɾ����ϣ����
}
