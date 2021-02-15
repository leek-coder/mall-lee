package com.huatech.mall.service.impl;

import com.huatech.mall.service.IUniqueIdService;
import com.huatech.mall.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author like
 * @date 2021-02-15 6:35 下午
 **/

@Service
public class UniqueIdServiceImpl implements IUniqueIdService {

    @Autowired
    private RedisUtils redisUtils;

    @Value("${key.redis.prefix}")
    private  String keyRedisPrefix;

    @Value("${key.work.id}")
    private  String keyWorkId;

    private  static  final  Integer LENGTH  = 7;

    @Override
    public Long generateKey() {

        StringBuilder sb = new StringBuilder();

        String date =  new SimpleDateFormat("yyyyMMdd").format(new Date());
        String key = keyRedisPrefix + date;
        //增长值
        Long increment = null;
        if(redisUtils.hasKey(key)){
            increment = redisUtils.incrBy(key,1L);
        }else{
            increment = redisUtils.incrBy(key,1L);
            redisUtils.expire(key,24, TimeUnit.HOURS);
        }
        sb.append(date);
        sb.append(String.format("%03d", Integer.parseInt(keyWorkId)));
        String incrementStr = increment.toString();
        if (incrementStr.length() <= LENGTH) {
            sb.append(String.format("%07d", increment));
        } else {
            sb.append(incrementStr);
        }
        return Long.parseLong(sb.toString());
    }
}