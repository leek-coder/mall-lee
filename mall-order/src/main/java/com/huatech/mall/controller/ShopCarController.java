package com.huatech.mall.controller;

import com.huatech.mall.request.ShopCartParam;
import com.huatech.mall.response.ResponseResult;
import com.huatech.mall.service.IShopCarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


/**
 * @Author leek
 * @Date 2020-05-11 上午9:56
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping("/api/mall/shopCar")
@Slf4j
public class ShopCarController {

    @Autowired
    private IShopCarService shopCarService;

    /**
     * 添加购物车
     *
     * @param shopCartParam
     * @param request
     * @return
     */
    @PostMapping(value = "/add")
    public ResponseResult addProductCart(@RequestBody @Valid ShopCartParam shopCartParam, HttpServletRequest request) {

//        shopCartParam.setUserId(getUserInfo(request));
        shopCartParam.setUserId(1L);
//        DispatcherServlet
        shopCarService.addShopCart(shopCartParam);
        return ResponseResult.success();

    }

//    /**
//     * 查询用户购物车数量
//     *
//     * @param request
//     * @return
//     */
//    @RequestMapping("/count")
//    public ResponseResult findUserShopProductNumbers(HttpServletRequest request) {
//        return ResponseResult.success(shopCarService.findUsersShopProductNums(getUserInfo(request)));
//
//    }

//    //获取购物车所有商品
//    @RequestMapping(value = "/all")
//    public ResponseResult findUserShopProductAll(HttpServletRequest request) {
//        List<ShopCarDto> shopCars = shopCarService.findUserShopAllProducts(userId);
//        return JsonResult.success(shopCars);
//
//    }
//    //删除用户购物车中的商品,逻辑删除,只是改变购物车商品状态
//
//    @RequestMapping(value = "/delete", method = RequestMethod.POST)
//    public ResponseResult deleteUserShopCartProduct(@RequestParam(value = "productId", required = true) String productId, HttpServletRequest request) {
//        Long userId = getUserId(request);
//        shopCarService.deleteUserShopCartProduct(userId, productId);
//        return JsonResult.success();
//    }

}
