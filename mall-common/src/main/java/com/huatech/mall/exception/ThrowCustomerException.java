package com.huatech.mall.exception;

import com.huatech.mall.enums.ApiErrorCodeEnum;
import org.springframework.stereotype.Service;

/**
 * @author like
 * @date 2020-08-21 3:21 下午
 **/
@Service
public class ThrowCustomerException {
    /**
     * 抛出自定义异常
     *
     * @param apiErrorCodeEnum
     */
    public void throwException(ApiErrorCodeEnum apiErrorCodeEnum) {
        throw new ExceptionCustomer(apiErrorCodeEnum.message(), apiErrorCodeEnum.code());
    }
}