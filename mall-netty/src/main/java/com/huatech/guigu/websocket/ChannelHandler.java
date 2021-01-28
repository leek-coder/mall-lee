package com.huatech.guigu.websocket;

import com.huatech.guigu.websocket.enums.MsgActionEnum;
import com.huatech.guigu.websocket.pojo.ChatMessage;
import com.huatech.guigu.websocket.pojo.DataContent;
import com.huatech.guigu.websocket.utils.JsonUtils;
import com.huatech.guigu.websocket.utils.UserChanelRel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author like
 * @date 2021-01-28 10:51 上午
 * 用于处理消息的handler
 * 由于它的传输数据的载体是frame，这个frame在netty中，使用也websocket专门处理文本对象的，
 * frame是消息的载体，此类叫TextWebSocketFrame
 **/

public class ChannelHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    /**
     * 用户记录和管理所有客户端的channel
     */
    private static final ChannelGroup users = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * //将数据刷新到客户端上
     * users.writeAndFlush(new TextWebSocketFrame("[服务器在:]" + LocalDateTime.now())
     * + "接收到的消息为:" + message
     * );
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        //获取客户端传过来的消息
        String message = msg.text();
        //1.获取客户端发来的消息
        DataContent dataContent = JsonUtils.jsonToPojo(message, DataContent.class);
        Integer action = dataContent.getAction();

        Channel channel = ctx.channel();
        //获取客户端发来的消息
        //判断消息类型，根据不同的类型处理不同的业务
        //2.判断消息类型，根据不同的类型来处理不同的业务
        if (action.equals(MsgActionEnum.CONNECT.type)) {
            //2.1 当websocket 第一次open的时候，初始化channel，把用的channel 和 userid 关联起来
            String senderId = dataContent.getChatMessage().getSenderId();
            UserChanelRel.put(senderId, channel);
        } else if (action.equals(MsgActionEnum.CHAT.type)) {
            //2.2 聊天类型的消息，把聊天记录保存到数据库，同时标记消息的签收状态[未签收]
            ChatMessage chatMessage = dataContent.getChatMessage();
            String msgContent = chatMessage.getMessage();
            String senderId = chatMessage.getSenderId();
            String receiverId = chatMessage.getReceiverId();
            //保存消息到数据库，并且标记为未签收
//            UserServices userServices = (UserServices) SpringUtil.getBean("userServicesImpl");
//            String msgId = userServices.saveMsg(chatMsg);
//            chatMessage.setMessageId(msgId);

            DataContent dataContentMsg = new DataContent();
            dataContentMsg.setChatMessage(chatMessage);
            //发送消息
            Channel receiverChannel = UserChanelRel.get(receiverId);
            if (receiverChannel == null) {
                //离线用户
            } else {
                //当receiverChannel 不为空的时候，从ChannelGroup 去查找对应的channel 是否存在
                Channel findChanel = users.find(receiverChannel.id());
                if (findChanel != null) {
                    //用户在线
                    receiverChannel.writeAndFlush(
                            new TextWebSocketFrame(
                                    JsonUtils.objectToJson(dataContentMsg)
                            )
                    );
                } else {
                    //离线用户
                }
            }
        } else if (action.equals(MsgActionEnum.SIGNED.type)) {
            //2.3 签收消息类型，针对具体的消息进行签收，修改数据库中对应消息的签收状态[已签收]
//            UserServices userServices = (UserServices) SpringUtil.getBean("userServicesImpl");
            //扩展字段在signed 类型消息中 ，代表需要去签收的消息id，逗号间隔
            String msgIdsStr = dataContent.getExtend();
            String[] msgsId = msgIdsStr.split(",");
            List<String> msgIdList = new ArrayList<>();
            for (String mid : msgsId) {
                if (StringUtils.isNotBlank(mid)) {
                    msgIdList.add(mid);
                }
            }
            if (msgIdList != null && !msgIdList.isEmpty() && msgIdList.size() > 0) {
                //批量签收
//                userServices.updateMsgSigned(msgIdList);
            }

        } else if (action.equals(MsgActionEnum.KEEPALIVE.type)) {
            //2.4 心跳类型的消息
            System.out.println("收到来自channel 为【" + channel + "】的心跳包");
        }
        /**
         *
         2.1 当websocket 第一次open的时候，初始化channel，把用的channel 和 userid 关联起来
         2.2 聊天类型的消息，把聊天记录保存到数据库，同时标记消息的签收状态[未签收]
         2.3 签收消息类型，针对具体的消息进行签收，修改数据库中对应消息的签收状态[已签收]
         2.4 心跳类型的消息
         */

    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        //获取当前的新上来的channel
        Channel channel = ctx.channel();
        users.add(channel);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        //获取当前的来掉线channel
        Channel channel = ctx.channel();
        users.remove(channel);
    }

    /**
     * 如果出现了异常
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        //如果发生了异常关闭连接，同时同group中移除
        ctx.channel().close();
        users.remove(ctx.channel());
    }
}