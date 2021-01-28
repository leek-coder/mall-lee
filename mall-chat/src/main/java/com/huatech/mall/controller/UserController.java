package com.huatech.mall.controller;

import com.huatech.mall.dto.LoginUserRes;
import com.huatech.mall.service.IUserService;
import com.huatech.mall.vo.LoginParam;
import com.huatech.mall.vo.UserParam;
import com.jrx.common.response.ResponseResult;
import com.jrx.common.utils.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;


    /**
     * 用户注册
     * @param loginParam
     * @return
     */
    @PutMapping(value = "/register")
    public ResponseResult register(@RequestBody @Valid LoginParam loginParam) {
        LoginParam register = userService.register(loginParam);
        return ResponseResult.success(register);
    }

    /**
     * 用户登陆
     * @param loginParam
     * @return
     */
    @PutMapping(value = "/login")
    public ResponseResult user(@RequestBody @Valid LoginParam loginParam) {
        LoginUserRes login = userService.login(loginParam);
        return ResponseResult.success(login);
    }

    /**
     * 修改用户信息
     * @param userParam
     * @return
     */
    @PutMapping(value = "/update")
    public ResponseResult update(@RequestBody UserParam userParam, HttpServletRequest request) {
        Long userId = getUserInfo(request);
        userParam.setUserId(userId);
        userService.update(userParam);
        return ResponseResult.success();
    }

}