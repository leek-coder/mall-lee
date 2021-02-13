package com.huatech.mall.config;

import com.huatech.mall.component.RedisChannelListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * @Author leek
 * @Date 2018-07-16 上午10:55
 * @Version 1.0
 * @Description
 */
@Configuration
public class RedisListenerConfig {

    @Autowired
    private RedisConnectionFactory connectionFactory;

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(messageListenerAdapter(),channelTopic());
        return container;
    }

    @Bean
    MessageListenerAdapter messageListenerAdapter(){
        return new MessageListenerAdapter(redisChannelListener());
    }

    @Bean
    RedisChannelListener redisChannelListener(){
        return new RedisChannelListener();
    }

    @Bean
    ChannelTopic channelTopic(){
        return new ChannelTopic("cleanLocalCache");
    }
}

