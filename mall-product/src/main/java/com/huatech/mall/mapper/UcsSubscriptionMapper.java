package com.huatech.mall.mapper;

import com.huatech.mall.model.UcsSubscription;


/**
 * @author like
 * @date 2019-11-28 4:48 下午
 */
public interface UcsSubscriptionMapper {
    /**
     * 保存
     *
     * @param record
     * @return
     */
    int insert(UcsSubscription record);

    /**
     * 保存
     *
     * @param record
     * @return
     */
    int insertSelective(UcsSubscription record);

    /**
     * 查询信息
     *
     * @param instanceId
     * @return
     */
    UcsSubscription selectByInstanceId(Long instanceId);

}