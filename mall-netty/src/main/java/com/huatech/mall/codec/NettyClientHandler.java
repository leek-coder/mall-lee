package com.huatech.mall.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
/**
 * @author like
 * @date 2021-01-13 10:14 下午
 **/
public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("收到服务器消息:" + msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MyClientHandler发送数据");
        //ctx.writeAndFlush("测试String编解码");
        //测试对象编解码
        //ctx.writeAndFlush(new User(1,"zhuge"));
        //测试自定义Long数据编解码器
        ctx.writeAndFlush(1000L);

    }
}
