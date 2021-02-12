package com.huatech.mall.feign;


import com.huatech.mall.constants.ApiBaseConstants;
import com.huatech.mall.exception.ExceptionCustomer;
import com.huatech.mall.response.ResponseResult;

import java.util.Arrays;

/**
 * @date 2020/4/1 10:34 上午
 * 统一处理远程调用封装返回的逻辑判断
 */
public interface FeignPredicate<T> {

    ResponseResult<T> apply();


    default T getRes(FeignPredicate predicate) {

        ResponseResult<T> response = predicate.apply();
        if (null == response) {
            return null;
        }
        if (ApiBaseConstants.REMOTE_SUCCESS != response.getCode()) {
            //针对txn返回的这些错误码，直接将错误信息返回给前段
            if (Arrays.asList(2000, 2017, 3001, 3003, 3004, 3005, 3006, 3007, 3008, 3009, 3010, 3011, 3012, 3013, 3014, 3015, 3018,
                    3019, 3020, 3021, 3022, 3024, 3025, 3026, 3102, 3103, 3104, 3108, 3111).contains(response.getCode())) {
                throw new ExceptionCustomer(response.getMessage(), response.getCode());
            }
            return null;
        }
        if (null == response.getData()) {
            return null;
        }
        return response.getData();
    }
}
