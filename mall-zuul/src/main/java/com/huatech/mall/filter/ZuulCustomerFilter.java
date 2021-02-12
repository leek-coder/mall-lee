package com.huatech.mall.filter;

import com.huatech.mall.feign.IUserAuthFeignService;
import com.huatech.mall.entity.JwtUser;
import com.huatech.mall.response.ResponseResult;
import com.huatech.mall.utils.JsonUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 新建zuul拦截器
 *
 * @author like
 * @date 2019-12-02 7:47 下午
 **/
@Component
public class ZuulCustomerFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(ZuulCustomerFilter.class);

    @Value("${url.ignores}")
    private String urlIgnores;

    @Value("${token.header}")
    private String tokenHeader;

    private static final Integer SUCCESS_CODE = 200;

    @Resource
    private IUserAuthFeignService userAuthFeignService;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String requestURI = request.getRequestURI();
        //过滤登陆接口，直接放行
        boolean flag = false;
        if (requestURI.contains(urlIgnores)) {
            flag = true;
        }
        if (!flag) {
            // 从请求head中获得token
            String requestHeaderToken = request.getHeader(tokenHeader);
            logger.info("=====requestToken:{}", requestHeaderToken);
            if (StringUtils.isBlank(requestHeaderToken)) {
                context.setSendZuulResponse(false);
                context.setResponseBody(JsonUtils.toString(ResponseResult.failure(4004, "token不能为空")));
                context.getResponse().setContentType("application/json; charset=utf-8");
                return null;
            }
            ResponseResult<JwtUser> responseResult = userAuthFeignService.parseToken(requestHeaderToken);
            if (responseResult.getCode() != SUCCESS_CODE || responseResult.getData() == null) {
                context.setSendZuulResponse(false);
                context.setResponseBody(JsonUtils.toString(responseResult));
                context.getResponse().setContentType("application/json; charset=utf-8");
                return null;
            }
            context.addZuulRequestHeader(tokenHeader, requestHeaderToken);
        }
        return null;
    }
}