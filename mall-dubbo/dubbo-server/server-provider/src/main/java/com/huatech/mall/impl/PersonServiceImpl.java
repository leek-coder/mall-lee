package com.huatech.mall.impl;

import com.huatech.dubbo.IPersonService;

/**
 * @author like
 * @date 2021-02-10 5:25 下午
 **/
public class PersonServiceImpl implements IPersonService {

    public void sysPerson(String name) {
        System.out.println("person=" + name);
    }
}