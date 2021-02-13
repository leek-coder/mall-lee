package com.huatech.mall.service;


import com.huatech.mall.model.Product;

import java.util.List;

/**
 * 商品远程调用服务
 *
 * @author like
 * @date 2020-06-22 3:32 下午
 **/
public interface IProductService {


    /**
     * 查询商品信息
     *
     * @param productId
     * @return
     */
    Product findProductStore(String productId);

    /**
     * 获取所有参与活动的商品
     * @return
     */
    List<Product> findProductList();

    /**
     * 查询所有商品的标示
     * @return
     */
    List<String> queryProductIds();
}
