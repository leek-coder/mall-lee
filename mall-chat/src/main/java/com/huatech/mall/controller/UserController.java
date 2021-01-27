package com.huatech.mall.controller;

import com.huatech.mall.dto.LoginUserRes;
import com.huatech.mall.service.IUserService;
import com.huatech.mall.vo.LoginParam;
import com.jrx.common.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    


    @PutMapping(value = "/register")
    public ResponseResult register(@RequestBody @Valid LoginParam loginParam) {
        LoginParam register = userService.register(loginParam);
        return ResponseResult.success(register);
    }

    @PutMapping(value = "/login")
    public ResponseResult user(@RequestBody @Valid LoginParam loginParam) {
        LoginUserRes login = userService.login(loginParam);
        return ResponseResult.success(login);
    }


}