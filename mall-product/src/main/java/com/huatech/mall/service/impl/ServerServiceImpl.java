package com.huatech.mall.service.impl;

import com.huatech.mall.constants.ApiBaseConstants;
import com.huatech.mall.model.UcsSubscription;
import com.huatech.mall.pojo.vo.CurrentUser;
import com.huatech.mall.pojo.vo.ServerVO;
import com.huatech.mall.service.IServerService;
import com.huatech.mall.service.IUcsSubscriptionService;
import com.huatech.mall.utils.BaseResourceWrapper;
import com.huatech.mall.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author like
 * @date 2021-01-01 3:45 下午
 **/
@Service
@Slf4j
public class ServerServiceImpl implements IServerService {

    @Autowired
    private BaseResourceWrapper resourceWrapper;

    @Autowired
    private IUcsSubscriptionService ucsSubscriptionService;


    /**
     * 创建云主机
     *
     * @param serverVO
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult createServer(ServerVO serverVO) {
        //构建虚拟机主表信息
        UcsSubscription resourceServer = buildUcsSubscription(serverVO);
        //云主机资源描述信息入库
        saveMasterResource(resourceServer);
        return ResponseResult.success("");
    }

    /**
     * 构建主表实例
     *
     * @return
     */
    private UcsSubscription buildUcsSubscription(ServerVO serverVO) {
        CurrentUser currentUser = resourceWrapper.checkUserAuthority(serverVO.getProjectId(), serverVO.getRegionId(), serverVO.getTenantId());
        UcsSubscription ucsSubscription = resourceWrapper.buildUcsSubscription(serverVO);
        ucsSubscription.setInstanceName(serverVO.getInstanceName());
        ucsSubscription.setServiceType(ApiBaseConstants.SERVICE_TYPE);
        //设置实例id
        ucsSubscription.setInstanceId(1100L);
        ucsSubscription.setUserId(currentUser.getUserId().toString());
        ucsSubscription.setTenantId(currentUser.getTenantId());
        ucsSubscription.setUserName(currentUser.getUserName());
        ucsSubscription.setMasterTenantId(currentUser.getMasterTenantId());
        return ucsSubscription;
    }

    /**
     * 保存主表资源
     *
     * @param ucsSubscription
     */
    private void saveMasterResource(UcsSubscription ucsSubscription) {
        ucsSubscriptionService.save(ucsSubscription);
    }
}