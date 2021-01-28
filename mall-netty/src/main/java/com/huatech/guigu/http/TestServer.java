package com.huatech.guigu.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author like
 * @date 2021-01-26 11:00 下午
 **/
public class TestServer {
    private static final int SIZE = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        //默认是cpu核数*2
        EventLoopGroup boss = new NioEventLoopGroup(1);
        EventLoopGroup worker = new NioEventLoopGroup(SIZE);
        try {
            //创建服务器的启动对象，配置参数
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            //使用链式编程方式进行设置
            //设置两个线程组
            serverBootstrap.group(boss, worker).
                    //使用NioServerSocketChannel作为服务器的通道实现
                            channel(NioServerSocketChannel.class).
                    //设置线程队列可连接的队列大小
                            option(ChannelOption.SO_BACKLOG, 1024).
                    //给我们的workerGroup的EventLoop设置处理器
                            childHandler(new TestServerInitializer());
            //绑定端口并且同步，生成一个channelFuture对象
            ChannelFuture cf = serverBootstrap.bind(8080).sync();
            //注册一个监听器，此处不是关闭服务器，而是"监听"关闭
            cf.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }
}