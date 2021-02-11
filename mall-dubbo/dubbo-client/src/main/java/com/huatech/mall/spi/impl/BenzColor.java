package com.huatech.mall.spi.impl;

import com.huatech.mall.spi.CarInterface;
import org.apache.dubbo.common.URL;

/**
 * @author like
 * @date 2021-02-05 10:19 上午
 **/
public class BenzColor implements CarInterface {
    /**
     * 具体实现类
     */
    private CarInterface carInterface;

    /**
     * 注入点  注入代理类
     * @param carInterface
     */

    public void setCarInterface(CarInterface carInterface) {
        this.carInterface = carInterface;
    }

    public void getColor(URL url) {
        carInterface.getColor(url);
    }
}