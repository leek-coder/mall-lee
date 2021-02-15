package com.huatech.mall.controller;

import com.huatech.mall.response.ResponseResult;
import com.huatech.mall.service.IUniqueIdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 获取全局唯一的id
 *
 * @author like
 * @date 2021-02-15 6:33 下午
 **/
@RestController
@RequestMapping(value = "/v1")
@Slf4j
public class UniqueIdController {

    @Autowired
    private IUniqueIdService uniqueIdService;

    @RequestMapping(value = "/id", method = RequestMethod.GET)
    public ResponseResult obtainId() {
        log.info("================生成数据库唯一主键================");
        Long key = uniqueIdService.generateKey();
        return ResponseResult.success(key);
    }
}