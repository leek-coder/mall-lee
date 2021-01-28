package com.huatech.mall.service;

import com.huatech.mall.dto.LoginUserRes;
import com.huatech.mall.vo.LoginParam;
import com.huatech.mall.vo.UserParam;

/**
 * @author like
 * @date 2021-01-27 10:35 上午
 **/
public interface IUserService {


    /**
     * 用户登陆
     *
     * @param loginParam
     * @return
     */
    LoginUserRes login(LoginParam loginParam);

    /**
     * 用户注册
     * @param loginParam
     * @return
     */
    LoginParam register(LoginParam loginParam);


    /**
     * 更改用户信息
     * @param userParam
     */
    void update(UserParam userParam);
}