package com.huatech.mall.service;


import com.huatech.mall.entity.shopcar.ShopCar;
import com.huatech.mall.request.ShopCartParam;

/**
 * @Author leek
 * @Date 2020-05-11 上午10:03
 * @Version 1.0
 * @Description
 */
public interface IShopCarService extends IBaseService<ShopCar, Integer> {

    /**
     * 添加购物车
     *
     * @param shopCartParam
     */
    void addShopCart(ShopCartParam shopCartParam);

    /**
     * 添加购物车
     *
     * @param userId
     * @param productId
     * @return
     */
    ShopCar findShopCarByUserIdAndProductId(Long userId, String productId);

//    /**
//     * 添加购物车
//     *
//     * @param userId
//     * @return
//     */
//    Integer findUsersShopProductNums(Long userId);


//    List<ShopCarDto> findUserShopAllProducts(Long userId);
//
//
//    void deleteUserShopCartProduct(Long userId, String productId);
//
//
//    ShopCarAndProductDto findShopCarAndProductsByUserId(Long userId, String productId);
}
