package com.huatech.mall.service;

/**
 * @author like
 * @date 2021-02-15 6:34 下午
 **/
public interface IUniqueIdService {

    /**
     * 获取唯一的id
     * @return
     */
    Long generateKey();
}