package com.huatech.guigu.websocket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * TextWebSocketFrame类型 这个表示的文本帧(frame)
 *
 * @author like
 * @date 2021-01-28 5:01 下午
 **/

public class GuiGuChannelHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    /**
     * 用户记录和管理所有客户端的channel
     */
    private static final ChannelGroup users = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        //获取客户端传过来的消息
        System.out.println("服务器端收到消息:" + msg.text());
        String message = msg.text();
        ctx.channel().writeAndFlush(new TextWebSocketFrame("服务器时间" + LocalDateTime.now() + ":" + message));

    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        //获取当前的新上来的channel
        //id 表示唯一的值 LongText
        Channel channel = ctx.channel();
        System.out.println("handlerAdded:" + channel.id().asLongText());
        users.add(channel);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        //获取当前的来掉线channel
        Channel channel = ctx.channel();
        System.out.println("handlerRemoved:" + channel.id().asLongText());
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