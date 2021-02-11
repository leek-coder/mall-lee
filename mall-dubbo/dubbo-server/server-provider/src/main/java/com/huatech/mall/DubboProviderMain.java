package com.huatech.mall;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author like
 * @date 2021-02-04 8:44 上午
 **/
public class DubboProviderMain {
    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-provider.xml");
        context.start();
        System.in.read();

        //获取自己的扩展点
        Object extension = ExtensionLoader.getExtensionLoader(Object.class).getExtension("");
        Object extension1 = ExtensionLoader.getExtensionLoader(Object.class).getAdaptiveExtension();
    }
}