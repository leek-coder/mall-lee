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
        //创建BossGroup和WorkerGroup
        //说明：创建两个线程组BossGroup和WorkerGroup
        //boss是处理连接请求，真正和客户端业务处理会交给worker完成
        //两个线程组都是无限循环
        //BossGroup和WorkerGroup含有的子线程(NioEventLoop)的个数
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
                    //设置线程队列得到连接个数
                    option(ChannelOption.SO_BACKLOG, 1024).
                    //给我们的workerGroup的EventLoop设置处理器
                    childHandler(new ChannelInitializer<SocketChannel>() {
                        //给pipeline设置处理器
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
            //绑定端口并且同步，生成一个channelFuture对象
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