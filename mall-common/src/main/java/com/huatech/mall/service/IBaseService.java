package com.huatech.mall.service;


import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

/**
 * 基础service
 *
 * @author like
 * @date 2019-11-30 11:22 上午
 **/
public interface IBaseService<T, ID extends Serializable> {

    /**
     * 根据主键查询数据
     *
     * @param id
     * @return
     */
    public abstract T find(ID id);


    /**
     * 查询所有
     *
     * @return
     */
    public abstract List<T> findAll();

    /**
     * 分页查询数据
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public PageInfo<T> findList(int pageNumber, int pageSize);
    /**
     * 保存数据
     *
     * @param entity
     * @return
     */
    public abstract int insert(T entity);

    /**
     * 根据字段是否为空保存
     *
     * @param entity
     * @return
     */
    public abstract int insertSelective(T entity);

    /**
     * 根据主键删除实体
     *
     * @param id
     * @return
     */
    public abstract int delete(ID id);

    /**
     * 根据主键更新实体
     *
     * @param entity
     * @return
     */
    int updateByPrimaryKey(T entity);

}