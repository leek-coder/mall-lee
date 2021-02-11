package com.huatech.mall.spi;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * @author like
 * @date 2021-02-05 10:20 上午
 **/
public class SPIMain {
    public static void main(String[] args) {

        ExtensionLoader<CarInterface> extension = ExtensionLoader.getExtensionLoader(CarInterface.class);
        Map<String, String> map = new HashMap<String, String>();
        map.put("car", "black");
        URL url = new URL("", "", 1, map);
        CarInterface benz = extension.getExtension("benz");
        benz.getColor(url);
        //获取代理类 ---具体实现类  代理类也是实现CarInterface接口
        CarInterface adaptiveExtension = ExtensionLoader.getExtensionLoader(CarInterface.class).getAdaptiveExtension();
        System.out.println("adaptiveExtension="+adaptiveExtension);
    }
}