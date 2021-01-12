package com.huatech.mall.controller;

import com.huatech.mall.model.User;
import com.huatech.mall.service.IUserService;
import com.jrx.common.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author like
 * @date 2019-12-03 10:12 上午
 * 增，删，改，查
 **/
@RestController
@RequestMapping(value = "/v1")
@Slf4j
public class UserController {


    @Autowired
    private IUserService userService;

    @PostMapping(value = "/users")
    public ResponseResult save(@RequestBody User user) {
        //验证参数的合法性
        log.info("======创建用户请求参数====={}", user.toString());
        //插入系统用户
        userService.save(user);
        return ResponseResult.success();
    }


}