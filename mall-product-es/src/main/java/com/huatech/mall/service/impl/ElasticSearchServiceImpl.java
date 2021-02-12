package com.huatech.mall.service.impl;

import com.huatech.mall.constants.ApiBaseConstants;
import com.huatech.mall.service.ElasticService;
import com.huatech.mall.enums.ApiErrorCodeEnum;
import com.huatech.mall.exception.ThrowCustomerException;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author like
 * @date 2021-01-12 9:19 上午
 **/
@Service
public class ElasticSearchServiceImpl implements ElasticService {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Autowired
    private ThrowCustomerException throwCustomerException;

    @Override
    public Boolean add(Map<String, Object> doc, String index, String type) throws Exception {
        return null;
    }

    @Override
    public Boolean adds(List<Map<String, Object>> docs) {
        return null;
    }

    @Override
    public Boolean addBulkIn(BulkRequest bulkRequest) {
        try {
            BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
            if (bulkResponse.status().getStatus() == ApiBaseConstants.BUILD_INDEX_SUCCESS) {
                return true;
            }
        } catch (IOException e) {
            throwCustomerException.throwException(ApiErrorCodeEnum.ERROR_BUILD_INDEX_FAIL);
        }
        return false;
    }

    @Override
    public Boolean delete(String index) {
        return null;
    }
}