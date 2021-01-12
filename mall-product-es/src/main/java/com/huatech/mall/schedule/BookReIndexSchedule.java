package com.huatech.mall.schedule;

import javax.annotation.Resource;

import com.huatech.mall.service.ReIndexService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import lombok.extern.slf4j.Slf4j;

/**
 * @author like
 * @date 2021-01-10 9:02 下午
 **/

@Slf4j
@Component
public class BookReIndexSchedule {

	@Resource
	ReIndexService reIndexService;

	@Scheduled(cron = "0 0 0/1 * * ? ")
	public void reIndexBooks() {
		log.info("定时重建books索引启动");
		boolean flag = reIndexService.reIndexBooks();
		log.info("定时重建books索引完成，状态为{}", flag);
	}
}
