package com.huatech.mall.mapper;

import com.huatech.mall.model.User;

/**
 * @author like
 * @Version 1.0
 */
public interface UserMapper {


    /**
     * 保存用户
     *
     * @param user
     */
    void insert(User user);

}