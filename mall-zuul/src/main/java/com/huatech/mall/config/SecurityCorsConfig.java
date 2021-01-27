package com.huatech.mall.config;

import com.huatech.mall.filter.ZuulCustomerFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;

/**
 * 解决前端跨域
 *
 * @author like
 * @date 2019-12-12 2:46 下午
 **/
@Configuration
public class SecurityCorsConfig {
        @SuppressWarnings("unchecked")
        @Bean
        public FilterRegistrationBean corsFilter() {
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            CorsConfiguration corsConfiguration = new CorsConfiguration();
            corsConfiguration.setAllowCredentials(true);
            corsConfiguration.setAllowedOrigins(Collections.singletonList(CorsConfiguration.ALL));
            corsConfiguration.setAllowedHeaders(Collections.singletonList(CorsConfiguration.ALL));
            corsConfiguration.setAllowedMethods(Collections.singletonList(CorsConfiguration.ALL));
            source.registerCorsConfiguration("/**", corsConfiguration);
            FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
            bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
            return bean;
        }

    /**
     * 注册zuul拦截器
     * @return
     */
    @Bean
    public ZuulCustomerFilter customerFilter(){
        return  new ZuulCustomerFilter();
    }

    }