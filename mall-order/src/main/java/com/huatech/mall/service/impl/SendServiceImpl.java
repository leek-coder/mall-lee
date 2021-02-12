package com.huatech.mall.service.impl;

import com.huatech.mall.constants.ApiBaseConstants;
import com.huatech.mall.entity.order.Order;
import com.huatech.mall.service.ISendService;
import com.huatech.mall.utils.JsonUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author like
 * @date 2020-06-23 10:34 下午
 **/
@Service
public class SendServiceImpl implements ISendService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void asynOrder(Order order) {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.getHeaders().put("type", "asynOrder");
        messageProperties.getHeaders().put("desc", "秒杀商品");
        Message message = new Message(JsonUtils.toString(order).getBytes(), messageProperties);
        rabbitTemplate.convertAndSend(ApiBaseConstants.RabbitMqConfig.QUICK_ORDER_EXCHANGE, ApiBaseConstants.RabbitMqConfig.QUICK_ORDER_ROUTER_KEY, message);
    }
}