package com.huatech.mall.controller.service.impl;

import com.huatech.mall.controller.service.IProductService;
import org.springframework.stereotype.Service;


/**
 * @author like
 * @date 2020-12-31 11:03 上午
 **/
@Service
public class ProductServiceImpl implements IProductService {
    @Override
    public void save(String name) {
        System.out.println("name=" + name);
    }
}