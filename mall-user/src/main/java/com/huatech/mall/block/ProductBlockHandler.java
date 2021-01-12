package com.huatech.mall.block;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author like
 * @date 2020-12-31 11:17 上午
 **/

public class ProductBlockHandler {
    private static Logger logger = LoggerFactory.getLogger(ProductBlockHandler.class);

    public static String sentinelProductSaveMethod(BlockException e) {
        logger.info("================");
        return "方法被流控了=========+++++";
    }
}