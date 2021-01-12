package com.huatech.mall.canal;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.CanalEntry.EntryType;
import com.alibaba.otter.canal.protocol.CanalEntry.EventType;
import com.alibaba.otter.canal.protocol.Message;
import com.google.protobuf.InvalidProtocolBufferException;

import com.huatech.mall.mapper.BookMapper;
import lombok.extern.slf4j.Slf4j;

import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author like
 * @date 2021-01-10 9:02 下午
 **/

/**
 * @author like
 * @date 2021-01-10 9:02 下午
 **/
//@Component
@Slf4j
public class CanalScheduling implements Runnable {


    @Autowired
    private CanalConnector canalConnector;

    @Autowired
    private BookMapper mapper;
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Override
    @Scheduled(fixedDelay = 100)
    public void run() {
        long batchId = -1;
        try {
//            一次取1000条数据
            int batchSize = 1000;
            Message message = canalConnector.getWithoutAck(batchSize);
            batchId = message.getId();
            List<CanalEntry.Entry> entries = message.getEntries();
            if (batchId != -1 && entries.size() > 0) {
                entries.forEach(entry -> {
                    if (entry.getEntryType() == CanalEntry.EntryType.ROWDATA) {
                        // 解析处理
                        publishCanalEvent(entry);
                    }
                });
            }
            //提交确认消费完毕
            canalConnector.ack(batchId);
        } catch (Exception e) {
            e.printStackTrace();
            //失败的话进行回滚
            canalConnector.rollback(batchId);
        }

    }

    private void publishCanalEvent(CanalEntry.Entry entry) {
        log.info("收到canal消息{}", entry.toString());
        if (entry.getEntryType() == EntryType.TRANSACTIONBEGIN || entry.getEntryType() == EntryType.TRANSACTIONEND) {
            return;
        }
        //拿出监听到的数据库
        String database = entry.getHeader().getSchemaName();
        //拿出有变更的数据表
        String table = entry.getHeader().getTableName();
        CanalEntry.RowChange change = null;
        try {
            change = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
            return;
        }
        EventType eventType = change.getEventType();
        change.getRowDatasList().forEach(rowData -> {

            List<CanalEntry.Column> columns = null;
            //对于es来说 只要关注 delete 和 update 还有insert
            if (eventType == EventType.DELETE) {
                //为什么这里是before
                columns = rowData.getBeforeColumnsList();
            } else {
                //其他的都素hiafter
                columns = rowData.getAfterColumnsList();
            }

            //解析成map 格式
            Map<String, Object> dataMap = parseColumnsToMap(columns);
            try {
                //真正的去改es
                indexES(dataMap, database, table, eventType);
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }

    Map<String, Object> parseColumnsToMap(List<CanalEntry.Column> columns) {
        Map<String, Object> jsonMap = new HashMap<>();
        columns.forEach(column -> {
            if (column == null) {
                return;
            }
            jsonMap.put(column.getName(), column.getValue());
        });
        return jsonMap;
    }

    private void indexES(Map<String, Object> dataMap, String database, String table, EventType eventType)
            throws IOException {
        try {
            if (eventType == EventType.DELETE) {
                log.info("删除索引Id={},type={},value={}", dataMap.get("id"), eventType.toString(), dataMap.toString());
                DeleteRequest deleteRequest = new DeleteRequest("book", "_doc", String.valueOf(dataMap.get("id")));
                restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
            } else {
                //这里又两种i方式,一种是直接拿canal过来的数据，还有一种就是拿主键id去查询。
//				List<Map<String, Object>> result = readBookPdMapper
//						.buildESQuery(new Integer((String) dataMap.get("id")));
                List<Map<String, Object>> result = new ArrayList<>();
                for (Map<String, Object> map : result) {
                    //如果是又业务关联的 这里就要写自己的业务代码
                    log.info("更新索引Id={},type={},value={}", map.get("id"), eventType.toString(), map.toString());

                    IndexRequest indexRequest = new IndexRequest("book", "_doc");
                    indexRequest.id(String.valueOf(map.get("id")));
                    indexRequest.source(map);
                    restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);

                    //处理多业务的思路
                    //1.监听的是商品表 变更时我会拿到商品id
                    //2.根据goodsId 去营销中心 订单中心 查询数据 会调用他们的接口
                    //3.组装数据 进入es
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
