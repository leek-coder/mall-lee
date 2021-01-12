package com.huatech.mall.util;
/**
 * @author like
 * @date 2021-01-10 9:02 下午
 **/
public class RedisKey {

	/**
	 * 用户信息key
	 */
	private static String KEY_USER = "search-mgr_user_%d";

	private static String cache_key = "search_mgr_%s:%s";

	public static String cache_keys(String biz, String key) {
		return String.format(cache_key, biz, key);
	}

	public static String key_user(Integer userId) {
		return String.format(KEY_USER, userId);
	}
}
