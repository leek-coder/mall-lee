package com.huatech.mall.controller;

import com.huatech.mall.service.IUserService;
import com.jrx.common.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器
 *
 * @author like
 * @date 2021-01-27 10:30 上午
 **/
@RestController
@RequestMapping("/v1/user")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseResult user() {

        return ResponseResult.success("leek");
    }
}