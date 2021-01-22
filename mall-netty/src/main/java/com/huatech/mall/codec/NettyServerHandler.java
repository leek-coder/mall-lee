package com.huatech.mall.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
/**
 * @author like
 * @date 2021-01-13 10:14 下午
 **/
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //System.out.println("从客户端读取到String：" + msg.toString());
        //System.out.println("从客户端读取到Object：" + ((User)msg).toString());
        System.out.println("从客户端读取到Long：" + (Long)msg);
        //给客户端发回一个long数据
        ctx.writeAndFlush(2000L);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
