package com.huatech.mall.service.impl;

import com.huatech.mall.entity.order.SubOrder;
import com.huatech.mall.mapper.order.SubOrderMapper;
import com.huatech.mall.service.ISubOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author leek
 * @Date 2018-09-11 上午10:11
 * @Version 1.0
 * @Description
 */
@Service
public class SubOrderServiceImpl implements ISubOrderService {

    @Autowired
    private SubOrderMapper subOrderMapper;


    /**
     * 生成订单明细
     *
     * @param subOrder
     */
    @Override
    public void insertSubOrderInfo(SubOrder subOrder) {
        subOrderMapper.insertSelective(subOrder);
    }
}
