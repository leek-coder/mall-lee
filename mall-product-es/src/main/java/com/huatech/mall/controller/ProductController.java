package com.huatech.mall.controller;

import com.huatech.mall.response.ResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author like
 * @date 2021-01-09 4:39 下午
 **/
@RestController
@RequestMapping("/product")
public class ProductController {


    @RequestMapping(value = "/index")
    public ResponseResult index() {
        return ResponseResult.success();
    }


}