package com.huatech.mall.feign.fallback;

import com.huatech.mall.feign.IProductStoreFeignService;
import com.huatech.mall.response.ResponseResult;
import org.springframework.stereotype.Component;

/**
 * @author like
 * @date 2020-06-22 4:18 下午
 **/
@Component
public class ProductStoreFeignFallBack implements IProductStoreFeignService {

    @Override
    public ResponseResult<Integer> updateProductStock(String productId) {
        return ResponseResult.failure("调用远程服务失败", -1);
    }
}