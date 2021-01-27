package com.huatech.mall.service;

import com.huatech.mall.dto.LoginUserRes;
import com.huatech.mall.vo.LoginParam;

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



}