package com.huatech.mall.service;


import com.huatech.mall.entity.order.SubOrder;

/**
 * @Author leek
 * @Date 2018-09-11 上午10:10
 * @Version 1.0
 * @Description
 */
public interface ISubOrderService {

    /**
     * 生成订单明细
     *
     * @param subOrder
     */
    void insertSubOrderInfo(SubOrder subOrder);
}
