package com.huatech.mall.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huatech.mall.mapper.IBaseMapper;
import com.huatech.mall.service.IBaseService;

import java.io.Serializable;
import java.util.List;

/**
 * 基础service实现类
 *
 * @author like
 * @date 2019-11-30 11:36 上午
 **/
public abstract class BaseServiceImpl<T, ID extends Serializable> implements IBaseService<T, ID> {

    /**
     * 获取基本mapper
     *
     * @return
     */
    public abstract IBaseMapper<T, ID> getBaseMapper();

    @Override
    public T find(ID id) {
        return getBaseMapper().selectByPrimaryKey(id);
    }

    @Override
    public List<T> findAll() {
        return getBaseMapper().findList();
    }

    @Override
    public int insert(T entity) {
        return getBaseMapper().insert(entity);
    }

    @Override
    public int insertSelective(T entity) {
        return getBaseMapper().insertSelective(entity);
    }

    @Override
    public int delete(ID id) {
        return getBaseMapper().deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        return getBaseMapper().updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<T> findList(int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<T> list = getBaseMapper().findList();
        PageInfo<T> pageInfo = new PageInfo<>(list);
        return pageInfo;


    }
}