package com.huatech.mall.dao;

import com.huatech.mall.model.Users;
import com.huatech.mall.vo.UserParam;
/**
 * @author like
 * @date 2020-08-20 8:07 下午
 **/
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
    int insert(Users record);

    /**
     * 根据字段是否为空保存 
     * @param record User
     * @return int
     */
    int insertSelective(Users record);

    /**
     * 根据主键查询 
     * @param id String
     * @return User
     */
    Users selectByPrimaryKey(String id);

    /**
     * 根据字段是否为空更新 
     * @param record User
     * @return int
     */
    int updateByPrimaryKeySelective(Users record);

    /**
     * 根据主键更新所有字段 
     * @param record User
     * @return int
     */
    int updateByPrimaryKey(Users record);

    /**
     * 根据用户名查询用户是否存在
     * @param userName
     * @return
     */
    Users findUserByUserName(String userName);

    /**
     * 更新用户信息
     * @param userParam
     */
    void updateUserInfo(UserParam userParam);
}