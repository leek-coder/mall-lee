package com.huatech.mall.controller;

import com.huatech.mall.model.Product;
import com.huatech.mall.response.ResponseResult;
import com.huatech.mall.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品接口服务
 *
 * @author like
 * @date 2020-06-22 3:09 下午
 **/
@RestController
@RequestMapping(value = "/v1/pms")
@Slf4j
public class ProductController {

    @Autowired
    private IProductService productService;



    /**
     * 获取商品信息
     *
     * @param productId
     * @return
     */
    @GetMapping(value = "/productInfo/{productId}")
    public ResponseResult<Product> product(@PathVariable("productId") String productId) {
        log.info("======远程服务调用商品接口=====");
        Product product = productService.findProductStore(productId);
        return ResponseResult.success(product);
    }

    /**
     * 获取参与活动的全部商品
     *
     * @return
     */
    @GetMapping(value = "/products")
    public ResponseResult<List<Product>> list() {
        List<Product> products =productService.findProductList();
        return ResponseResult.success(products);
    }


}