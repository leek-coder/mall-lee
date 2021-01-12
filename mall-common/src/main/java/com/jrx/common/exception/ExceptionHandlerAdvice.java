package com.jrx.common.exception;

import com.jrx.common.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author leek
 * @Date 2019-06-14 下午5:41
 * @Version 1.0
 * @Description 全局异常处理类
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult handlerException(Exception e, HttpServletRequest httpServletRequest) {

        if (e instanceof ExceptionCustomer) {
            ExceptionCustomer exceptionCustomer = (ExceptionCustomer) e;
            log.info("异常信息======", exceptionCustomer.getMessage());
            return new ResponseResult(exceptionCustomer.getErrorCode(), exceptionCustomer.getMessage(), null);
        } else {
            return ResponseResult.failure(-1, "服务器异常", 1000);

        }
    }


}
