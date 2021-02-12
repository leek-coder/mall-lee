package com.huatech.mall.feign;

import com.huatech.mall.feign.fallback.ProductStoreFeignFallBack;
import com.huatech.mall.response.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author like
 * @date 2020-06-22 4:18 下午
 **/
@FeignClient(name = "product-store-service", fallback = ProductStoreFeignFallBack.class)
public interface IProductStoreFeignService {

    /**
     * 查询商品信息
     *
     * @param productId
     * @return
     */
    @GetMapping(value = "/api/product/store/decr/{productId}")
    ResponseResult<Integer> updateProductStock(@PathVariable("productId") String productId);

}