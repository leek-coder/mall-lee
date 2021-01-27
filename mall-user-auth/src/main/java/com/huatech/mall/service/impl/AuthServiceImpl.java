package com.huatech.mall.service.impl;

import com.huatech.mall.entity.User;
import com.huatech.mall.service.IAuthService;
import com.jrx.common.entity.JwtUser;
import com.jrx.common.enums.ApiErrorCodeEnum;
import com.jrx.common.exception.ExceptionCustomer;
import com.jrx.common.utils.JwtUtils;
import com.jrx.common.utils.RedisUtils;
import com.jrx.common.utils.Token;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @ClassName JwtAuthServiceImpl
 * @Description TODO
 * @Author like
 * @Date 2019-07-31 13:18
 * @Version 1.0
 **/
@Service
public class AuthServiceImpl implements IAuthService {


    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private RedisUtils redisUtils;

    @Value("${redis.token.prefix}")
    private String token_user;

    /**
     * 创建token信息
     *
     * @param user
     * @return
     */
    @Override
    public Token createToken(User user) {
        JwtUser jwtUser = JwtUser.builder().id(user.getId()).userName(user.getUserName()).nickName(user.getNickName()).build();
        Token token = jwtUtils.createToken(jwtUser);
        return token;
    }

    @Override
    public JwtUser parseToken(String token) {
        JwtUser user = jwtUtils.getUserFromToken(token);
        //从redis中查看用户是否存在
        String tokenStr = redisUtils.get(token_user + user.getId());
        if (StringUtils.isBlank(tokenStr)) {
            //token已经过期
            throw new ExceptionCustomer(ApiErrorCodeEnum.TOKEN_IS_EXPIRED);
        }
        if (!token.equals(tokenStr)) {
            //token不合法
            throw new ExceptionCustomer(ApiErrorCodeEnum.TOKEN_IS_VALID);
        }
        return user;
    }


}
