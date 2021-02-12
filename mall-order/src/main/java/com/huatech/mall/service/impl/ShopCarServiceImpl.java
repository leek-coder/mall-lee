package com.huatech.mall.service.impl;

import com.huatech.mall.entity.shopcar.ShopCar;
import com.huatech.mall.feign.FeignPredicate;
import com.huatech.mall.feign.IProductFeignService;
import com.huatech.mall.mapper.IBaseMapper;
import com.huatech.mall.mapper.shopcar.ShopCarMapper;
import com.huatech.mall.request.ShopCartParam;
import com.huatech.mall.response.ProductRes;
import com.huatech.mall.service.IShopCarService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author leek
 * @Date 2020-05-11 上午10:03
 * @Version 1.0
 * @Description
 */
@Service
public class ShopCarServiceImpl extends BaseServiceImpl<ShopCar, Integer> implements IShopCarService {


    @Autowired
    private ShopCarMapper shopCarMapper;

    @Autowired
    private IProductFeignService productFeignService;

    @Override
    public IBaseMapper<ShopCar, Integer> getBaseMapper() {
        return shopCarMapper;
    }

    @Override
    public void addShopCart(ShopCartParam shopCartParam) {

        //查询商品是否存在
        FeignPredicate<ProductRes> checkPredicate = () -> productFeignService.findProductStore(shopCartParam.getProductId());
        if (null == checkPredicate.getRes(checkPredicate)) {
        }
        ProductRes productRes = checkPredicate.getRes(checkPredicate);
        //查询添加的商品是否已经存在用户的购物车里面

        ShopCar db_shop = findShopCarByUserIdAndProductId(shopCartParam.getUserId(), shopCartParam.getProductId());
        if (db_shop != null) {
            //购物车里已经存在用户所选择的商品
            if (StringUtils.isNotBlank(shopCartParam.getAction())) {
                Integer productNum = shopCartParam.getProductNum();
                if (shopCartParam.getAction().equals("add")) {
                    //增加商品数量
                    db_shop.setProductNum(db_shop.getProductNum() + productNum);
                    db_shop.setUpdateTime(new Date());
//                    shopCarMapper.updateByPrimaryKey(db_shop);

                } else if (shopCartParam.getAction().equals("del")) {
                    //减少商品数量
                    db_shop.setProductNum(db_shop.getProductNum() - productNum);
                    db_shop.setUpdateTime(new Date());
//                    shopCarMapper.updateByPrimaryKey(db_shop);
                }
            }

        } else {
            //购物车里没有该商品,新建商品添加到购物车
//            ShopCar shopCar = new ShopCar();
//            shopCar.setCreateTime(new Date());
//            shopCar.setProductNum(shopCartParam.getProductNum());
//            shopCar.setProductName(product.getProductName());
//            shopCar.setProductId(shopCartParam.getProductId());
//            shopCar.setUserId(shopCartParam.getUserId());
//            shopCar.setProductPrice(product.getProductNowPrice());
//            shopCar.setSource("wx");
//            shopCarMapper.insertSelective(shopCar);

        }

    }


    /**
     * 根据用户的id和商品id查询用户是否已经将商品加入到购物车里
     *
     * @param userId
     * @param productId
     * @return
     */
    @Override
    public ShopCar findShopCarByUserIdAndProductId(Long userId, String productId) {

//        ShopCarExample example = new ShopCarExample();
//        ShopCarExample.Criteria criteria = example.createCriteria();
//        criteria.andUserIdEqualTo(userId);
//        criteria.andProductIdEqualTo(productId);
//        criteria.andStatusEqualTo("0");
//        List<ShopCar> shopCars = shopCarMapper.selectByExample(example);
//
//        if (shopCars != null && shopCars.size() > 0) {
//            return shopCars.get(0);
//        }


        return null;
    }

//    //查询用户购物车数量
//    @Override
//    public Integer findUsersShopProductNums(Long userId) {
//        return shopCarMapper.selectCountByUserId(userId);
//    }

//    @Override
//    public List<ShopCarDto> findUserShopAllProducts(Long userId) {
//
//        return shopCarMapper.findUserShopAllProducts(userId);
//    }

    //删除用户购物车商品,逻辑删除
//    @Override
//    public void deleteUserShopCartProduct(Long userId, String productId) {
//
//        ShopCar shopCar = this.findShopCarByUserIdAndProductId(userId, productId);
//        if (shopCar == null) {
//            throw new ExceptionCustomer(ProductStatuesEnumType.PRODUCT_NOT_EXISTS.getName(), ProductStatuesEnumType.PRODUCT_NOT_EXISTS.getCode());
//        }
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("userId", userId);
//        map.put("productId", productId);
//        shopCarMapper.updateUserShopCartProduct(map);
//
//
//    }

//    @Override
//    public ShopCarAndProductDto findShopCarAndProductsByUserId(Long userId, String productId) {
//        Map<String, Object> maps = Maps.newHashMap();
//        maps.put("userId", userId);
//        maps.put("productId", productId);
//        return shopCarMapper.findShopCarAndProductsByUserId(maps);
//    }
}
