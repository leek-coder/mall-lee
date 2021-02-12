package com.huatech.mall.service;

import com.huatech.mall.entity.order.Order;

/**
 * @author like
 * @date 2020-06-23 10:34 下午
 **/
public interface ISendService {

    /**
     * 异步下单
     *
     * @param order
     */
    void asynOrder(Order order);
}