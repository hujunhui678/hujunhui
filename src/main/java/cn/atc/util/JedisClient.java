package cn.atc.util;

public interface JedisClient {
	String set(String key, String value);// 存储值

	String get(String key);// 取值

	long hSet(String hkey, String key, String value);// 存储哈希值

	String hGet(String hkey, String key);// 取哈希值

	long incr(String key);// 自增长

	long expire(String key, int second);// 设置该键的有效时间，单位为秒

	long ttl(String key);// 查看该键的有效时间

	long del(String key);// 删除存储

	long hDel(String hkey, String key);// 删除哈希数据
}
