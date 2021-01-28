package com.huatech.guigu.websocket.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author like
 * @date 2021-01-28 2:13 下午
 **/
@Data
@AllArgsConstructor
public class ChatMessage implements Serializable {
    /**
     * 发送者id
     */
    private  String senderId;
    /**
     * 接受者id
     */
    private  String receiverId;
    /**
     * 消息
     */
    private  String message;
    /**
     * 消息id
     */
    private  String messageId;
}