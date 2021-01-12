package com.huatech.mall.service.impl;

import com.huatech.mall.mapper.UserMapper;
import com.huatech.mall.model.User;
import com.huatech.mall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author like
 * @date 2021-01-01 11:10 下午
 **/
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void save(User user) {
        userMapper.insert(user);
    }
}