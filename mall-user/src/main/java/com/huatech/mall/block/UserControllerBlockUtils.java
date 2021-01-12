package com.huatech.mall.block;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.jrx.common.exception.ExceptionCustomer;
import org.springframework.stereotype.Component;

/**
 * @author like
 * 定义的流控，降级方法应该和控制器方法返回值一致，否则不生效
 * @date 2020-12-21 1:16 下午
 **/
@Component
public class UserControllerBlockUtils {


    public static String detailHandleException(BlockException ex) {
        if (ex instanceof DegradeException) {
            throw new ExceptionCustomer("服务繁忙", -1);
        }
        return "未知异常";
    }
}