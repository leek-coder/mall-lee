package com.huatech.mall.service;

import com.huatech.mall.entity.MemberDetails;
import com.huatech.mall.entity.User;
import com.huatech.mall.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;


/**
 * 认证服务器加载用户的类
 *
 * @createDate: 2020/1/21 21:29
 * @version: 1.0
 */
@Component
public class UserDetailService implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(UserDetailService.class);
    /**
     * 方法实现说明:用户登陆
     *
     * @author:smlz
     * @param userName 用户名密码
     * @return: UserDetails
     * @exception:
     * @date:2020/1/21 21:30
     */

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        if (StringUtils.isEmpty(userName)) {
            log.warn("用户登陆用户名为空:{}", userName);
            throw new UsernameNotFoundException("用户名不能为空");
        }
        User user = userMapper.findUserByUserName(userName);

        if (null == user) {
            log.warn("根据用户名没有查询到对应的用户信息:{}", userName);
        }
        log.info("根据用户名:{}获取用户登陆信息:{}", userName, user);
        MemberDetails memberDetails = new MemberDetails(user);
        return memberDetails;
    }


}
