package com.huatech.mall.service.impl;

import com.huatech.mall.dao.UserMapper;
import com.huatech.mall.dto.LoginUserRes;
import com.huatech.mall.dto.UserToken;
import com.huatech.mall.model.Users;
import com.huatech.mall.service.IAuthUserFeignService;
import com.huatech.mall.service.IUserService;
import com.huatech.mall.utils.Md5Utils;
import com.huatech.mall.vo.LoginParam;
import com.huatech.mall.vo.UserParam;
import com.jrx.common.constants.BasicConstants;
import com.jrx.common.enums.ApiErrorCodeEnum;
import com.jrx.common.exception.ExceptionCustomer;
import com.jrx.common.response.ResponseResult;
import com.jrx.common.utils.JsonUtils;
import com.jrx.common.utils.RedisUtils;
import com.jrx.common.utils.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author like
 * @date 2021-01-27 10:35 上午
 **/
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IAuthUserFeignService authUserFeignService;


    @Autowired
    private RedisUtils redisUtils;

    @Value("${redis.token.prefix}")
    private String USER_PREFIX;

    @Override
    public LoginUserRes login(LoginParam loginParam) {
        //根据用户名查询用户是否存在
        Users user = userMapper.findUserByUserName(loginParam.getUserName());
        if (null == user) {
            throw new ExceptionCustomer(ApiErrorCodeEnum.USER_NOT_EXISTS);
        }
        //检测密码是否一致
        String input_password = Md5Utils.md5(loginParam.getPassword());
        if (!input_password.equals(user.getPassword())) {
            throw new ExceptionCustomer(ApiErrorCodeEnum.PASSWORD_ERROR);
        }
        //验证通过生成token，并保存到redis里
        UserToken tokenReq = UserToken.builder().id(user.getId()).nickName(user.getNickname()).userName(user.getUsername()).build();
        ResponseResult<Token> response = authUserFeignService.createToken(JsonUtils.toString(tokenReq));
        if (response.getCode() != BasicConstants.REMOTE_SUCCESS || response.getData() == null) {
            //调用鉴权接口失败
            throw new ExceptionCustomer(ApiErrorCodeEnum.AUTH_REMOTE_FAIL);
        }
        Token token = response.getData();
        String tokenStr = token.getToken();
        //保存redis
        redisUtils.setEx(USER_PREFIX + user.getId(), tokenStr, token.getExpiration(), TimeUnit.SECONDS);
        LoginUserRes login = LoginUserRes.builder().token(tokenStr).build();
        return login;
    }

    @Override
    public LoginParam register(LoginParam loginParam) {
        //根据用户名查询系统中是否有重复的用户
        Users user = userMapper.findUserByUserName(loginParam.getUserName());
        if (user != null) {
            throw new ExceptionCustomer(ApiErrorCodeEnum.USER_EXISTS);
        }
        String password = Md5Utils.md5(loginParam.getPassword());
        Users users = new Users();
        users.setQrcode("");
        users.setNickname("");
        users.setPassword(password);
        users.setId(System.currentTimeMillis() + "");
        users.setFaceImage("");
        users.setFaceImageBig("");
        users.setUsername(loginParam.getUserName());
        userMapper.insertSelective(users);
        return loginParam;
    }

    @Override
    public void update(UserParam userParam) {
        userMapper.updateUserInfo(userParam);
    }
}