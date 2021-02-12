package com.huatech.mall.service;


import com.huatech.mall.entity.User;
import com.huatech.mall.entity.JwtUser;
import com.huatech.mall.utils.Token;

/**
 * @ClassName IJwtAuthService
 * @Description TODO
 * @Author like
 * @Date 2019-07-31 13:16
 * @Version 1.0
 **/
public interface IAuthService {

    /**
     * 根据用户信息生成token信息
     * @param user
     * @return
     */
    Token createToken(User user);

    /**
     * 解析token合法性
     * @param token
     * @return
     */
    JwtUser parseToken(String token);
}
