package com.huatech.mall.utils;

import com.huatech.mall.entity.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author leek
 * @Date 2019-10-25 上午9:58
 * @Version 1.0
 * @Description
 */
public class BaseController {


    @Autowired
    private JwtUtils jwtUtils;

    /**
     * 获取用户userId
     *
     * @param
     * @return
     */
    public Long getUserInfo(HttpServletRequest request) {
        //从请求header中获取token
        String header = request.getHeader("token");
        JwtUser jwtUser = jwtUtils.getUserFromToken(header);
        return jwtUser.getId();
    }

    public JwtUser getUser(HttpServletRequest request) {
        //从请求header中获取token
        String header = request.getHeader("token");
        JwtUser jwtUser = jwtUtils.getUserFromToken(header);
        return jwtUser;
    }
}
