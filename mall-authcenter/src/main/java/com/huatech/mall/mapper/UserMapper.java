package com.huatech.mall.mapper;


import com.huatech.mall.entity.User;


/**
 * @author like
 * @Version 1.0
 */
public interface UserMapper {

    /**
     * 根据用户姓名查询
     * @param userName
     * @return
     */
    User findUserByUserName(String userName);



}