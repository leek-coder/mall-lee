package com.huatech.mall.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huatech.mall.component.BloomRedisService;
import com.huatech.mall.constants.ApiBaseConstants;
import com.huatech.mall.enums.ApiErrorCodeEnum;
import com.huatech.mall.exception.ThrowCustomerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


/**
 * @author like
 * @date 2020-06-22 3:34 下午
 **/
@Slf4j
public class BloomFilterInterceptor implements HandlerInterceptor {

    @Autowired
    private BloomRedisService bloomRedisService;

    @Autowired
    private  ThrowCustomerException throwCustomerException;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String currentUrl = request.getRequestURI();
        PathMatcher matcher = new AntPathMatcher();
        //解析出
        Map<String, String> pathVariable = matcher.extractUriTemplateVariables("/v1/pms/productInfo/{productId}", currentUrl);
        //布隆过滤器存储在redis中
        if (bloomRedisService.includeByBloomFilter(ApiBaseConstants.RedisKeyPrefix.PRODUCT_REDIS_BLOOM_FILTER, pathVariable.get("productId"))) {
            return true;
        }
        /*
         * 不在本地布隆过滤器当中，直接跑出异常
         */
        throwCustomerException.throwException(ApiErrorCodeEnum.PRODUCT_NOT_EXISTS);
        return false;

    }

}
