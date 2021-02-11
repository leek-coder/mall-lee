package com.huatech.mall.spi;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * @author like
 * @date 2021-02-05 10:19 上午
 **/
@SPI
public interface CarInterface {

    /**
     * 获取颜色
     *
     * @param url
     */
    @Adaptive("car")
    public void getColor(URL url);
}