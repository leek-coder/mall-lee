package com.huatech.mall.service;

import com.huatech.mall.service.impl.AuthUserFeignServiceFallBack;
import com.huatech.mall.response.ResponseResult;
import com.huatech.mall.utils.Token;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 调用远程鉴权服务
 *
 * @author like
 * @date 2019-12-11 3:29 下午
 **/
@FeignClient(name = "mall-auth-service",fallback = AuthUserFeignServiceFallBack.class)
public interface IAuthUserFeignService {


    /**
     * 调用远程服务生成token
     *
     * @param userJson
     * @return
     */
    @RequestMapping(value = "/token/create", consumes = "application/json",method = RequestMethod.POST)
    ResponseResult<Token> createToken(@RequestBody String userJson);



}