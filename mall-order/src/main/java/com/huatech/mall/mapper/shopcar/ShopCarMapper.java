package com.huatech.mall.mapper.shopcar;


import com.huatech.mall.entity.shopcar.ShopCar;
import com.huatech.mall.mapper.IBaseMapper;

public interface ShopCarMapper extends IBaseMapper<ShopCar, Integer> {
    /**
     * 根据主键删除
     *
     * @param id Long
     * @return int
     */
    int deleteByPrimaryKey(Long id);


    /**
     * 根据主键查询
     *
     * @param id Long
     * @return ShopCar
     */
    ShopCar selectByPrimaryKey(Long id);

    /**
     * 根据字段是否为空更新
     *
     * @param record ShopCar
     * @return int
     */
    int updateByPrimaryKeySelective(ShopCar record);

}