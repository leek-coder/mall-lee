package com.huatech.mall.dao;

import com.huatech.mall.model.Friends;

public interface FriendsMapper {
    /**
     * 根据主键删除 
     * @param id String
     * @return int
     */
    int deleteByPrimaryKey(String id);

    /**
     * 保存
     * @param record Friends
     * @return int
     */
    int insert(Friends record);

    /**
     * 根据字段是否为空保存 
     * @param record Friends
     * @return int
     */
    int insertSelective(Friends record);

    /**
     * 根据主键查询 
     * @param id String
     * @return Friends
     */
    Friends selectByPrimaryKey(String id);

    /**
     * 根据字段是否为空更新 
     * @param record Friends
     * @return int
     */
    int updateByPrimaryKeySelective(Friends record);

    /**
     * 根据主键更新所有字段 
     * @param record Friends
     * @return int
     */
    int updateByPrimaryKey(Friends record);
}