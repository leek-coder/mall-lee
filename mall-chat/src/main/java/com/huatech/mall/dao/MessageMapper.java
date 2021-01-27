package com.huatech.mall.dao;

import com.huatech.mall.model.Message;

public interface MessageMapper {
    /**
     * 根据主键删除 
     * @param id String
     * @return int
     */
    int deleteByPrimaryKey(String id);

    /**
     * 保存
     * @param record Message
     * @return int
     */
    int insert(Message record);

    /**
     * 根据字段是否为空保存 
     * @param record Message
     * @return int
     */
    int insertSelective(Message record);

    /**
     * 根据主键查询 
     * @param id String
     * @return Message
     */
    Message selectByPrimaryKey(String id);

    /**
     * 根据字段是否为空更新 
     * @param record Message
     * @return int
     */
    int updateByPrimaryKeySelective(Message record);

    /**
     * 根据主键更新所有字段 
     * @param record Message
     * @return int
     */
    int updateByPrimaryKey(Message record);
}