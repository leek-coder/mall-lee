package com.huatech.guigu.websocket.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author like
 * @date 2021-01-28 2:12 下午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataContent implements Serializable {

    /**
     * 消息类型
     */
    private Integer action;
    private ChatMessage chatMessage;
    /**
     * 扩展
     */
    private String extend;


}