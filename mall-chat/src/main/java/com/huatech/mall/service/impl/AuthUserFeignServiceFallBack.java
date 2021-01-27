package com.huatech.mall.service.impl;

import com.huatech.mall.service.IAuthUserFeignService;
import com.jrx.common.enums.ApiErrorCodeEnum;
import com.jrx.common.response.ResponseResult;
import com.jrx.common.utils.Token;
import org.springframework.stereotype.Component;

/**
 * 调用远程鉴权服务-熔断
 *
 * @author like
 * @date 2019-12-11 3:30 下午
 **/
@Component
public class AuthUserFeignServiceFallBack implements IAuthUserFeignService {
    @Override
    public ResponseResult createToken(String userJson) {
        return ResponseResult.failure(ApiErrorCodeEnum.REMOTE_SERVICE_FAIL);
    }

}