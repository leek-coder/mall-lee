package com.huatech.mall.spi.impl;

import com.huatech.mall.spi.CarInterface;
import org.apache.dubbo.common.URL;

/**
 * @author like
 * @date 2021-02-05 10:23 上午
 **/
public class WrapperColor implements CarInterface {

    /**
     * 具体实现类
     */
    private CarInterface carInterface;


    public WrapperColor(CarInterface carInterface) {
        this.carInterface = carInterface;
    }


    public void getColor(URL url) {
        //begin
        System.out.println("before");
        carInterface.getColor(url);
        System.out.println("after");
        //end
    }
}