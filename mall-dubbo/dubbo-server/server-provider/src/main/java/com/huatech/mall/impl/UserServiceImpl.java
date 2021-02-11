package com.huatech.mall.impl;

import com.huatech.dubbo.IUserService;

/**
 * @author like
 * @date 2021-02-04 8:36 上午
 **/
public class UserServiceImpl implements IUserService {

    public void sayHello(String name) {
        System.out.println("Hello:" + name);
    }
}