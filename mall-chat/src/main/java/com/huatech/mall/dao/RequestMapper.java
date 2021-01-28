package com.huatech.mall.dao;

import com.huatech.mall.model.Request;
/**
 * @author like
 * @date 2020-08-20 8:07 下午
 **/
public interface RequestMapper {
    /**
     * 根据主键删除 
     * @param id String
     * @return int
     */
    int deleteByPrimaryKey(String id);

    /**
     * 保存
     * @param record Request
     * @return int
     */
    int insert(Request record);

    /**
     * 根据字段是否为空保存 
     * @param record Request
     * @return int
     */
    int insertSelective(Request record);

    /**
     * 根据主键查询 
     * @param id String
     * @return Request
     */
    Request selectByPrimaryKey(String id);

    /**
     * 根据字段是否为空更新 
     * @param record Request
     * @return int
     */
    int updateByPrimaryKeySelective(Request record);

    /**
     * 根据主键更新所有字段 
     * @param record Request
     * @return int
     */
    int updateByPrimaryKey(Request record);
}