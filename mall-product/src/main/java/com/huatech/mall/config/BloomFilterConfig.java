package com.huatech.mall.config;

import com.google.common.base.Charsets;
import com.google.common.hash.Funnel;
import com.huatech.mall.component.BloomRedisService;
import com.huatech.mall.constants.ApiBaseConstants;
import com.huatech.mall.service.IProductService;
import com.huatech.mall.utils.BloomFilterHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 *
 * @author like
 * @date 2020-06-22 3:34 下午
 **/
@Slf4j
@Configuration
public class BloomFilterConfig implements InitializingBean {

    @Autowired
    private IProductService productService;

    @Autowired
    private RedisTemplate redisTemplate;


    @Bean
    public BloomFilterHelper<String> initBloomFilterHelper() {
        return new BloomFilterHelper<>((Funnel<String>) (from, into) -> into.putString(from, Charsets.UTF_8)
                .putString(from, Charsets.UTF_8), 1000000, 0.01);
    }

    /**
     * 布隆过滤器bean注入
     * @return
     */
    @Bean
    public BloomRedisService bloomRedisService(){
        BloomRedisService bloomRedisService = new BloomRedisService();
        bloomRedisService.setBloomFilterHelper(initBloomFilterHelper());
        bloomRedisService.setRedisTemplate(redisTemplate);
        return bloomRedisService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        List<String> list = productService.queryProductIds();
        log.info("加载产品到布隆过滤器当中,size:{}",list.size());
        if(!CollectionUtils.isEmpty(list)){
            list.stream().forEach(item->{
                bloomRedisService().addByBloomFilter(ApiBaseConstants.RedisKeyPrefix.PRODUCT_REDIS_BLOOM_FILTER,item);
            });
        }
    }
}
