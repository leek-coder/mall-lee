package com.huatech.mall.utils;

import com.huatech.mall.model.UcsSubscription;
import com.huatech.mall.pojo.vo.*;
import com.jrx.common.exception.ThrowCustomerException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 基础包装类
 *
 * @author like
 * @date 2020-08-25 7:54 下午
 **/
@Service
@Slf4j
public class BaseResourceWrapper {


    @Autowired
    private ThrowCustomerException customerException;

    /**
     * 构建 ucsSubscription
     *
     * @return
     */
    public UcsSubscription buildUcsSubscription(ServerVO serverVO) {
        UcsSubscription ucsSubscription = new UcsSubscription();
        ucsSubscription.setId(System.currentTimeMillis());
        Date date = new Date();
        //设置云服务商名称
        ucsSubscription.setCloudName(serverVO.getCloudName());
        //设置资源池id
        ucsSubscription.setRegionId(serverVO.getRegionId());
        //设置资源池名称
        ucsSubscription.setRegionName(serverVO.getRegionName());
        //设置资源池编码

        //设置可用域id
        ucsSubscription.setAzId(serverVO.getAzId().toString());
        //设置可用域名称
        ucsSubscription.setAzName(serverVO.getAzName());
        //设置可用域编码
        ucsSubscription.setAzCode(serverVO.getAzCode());
        // 设置取项目id
        ucsSubscription.setProjectId(serverVO.getProjectId());
        ucsSubscription.setCreateTime(date);
        ucsSubscription.setActiveTime(date);
        ucsSubscription.setInactiveTime(DateUtils.addYears(date, 20));
        ucsSubscription.setOptStatusChgTime(date);
        //设置状态
        ucsSubscription.setStatus("opening");
        return ucsSubscription;
    }


    /**
     * 校验权限接口
     */
    public CurrentUser checkUserAuthority(Long projectId, Long regionId, String tenantId) {
        CurrentUser currentUser = new CurrentUser();
        currentUser.setTenantId(projectId.toString());
        currentUser.setRegionId(regionId);
        currentUser.setMasterTenantId(tenantId);
        currentUser.setUserId(1000L);
        return currentUser;
    }
}