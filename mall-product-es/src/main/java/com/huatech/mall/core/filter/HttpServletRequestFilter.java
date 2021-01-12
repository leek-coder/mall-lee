package com.huatech.mall.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.huatech.mall.core.interceptor.MyHttpServletRequestWrapper;
import org.springframework.core.annotation.Order;


import lombok.extern.slf4j.Slf4j;

/**
 * @author like
 * @date 2021-01-10 9:02 下午
 **/
@Slf4j
@Order(1)
@WebFilter(filterName = "httpServletRequestFilter", displayName = "httpServletRequestFilter", urlPatterns = "/*")
public class HttpServletRequestFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("Register a new filter {}", filterConfig.getFilterName());
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		ServletRequest requestWrapper = null;
		if (request instanceof HttpServletRequest) {
			requestWrapper = new MyHttpServletRequestWrapper((HttpServletRequest) request);
		}

		if (requestWrapper == null) {
			chain.doFilter(request, response);
		} else {
			chain.doFilter(requestWrapper, response);
		}
	}

	@Override
	public void destroy() {
		log.info("Destroy filter {}", getClass().getName());
	}

}
