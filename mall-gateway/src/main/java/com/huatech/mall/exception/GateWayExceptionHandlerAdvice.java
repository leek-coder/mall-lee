package com.huatech.mall.exception;



import com.huatech.mall.enums.ApiErrorCodeEnum;
import com.huatech.mall.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author like
 * @date 2020-06-23 10:34 下午
 **/
@Slf4j
@Component
public class GateWayExceptionHandlerAdvice {

    @ExceptionHandler(value = {ExceptionCustomer.class})
    public ResponseResult handle(ExceptionCustomer ex) {
        log.error("网关异常code:{},msg:{}", ex.getCode(),ex.getMessage());
        return ResponseResult.failure(ex.getCode(),ex.getMessage());
    }

    @ExceptionHandler(value = {Throwable.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseResult handle(Throwable throwable) {

        if(throwable instanceof ExceptionCustomer) {
            return handle((ExceptionCustomer) throwable);
        }else {
            return ResponseResult.failure(ApiErrorCodeEnum.ERROR_UNKNOWN);
        }
    }
}
