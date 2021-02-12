package com.huatech.mall.service;

import com.huatech.mall.entity.order.Order;
import com.huatech.mall.request.QuickOrderReq;

/**
 * 下单服务
 *
 * @author like
 * @date 2020-06-23 12:42 上午
 **/
public interface IOrderService {

    /**
     * 快速下单
     *
     * @param quickOrderReq
     * @return
     */
    Order quickCreateOrder(QuickOrderReq quickOrderReq);

    /**
     * 提交订单
     *
     * @param order
     */
    void submitOrder(Order order);


}