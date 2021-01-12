package com.huatech.mall.config;//package com.jrx.user.config;
//
//import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.redis.connection.RedisClusterConfiguration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.RedisPassword;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
//
//import java.time.Duration;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * ┏┓　　　┏┓
// * ┏┛┻━━━┛┻┓
// * ┃　　　　　　　┃
// * ┃　　　━　　　┃
// * ┃　┳┛　┗┳　┃
// * ┃　　　　　　　┃
// * ┃　　　┻　　　┃
// * ┃　　　　　　　┃
// * ┗━┓　　　┏━┛
// * 　　┃　　　┃神兽保佑
// * 　　┃　　　┃代码无BUG！
// * 　　┃　　　┗━━━┓
// * 　　┃　　　　　　　┣┓
// * 　　┃　　　　　　　┏┛
// * 　　┗┓┓┏━┳┓┏┛
// * 　　　┃┫┫　┃┫┫
// * 　　　┗┻┛　┗┻┛
// *
// * @author Yeoman
// * @description
// * @create 2019/11/14 下午3:29
// **/
//@Configuration
//public class LettuceManualConfig {
//    /**
//     * Redis服务器地址
//     */
//    @Value("${spring.redis.cluster.nodes}")
//    private String nodes;
//    /**
//     * Redis服务器连接密码（默认为空
//     */
//    @Value("${spring.redis.password}")
//    private String password;
//    /**
//     * 连接超时时间（毫秒）
//     */
//    @Value("${spring.redis.timeout}")
//    private Integer timeout;
//    /**
//     * 获取失败 最大重定向次数
//     */
//    @Value("${spring.redis.cluster.max-redirects}")
//    private Integer maxRedirects;
//
//    /**
//     * 连接池最大连接数（使用负值表示没有限制）
//     */
//    @Value("${spring.redis.lettuce.pool.max-active}")
//    private Integer maxTotal;
//
//    /**
//     * 连接池最大阻塞等待时间（使用负值表示没有限制）
//     */
//    @Value("${spring.redis.lettuce.pool.max-wait}")
//    private Integer maxWait;
//
//    /**
//     * 连接池中的最大空闲连接
//     */
//    @Value("${spring.redis.lettuce.pool.max-idle}")
//    private Integer maxIdle;
//
//    /**
//     * 连接池中的最小空闲连接
//     */
//    @Value("${spring.redis.lettuce.pool.min-idle}")
//    private Integer minIdle;
//
//    /**
//     * 获取缓存连接
//     *
//     * @return
//     */
//    @Bean
//    @Primary
//    public RedisConnectionFactory redisConnectionFactory() {
//        List<String> nodeList = Arrays.asList(nodes.split(",", -1));
//        //集群模式
//        RedisClusterConfiguration configuration2 = new RedisClusterConfiguration(nodeList);
//        configuration2.setPassword(RedisPassword.of(password));
//        configuration2.setMaxRedirects(maxRedirects);
//        LettuceConnectionFactory factory = new LettuceConnectionFactory(configuration2, getPoolConfig());
////        factory.setShareNativeConnection(false);//是否允许多个线程操作共用同一个缓存连接，默认true，false时每个操作都将开辟新的连接
//        return factory;
//    }
//
//    /**
//     * 获取缓存连接池
//     *
//     * @return
//     */
//    @Bean
//    public LettucePoolingClientConfiguration getPoolConfig() {
//        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
//        config.setMaxTotal(maxTotal);
//        config.setMaxWaitMillis(maxWait);
//        config.setMaxIdle(maxIdle);
//        config.setMinIdle(minIdle);
//        LettucePoolingClientConfiguration pool = LettucePoolingClientConfiguration.builder()
//                .poolConfig(config)
//                .commandTimeout(Duration.ofMillis(timeout))
//                .build();
//        return pool;
//    }
//}
