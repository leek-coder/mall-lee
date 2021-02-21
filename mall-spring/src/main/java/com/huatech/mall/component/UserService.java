package com.huatech.mall.component;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author like
 * @date 2021-02-19 3:07 下午
 **/
@Service
public class UserService {

    @EventListener(classes = {ApplicationEvent.class})
    public void listen(ApplicationEvent event) {
        System.out.println("监听到的事件:" + event);

    }
}