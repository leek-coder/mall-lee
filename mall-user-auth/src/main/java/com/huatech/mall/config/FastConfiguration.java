package com.huatech.mall.config;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;


@Configuration
@Import(FdfsClientConfig.class)//注解，就可以拥有带有连接池的FastDFS Java客户端了
/**
 * 解决JMX重复注册bean的问题
 */
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
/**
 * @author leek
 * @Date 2019-11-09 下午4:39
 */
public class FastConfiguration {
}
