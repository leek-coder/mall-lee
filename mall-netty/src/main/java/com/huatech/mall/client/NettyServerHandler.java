package com.huatech.mall.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.util.CharsetUtil;

/**
 * @author like
 * ChannelInboundHandler
 * 自定一个Handler，需要继承netty规定好的某个HandlerAdapter
 * 这时我们自定义的Handler，才能成为一个Handler
 * @date 2021-01-13 10:20 下午
 **/

public class NettyServerHandler extends ChannelInboundHandlerAdapter {


    /**
     * 读取数据的事件(这里可以读取客户端发送的消息)
     * 1:ChannelHandlerContext:上下文对象，含有管道，通道，地址等等
     * 2:msg:这个就是客户端发送的数据，默认是Object
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(Thread.currentThread().getName());
        System.out.println("server ctx=" + ctx);
        Channel channel = ctx.channel();
        ChannelPipeline pipeline = channel.pipeline();
        ChannelPipeline pipeline1 = ctx.pipeline();
        System.out.println(pipeline==pipeline1);
        //pipeline 本质是一个双向链表
        System.out.println("看看channel和pipeline的关系");
        //将msg转化成一个ByteBuf，ByteBuf是netty提供的，不是NIO提供的ByteBuffer
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("客户端发送的信息是:" + byteBuf.toString(CharsetUtil.UTF_8));
        System.out.println("客户端地址为:" + channel.remoteAddress());
    }

    /**
     * 数据读取完毕
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ByteBuf byteBuf = Unpooled.copiedBuffer("HelloClient".getBytes());
        //将数据写入缓存，并刷新，一般来讲，我们对这个发送的数据进行编码
        ctx.writeAndFlush(byteBuf);
    }

    /**
     * 处理异常，一般需要关闭通道
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("异常信息：" + cause.getMessage());
        ctx.close();
    }
}