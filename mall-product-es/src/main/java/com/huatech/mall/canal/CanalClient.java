package com.huatech.mall.canal;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.google.common.collect.Lists;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;

/**
 * @author like
 * @date 2021-01-10 9:02 下午
 **/

//@Component
public class CanalClient implements DisposableBean{

    private CanalConnector canalConnector;

    @Bean
    public CanalConnector getCanalConnector(){
        //即使我们用的是集群，其实同时也只有一个canal能工作，只有当他挂了 才会启用其他的，所以就是一个备份
    	canalConnector = CanalConnectors.newClusterConnector(Lists.newArrayList(
           new InetSocketAddress("192.168.31.239", 11111)),
                "book","canal","canal"
           );
        canalConnector.connect();
        //指定filter，格式{database}.{table}
//        指定我们要监听的表 秒杀的订单很大
        canalConnector.subscribe("*.*");
        //如果你们要监听的表 很多，这里最好建议用多线程，每一个canal服务只处理几张表就行,
        //我给你们一个例子
        //canalConnector.subscribe("test.read_book_pd");
        //回滚寻找上次中断的为止
        canalConnector.rollback();
        return canalConnector;
    }


    @Override
    public void destroy() throws Exception {
        if(canalConnector != null){
            canalConnector.disconnect();
        }
    }
}
