package com.huatech.mall.feign;

import com.huatech.mall.feign.fallback.ProductFeignFallBack;
import com.huatech.mall.response.ProductRes;
import com.huatech.mall.response.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author like
 * @date 2020-06-22 4:18 下午
 **/
@FeignClient(name = "mall-product", fallback = ProductFeignFallBack.class)
public interface IProductFeignService {

    /**
     * 查询商品信息
     *
     * @param productId
     * @return
     */
    @GetMapping(value = "/v1/pms/productInfo/{productId}")
    ResponseResult<ProductRes> findProductStore(@PathVariable("productId") String productId);


    /**
     * 查询所有参与活动的商品
     *
     * @return
     */
    @RequestMapping(value = "/v1/pms/products")
    ResponseResult<List<ProductRes>> list();

}