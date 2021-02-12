package com.huatech.mall.mapper;

import java.util.List;

/**
 * 基础mapper
 *
 * @author like
 * @date 2019-11-30 11:24 上午
 **/
public interface IBaseMapper<T, ID> {

    /**
     * 根据主键查询数据
     *
     * @param id
     * @return
     */
     T selectByPrimaryKey(ID id);

    /**
     * 查询所有
     *
     * @return
     */
     List<T> findList(); //查询所有

    /**
     * 保存数据
     *
     * @param record
     * @return
     */
    int insert(T record);

    /**
     * 根据字段是否为空保存
     *
     * @param record
     * @return
     */
    int insertSelective(T record);


    /**
     * 根据主键更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(T record);

    /**
     * 根据主键删除数据
     * @param id
     * @return
     */
    int deleteByPrimaryKey(ID id);

}