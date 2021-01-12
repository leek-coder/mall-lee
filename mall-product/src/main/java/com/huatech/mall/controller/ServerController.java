package com.huatech.mall.controller;

import com.alibaba.fastjson.JSONObject;
import com.huatech.mall.model.UcsSubscription;
import com.huatech.mall.pojo.vo.ServerVO;
import com.huatech.mall.service.IServerService;
import com.huatech.mall.service.IUcsSubscriptionService;
import com.jrx.common.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 主机server控制器
 *
 * @author like
 * @date 2019-11-28 4:48 下午
 **/
@RestController
@RequestMapping(value = "/v1")
@Slf4j
public class ServerController {

    @Autowired
    private IServerService serverService;

    @Autowired
    private IUcsSubscriptionService ucsSubscriptionService;

    /**
     * 创建云主机
     *
     * @param serverVO
     * @return
     */
    @RequestMapping(value = "/servers", method = RequestMethod.POST)
    public ResponseResult servers(@RequestBody @Valid ServerVO serverVO) {
        log.info("=======创建云主机入参：" + JSONObject.toJSON(serverVO));
        ResponseResult resultInfo = serverService.createServer(serverVO);
        return resultInfo;
    }

    /**
     * 查询
     *
     * @param instanceId
     * @return
     */
    @RequestMapping(value = "/servers/{instanceId}", method = RequestMethod.GET)
    public ResponseResult detail(@PathVariable("instanceId") Long instanceId) {
        UcsSubscription model = ucsSubscriptionService.findByInstanceId(instanceId);
        return ResponseResult.success(model);
    }

}