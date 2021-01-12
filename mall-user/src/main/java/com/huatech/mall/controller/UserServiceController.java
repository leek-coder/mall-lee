package com.huatech.mall.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.huatech.mall.block.UserControllerBlockUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制类
 *
 * @author like
 * @date 2019-11-28 5:30 下午
 **/
@RestController
@RequestMapping(value = "/user")
public class UserServiceController {


    @Value("${name}")
    private String name;

    @RequestMapping(value = "/detail")
    @SentinelResource(value = "detail", blockHandler = "detailHandleException", blockHandlerClass = {UserControllerBlockUtils.class})
    public String user(@RequestHeader("name") String name) {
        return "请求头:" + name;
    }

    @RequestMapping(value = "/save")
    public String save() {
        return this.name;
    }


}