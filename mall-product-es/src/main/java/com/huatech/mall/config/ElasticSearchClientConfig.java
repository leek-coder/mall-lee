package com.huatech.mall.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author like
 * @date 2021-01-10 9:02 下午
 **/
@Configuration
public class ElasticSearchClientConfig {

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        //配置es地址和端口，这里只是配置了一台es服务器
        RestHighLevelClient client =
                new RestHighLevelClient(RestClient.builder(new HttpHost("192.168.2.251", 19200, "http")));
        return client;
    }
}