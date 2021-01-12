package com.huatech.mall.cache;

/**
 * @Author leek
 * @Date 2018-10-23 下午1:50
 * @Version 1.0
 * @Description
 */
public interface ICacheService {
    void set(String key, String value);

    void set(String key, String value, long expires);

    <T> T get(String key);

    <T> T get(String key, ICallback callback);

    void remove(String key);


    boolean exists(String key);

    public static interface ICallback {
        <T> T execute();
    }
}
