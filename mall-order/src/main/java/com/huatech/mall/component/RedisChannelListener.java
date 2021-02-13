package com.huatech.mall.component;

import com.huatech.mall.constants.ApiBaseConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.lang.Nullable;

import java.nio.charset.StandardCharsets;

/**
 * @author like
 * @date 2020-06-22 11:54 下午
 **/
@Slf4j
public class RedisChannelListener implements MessageListener {

    @Autowired
    private LocalCache localCache;

    @Override
    public void onMessage(Message message, @Nullable byte[] pattern) {
        log.info("sub message :) channel[cleanLocalCache] !");
        String productId = new String(message.getBody(), StandardCharsets.UTF_8);
        localCache.remove(ApiBaseConstants.RedisKeyPrefix.MIAOSHA_STOCK_CACHE_PREFIX + productId);
    }

}
