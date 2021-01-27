package com.huatech.mall.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Author leek
 * @Date 2019-11-09 下午4:38
 * @Version 1.0
 * @Description
 */
@Configuration
@Data
public class FastConfig {

    @Value("${fdfs.resHost}")
    private String resHost;

    @Value("${fdfs.storagePort}")
    private String storagePort;


}
