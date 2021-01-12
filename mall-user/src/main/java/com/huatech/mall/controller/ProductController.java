package com.huatech.mall.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.huatech.mall.block.ProductBlockHandler;
import com.huatech.mall.controller.service.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author like
 * @date 2020-12-31 10:55 上午
 **/
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private IProductService productService;

    /**
     * 初始化流控规则
     */
    @PostConstruct
    public void init() {
        List<FlowRule> flowRules = new ArrayList<>();
        FlowRule flowRule = new FlowRule();
        //设置流控规则QPS
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //设置受保护的资源
        flowRule.setResource("productSave");
        //设置受保护的阀值
        flowRule.setCount(1);
        flowRules.add(flowRule);
        //加入配置好的规则
        FlowRuleManager.loadRules(flowRules);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct() {
        Entry entry = null;
        try {
            entry = SphU.entry("productSave");
            productService.save("lllll");
        } catch (BlockException e) {
            logger.info("方法被流控了");
            return "方法被流控了";
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }
        return "Leek";
    }

    @RequestMapping(value = "/save1", method = RequestMethod.POST)
    @SentinelResource(value = "productSave", blockHandler = "helloSentinelMethod")
    public String saveProduct1() {
        productService.save("lllll");
        return "Leek";
    }

    @RequestMapping(value = "/save2", method = RequestMethod.POST)
    @SentinelResource(value = "productSave", blockHandler = "sentinelProductSaveMethod", blockHandlerClass = ProductBlockHandler.class
    )
    public String saveProduct2() {
        productService.save("lllll");
        return "Leek";
    }


    @GetMapping("/info")
    @SentinelResource(value = "info")
    public String productInfo(Integer id) {
        return "商品编号：" + id;
    }


}