package com.huatech.mall.spi.impl;

import com.huatech.mall.spi.CarInterface;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;

/**
 * @author like
 * @date 2021-02-05 1:49 下午
 * 这个注解的功能是这个接口的代理类，如果这个接口所有实现类上都没有加@Adaptive，源码会默认创建一个代理类
 **/
@Adaptive
public class AdaptiveColor implements CarInterface {

    public void getColor(URL url) {
        System.out.println("Adaptive");
    }
}