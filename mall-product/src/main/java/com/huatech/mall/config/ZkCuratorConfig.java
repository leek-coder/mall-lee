package com.huatech.mall.config;

import com.huatech.mall.component.ZkLock;
import com.huatech.mall.component.ZkLockImpl;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author like
 * @date 2020-06-22 3:09 下午
 **/
@Configuration
public class ZkCuratorConfig {
    @Value("${zk.curator.retryCount}")
    private int retryCount;
    @Value("${zk.curator.elapsedTimeMs}")
    private int elapsedTimeMs;
    @Value("${zk.curator.connectUrl}")
    private String connectUrl;
    @Value("${zk.curator.sessionTimeOutMs}")
    private int sessionTimeOutMs;
    @Value("${zk.curator.connectionTimeOutMs}")
    private int connectionTimeOutMs;

    /**
     * 初始化客户端
     * @return
     */
    @Bean(initMethod = "start",destroyMethod = "close")
    public CuratorFramework curatorFramework(){
        return CuratorFrameworkFactory.newClient(
                connectUrl
                , sessionTimeOutMs
                , connectionTimeOutMs
                , new RetryNTimes(retryCount,elapsedTimeMs));
    }

    @Bean
    public ZkLock zkLock(){
        return new ZkLockImpl();
    }
}
