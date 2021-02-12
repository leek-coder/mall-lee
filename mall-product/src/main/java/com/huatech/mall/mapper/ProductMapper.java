package com.huatech.mall.mapper;


import com.huatech.mall.model.Product;

import java.util.List;

/**
 * @author like
 */
public interface ProductMapper extends IBaseMapper<Product, String> {

    /**
     * 查询所有商品列表
     *
     * @return
     */
    List<Product> findProductList();
}