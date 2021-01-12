package com.huatech.mall.service;


import com.huatech.mall.model.User;

/**
 * 用户管理service
 *
 * @author like
 * @date 2019-12-03 11:27 上午
 **/
public interface IUserService {

    /**
     * 保存用户
     *
     * @param user
     */
    void save(User user);
}
