package com.huatech.mall.service.impl;

import com.huatech.mall.component.LocalCache;
import com.huatech.mall.component.ZkLock;
import com.huatech.mall.constants.ApiBaseConstants;
import com.huatech.mall.mapper.ProductMapper;
import com.huatech.mall.model.Product;
import com.huatech.mall.service.IProductService;
import com.huatech.mall.utils.JsonUtils;
import com.huatech.mall.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 商品远程调用服务实现
 *
 * @author like
 * @date 2020-06-22 3:34 下午
 **/
@Service
public class ProductServiceImpl implements IProductService {


    @Resource
    private ProductMapper productMapper;

    @Autowired
    private LocalCache localCache;

    @Autowired
    private RedisUtils redisUtils;

    /**
     * zk分布式锁
     */
    @Autowired
    private ZkLock zkLock;
    private String lockPath = "/load_db";

    @Override
    public Product findProductStore(String productId) {

        Product product = null;

        String productCacheKey = ApiBaseConstants.RedisKeyPrefix.PRODUCT_STOCK + "_" + productId;
        //一级缓存里取
        product = localCache.get(productCacheKey);
        if (product != null) {
            return product;
        }
        //先从缓存redis取（二级缓存）
        product = JsonUtils.toObjectBean(redisUtils.get(productCacheKey), Product.class);
        if (product != null) {
            localCache.setLocalCache(productCacheKey, product);
            return product;
        }
        if (zkLock.lock(lockPath + productId)) {
            product = productMapper.selectByPrimaryKey(productId);
            if (product == null) {
                return null;
            }
            //商品信息缓存到redis当中，缓存被动更新
            redisUtils.setEx(productCacheKey, JsonUtils.toString(product), 3600, TimeUnit.SECONDS);
            //缓存到一级缓存
            localCache.setLocalCache(productCacheKey, product);
            zkLock.unlock(lockPath + productId);
        } else {
            product = JsonUtils.toObjectBean(redisUtils.get(productCacheKey), Product.class);
            if (product != null) {
                localCache.setLocalCache(productCacheKey, product);
            }
        }
        return product;
    }

    @Override
    public List<Product> findProductList() {
        return productMapper.findProductList();
    }

    @Override
    public List<String> queryProductIds() {
        return productMapper.queryProductIds();
    }


}