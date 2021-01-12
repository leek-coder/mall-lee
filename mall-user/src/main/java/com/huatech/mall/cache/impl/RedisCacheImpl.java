package com.huatech.mall.cache.impl;

import com.huatech.mall.cache.ICacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author leek
 * @Date 2018-10-23 下午1:51
 * @Version 1.0
 * @Description
 */
@Service
public class RedisCacheImpl implements ICacheService {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Override
    public <T> T get(String key) {
        T value = (T) redisTemplate.opsForValue().get(key);
        return value;
    }

    @Override
    public String get(String key, ICacheService.ICallback callback) {
        String value = get(key);
        if (value == null) {
            value = callback.execute();
            set(key, value);
        }
        return value;
    }

    @Override
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void set(String key, String value, long expires) {
        redisTemplate.opsForValue().set(key, value, expires, TimeUnit.SECONDS);
    }

    @Override
    public void remove(String key) {
        redisTemplate.delete(key);
    }


    @Override
    public boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }
}
