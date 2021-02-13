package com.huatech.mall.mapper;


import com.huatech.mall.model.Product;

import java.util.List;

/**
 * @author like
 */
public interface ProductMapper {

    /**
     * 查询所有商品列表
     *
     * @return
     */
    List<Product> findProductList();

    /**
     * 根据主键查询商品详情
     * @param productId
     * @return
     */
    Product selectByPrimaryKey(String productId);

}