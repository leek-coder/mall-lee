package com.huatech.mall.feign.fallback;

import com.huatech.mall.feign.IProductFeignService;
import com.huatech.mall.response.ProductRes;
import com.huatech.mall.response.ResponseResult;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author like
 * @date 2020-06-22 4:18 下午
 **/
@Component
public class ProductFeignFallBack implements IProductFeignService {


    @Override
    public ResponseResult<ProductRes> findProductStore(String productId) {
        return ResponseResult.failure("调用远程服务失败", -1);
    }

    @Override
    public ResponseResult<List<ProductRes>> list() {
        return ResponseResult.failure("调用远程服务失败", -1);
    }
}