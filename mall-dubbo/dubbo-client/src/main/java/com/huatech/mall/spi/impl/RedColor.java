package com.huatech.mall.spi.impl;

import com.huatech.mall.spi.CarInterface;
import org.apache.dubbo.common.URL;

/**
 * @author like
 * @date 2021-02-05 10:19 上午
 **/
public class RedColor implements CarInterface {
    public void getColor(URL url) {
        System.out.println("red");
    }
}