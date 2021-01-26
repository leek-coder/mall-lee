package com.huatech.mall.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author like
 * @date 2021-01-13 10:14 下午
 **/
public class NettyClient {

    public static void main(String[] args) {
        //客户端需要一个事件循环组
        EventLoopGroup boss = new NioEventLoopGroup(1);
        try {
            //创建客户端启动对象
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(boss).channel(NioSocketChannel.class).
                    option(ChannelOption.SO_SNDBUF, 1024).
                    handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(new NettyClientHandler());
                }
            });
            System.out.println("===== netty client start=====");
            //启动客户端去连接服务器端
            ChannelFuture cf = bootstrap.connect("localhost", 9000).sync();
            //给关闭通道进行监听
            cf.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            boss.shutdownGracefully();
        }
    }
}