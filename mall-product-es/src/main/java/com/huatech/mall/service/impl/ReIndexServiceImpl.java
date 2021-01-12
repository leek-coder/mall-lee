package com.huatech.mall.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import com.huatech.mall.model.Book;
import com.huatech.mall.service.ElasticService;
import com.huatech.mall.service.ReIndexService;
import com.huatech.mall.service.ReadBookService;
import com.huatech.mall.service.RedisService;
import com.huatech.mall.util.RedisKey;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import lombok.extern.slf4j.Slf4j;

/**
 * @author like
 * @date 2021-01-10 9:02 下午
 **/

@Slf4j
@Service
public class ReIndexServiceImpl implements ReIndexService {

    @Resource
    RedisService redisService;
    @Resource
    ReadBookService bookService;
    @Resource
    ElasticService elasticService;

    @Override
    public boolean reIndexBooks() {
        log.info("开始对books索引进行全量重建");
        String updateCore = redisService.get(RedisKey.cache_keys("cores", "update"), String.class);
        if (StringUtils.isEmpty(updateCore)) {
            updateCore = "book1";
        }
        String currentCore = redisService.get(RedisKey.cache_keys("cores", "current"), String.class);
        if (StringUtils.isEmpty(currentCore)) {
            currentCore = "book";
        }
        log.info("当前备份的索引集合为{}，正在服务中的索引集合为{}", updateCore, currentCore);

        // 如果数据量达到上亿级那则需要引入大数据处理系统，hadoop，进行离线索引重建
        int total = bookService.getBookCount();
        int size = 100;
        int page = total / size;
        if (page > size) {
            page = size;
        }
        if (total % size != 0) {
            page++;
        }
        log.info("books数据库中记录为{}，按size={}，page={}", total, size, page);
        ThreadPoolExecutor executorService =
                new ThreadPoolExecutor(10, 100, 100L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000));
        for (int i = 1; i <= page; i++) {
            final int p = i;
            final String core = updateCore;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    List<Book> books = bookService.getPageList(p, size);
                    if (books != null && books.size() > 0) {
                        List<Map<String, Object>> datas = new ArrayList<Map<String, Object>>();
                        for (Book bookPd : books) {
                            Map<String, Object> map = new HashMap<String, Object>();
                            map.put("bookId", bookPd.getId());
                            map.put("bookName", bookPd.getName());
                            map.put("bookEnName", bookPd.getEnName());
                            map.put("author", bookPd.getAuthor());
                            map.put("imgUrl", bookPd.getImgUrl());
                            map.put("createTime", bookPd.getCreateTime().getTime());
                            map.put("status", bookPd.getStatus());
                            map.put("description", bookPd.getDescription());
                            map.put("price", bookPd.getPrice());
                            map.put("category", bookPd.getCategory());
                            map.put("commentNum", bookPd.getCommentNum());
                            datas.add(map);
                        }
                        elasticService.addBulkIn(datas, core, "_doc");
                        log.info("books的page={}索引重建成功", p);
                    }
                }
            });
        }
        try {
            executorService.shutdown();
            while (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                log.info("等待索引重建完成.....");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("对books索引全量重建完成,进行集合的切换");
        redisService.set(RedisKey.cache_keys("cores", "update"), currentCore);
        redisService.set(RedisKey.cache_keys("cores", "current"), updateCore);

        log.info("切换成功,当前备份的索引集合为{}，正在服务中的索引集合为{}", currentCore, updateCore);
        return true;
    }

}
