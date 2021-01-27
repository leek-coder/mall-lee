package com.huatech.mall.dao;

import com.huatech.mall.model.User;

public interface UserMapper {
    /**
     * 根据主键删除 
     * @param id String
     * @return int
     */
    int deleteByPrimaryKey(String id);

    /**
     * 保存
     * @param record User
     * @return int
     */
    int insert(User record);

    /**
     * 根据字段是否为空保存 
     * @param record User
     * @return int
     */
    int insertSelective(User record);

    /**
     * 根据主键查询 
     * @param id String
     * @return User
     */
    User selectByPrimaryKey(String id);

    /**
     * 根据字段是否为空更新 
     * @param record User
     * @return int
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 根据主键更新所有字段 
     * @param record User
     * @return int
     */
    int updateByPrimaryKey(User record);
}