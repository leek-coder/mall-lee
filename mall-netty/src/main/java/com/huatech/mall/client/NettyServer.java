package com.huatech.mall.client;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolver;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * @author like
 * @date 2021-01-13 10:14 下午
 **/
public class NettyServer {

    private static final int SIZE = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup(SIZE);
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(boss, worker).channel(NioServerSocketChannel.class).
                    option(ChannelOption.SO_BACKLOG, 1024).childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    //解码器
                    socketChannel.pipeline().addLast(new StringDecoder(CharsetUtil.UTF_8));
                    //编码器
                    socketChannel.pipeline().addLast(new StringEncoder(CharsetUtil.UTF_8));
                    //对象解码器
                    socketChannel.pipeline().addLast(new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));
                    socketChannel.pipeline().addLast(new NettyServerHandler());
                }
            });
            //绑定端口
            ChannelFuture cf = serverBootstrap.bind("127.0.0.1",9000).sync();
            //注册一个监听器，此处不是关闭服务器，而是"监听"关闭
            cf.channel().closeFuture().sync();
            System.out.println("netty server start=====");

        } catch (InterruptedException e) {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }
}