package com.huatech.mall.mapper.order;

import com.huatech.mall.entity.order.SubOrder;

public interface SubOrderMapper {
    /**
     * 根据主键删除
     *
     * @param id Long
     * @return int
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 保存
     *
     * @param record SubOrder
     * @return int
     */
    int insert(SubOrder record);

    /**
     * 根据字段是否为空保存
     *
     * @param record SubOrder
     * @return int
     */
    int insertSelective(SubOrder record);

    /**
     * 根据主键查询
     *
     * @param id Long
     * @return SubOrder
     */
    SubOrder selectByPrimaryKey(Long id);

    /**
     * 根据字段是否为空更新
     *
     * @param record SubOrder
     * @return int
     */
    int updateByPrimaryKeySelective(SubOrder record);

    /**
     * 根据主键更新所有字段
     *
     * @param record SubOrder
     * @return int
     */
    int updateByPrimaryKey(SubOrder record);
}