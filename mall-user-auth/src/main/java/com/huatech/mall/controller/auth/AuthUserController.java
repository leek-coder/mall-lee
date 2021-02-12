package com.huatech.mall.controller.auth;

import com.huatech.mall.entity.User;
import com.huatech.mall.service.IAuthService;
import com.huatech.mall.entity.JwtUser;
import com.huatech.mall.response.ResponseResult;
import com.huatech.mall.utils.Token;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 用户鉴权控制类
 *
 * @author like
 * @date 2019-12-11 11:11 上午
 **/
@RestController
@RequestMapping(value = "/token")
@Slf4j
public class AuthUserController {

    @Autowired
    private IAuthService authService;

    /**
     * 根据用户信息生成token
     *
     * @param user
     * @return
     */
    @PostMapping(value = "/create")
    public ResponseResult<Token> createToken(@Valid @RequestBody User user) {
        Token token = authService.createToken(user);
        return ResponseResult.success(token);
    }

    /**
     * 解析token中的用户
     *
     * @param token
     * @return
     */
    @GetMapping(value = "/parse")
    public ResponseResult<JwtUser> parseToken(@RequestParam(value = "token",required = true) String token) {
        JwtUser jwtUser = authService.parseToken(token);
        return ResponseResult.success(jwtUser);
    }

}