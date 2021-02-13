package com.huatech.mall.component;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.huatech.mall.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;


@Slf4j
@Component
public class LocalCache {

    private Cache<String, Product> localCache = null;

    @PostConstruct
    private void init(){
        localCache = CacheBuilder.newBuilder()
                //设置本地缓存容器的初始容量
                .initialCapacity(10)
                //设置本地缓存的最大容量
                .maximumSize(500)
                //设置写缓存后多少秒过期
                .expireAfterWrite(60, TimeUnit.SECONDS).build();
    }


    public void setLocalCache(String key,Product object){
        localCache.put(key,object);
    }

    public Product get(String key){
       return localCache.getIfPresent(key);
    }

}
