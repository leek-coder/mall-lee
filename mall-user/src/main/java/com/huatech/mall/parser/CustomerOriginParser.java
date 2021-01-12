package com.huatech.mall.parser;

import com.alibaba.csp.sentinel.adapter.servlet.callback.RequestOriginParser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author like
 * @date 2020-12-31 3:04 下午
 **/
@Component
public class CustomerOriginParser implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest request) {
        //  从 Header 中，获得请求来源
        String origin = request.getHeader("s-user");
        // 如果为空，给一个默认的
        if (StringUtils.isEmpty(origin)) {
            origin = "default";
        }
        return origin;
    }
}