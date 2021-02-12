package com.huatech.mall.service.impl;

import com.huatech.mall.enums.ApiErrorCodeEnum;
import com.huatech.mall.exception.ExceptionCustomer;
import com.huatech.mall.mapper.ProductMapper;
import com.huatech.mall.model.Product;
import com.huatech.mall.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品远程调用服务实现
 *
 * @author like
 * @date 2020-06-22 3:34 下午
 **/
@Service
public class ProductServiceImpl implements IProductService {


    @Autowired
    private ProductMapper productMapper;


    @Override
    public Product findProductStore(String productId) {
        Product product = productMapper.selectByPrimaryKey(productId);
        if (null == product) {
            throw new ExceptionCustomer(ApiErrorCodeEnum.PRODUCT_NOT_EXISTS);
        }
        return product;
    }

    @Override
    public List<Product> findProductList() {
        return productMapper.findProductList();
    }
}