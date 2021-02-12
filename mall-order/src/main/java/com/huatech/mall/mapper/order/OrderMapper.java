package com.huatech.mall.mapper.order;

import com.huatech.mall.entity.order.Order;

public interface OrderMapper {
    /**
     * 根据主键删除 
     * @param id Long
     * @return int
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 保存
     * @param record Order
     * @return int
     */
    int insert(Order record);

    /**
     * 根据字段是否为空保存 
     * @param record Order
     * @return int
     */
    int insertSelective(Order record);

    /**
     * 根据主键查询 
     * @param id Long
     * @return Order
     */
    Order selectByPrimaryKey(Long id);

    /**
     * 根据字段是否为空更新 
     * @param record Order
     * @return int
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * 
     * @param record Order
     * @return int
     */
    int updateByPrimaryKeyWithBLOBs(Order record);

    /**
     * 根据主键更新所有字段 
     * @param record Order
     * @return int
     */
    int updateByPrimaryKey(Order record);
}