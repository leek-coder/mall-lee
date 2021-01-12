package com.huatech.mall.service;


import com.huatech.mall.pojo.vo.ServerVO;
import com.jrx.common.response.ResponseResult;

/**
 * @author:leek
 */


public interface IServerService {
    /**
     * 创建云主机
     *
     * @param serverVO
     * @return
     */
    ResponseResult createServer(ServerVO serverVO);

}
