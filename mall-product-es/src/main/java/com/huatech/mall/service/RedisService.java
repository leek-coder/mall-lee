package com.huatech.mall.service;

/**
 * @author like
 * @date 2021-01-10 9:02 下午
 **/
public interface RedisService {

	/**
	 * 保存数据
	 * @param key
	 * @param value
	 */
	void set(String key, Object value);

	/**
	 * 保存数据，并设置过期时间
	 * @param key
	 * @param value
	 * @param expires
	 */
	void set(String key, Object value, long expires);

	/**
	 * 获取缓存数据
	 * @param key
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	<T> T get(String key, Class<T> clazz);

	/**
	 * 删除缓存key
	 * @param key
	 * @return
	 */
	Boolean delete(String key);
	
	/**
	 * 加锁
	 * @param key 
	 * @param value 当前时间+超时时间
	 * @return
	 */
	Boolean lock(String key, String value);
	/**
	 * 解锁
	 * @param key
	 * @param value
	 */
	void unLock(String key, String value);
}
