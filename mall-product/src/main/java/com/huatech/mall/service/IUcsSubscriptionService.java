package com.huatech.mall.service;


import com.huatech.mall.model.UcsSubscription;

/**
 * @author like
 * @date 2021-01-01 3:45 下午
 **/
public interface IUcsSubscriptionService {

    /**
     * 保存
     *
     * @param ucsSubscription
     */
    void save(UcsSubscription ucsSubscription);

    /**
     * 查询
     *
     * @param instanceId
     * @return
     */
    UcsSubscription findByInstanceId(Long instanceId);

}
