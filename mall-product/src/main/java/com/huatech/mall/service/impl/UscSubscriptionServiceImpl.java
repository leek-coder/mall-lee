package com.huatech.mall.service.impl;

import com.huatech.mall.mapper.UcsSubscriptionMapper;
import com.huatech.mall.model.UcsSubscription;
import com.huatech.mall.service.IUcsSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author like
 * @date 2021-01-01 4:29 下午
 **/
@Service
public class UscSubscriptionServiceImpl implements IUcsSubscriptionService {

    @Autowired
    private UcsSubscriptionMapper ucsSubscriptionMapper;

    @Override
    public void save(UcsSubscription ucsSubscription) {
        ucsSubscriptionMapper.insert(ucsSubscription);
    }

    @Override
    public UcsSubscription findByInstanceId(Long instanceId) {
        return ucsSubscriptionMapper.selectByInstanceId(instanceId);
    }
}