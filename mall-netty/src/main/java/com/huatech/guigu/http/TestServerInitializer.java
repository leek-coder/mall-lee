package com.huatech.guigu.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author like
 * @date 2021-01-26 11:01 下午
 **/
public class TestServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        //向管道加入处理器
        ChannelPipeline pipeline = ch.pipeline();
        //加入netty提供的httpServerCodec编解码器
        //是netty提供的处理http编解码器
        pipeline.addLast("myHttpServerCodec", new HttpServerCodec());
        //增加一个自定义的handler
        pipeline.addLast("myHttpHandler", new TestHttpServerHandler());
    }
}