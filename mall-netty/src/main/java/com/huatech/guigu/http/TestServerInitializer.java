package com.huatech.guigu.http;

import com.huatech.guigu.websocket.ChannelHandler;
import com.huatech.guigu.websocket.GuiGuChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpClientUpgradeHandler;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

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
        //在HTTP上有一些数据流产生，有大有小，我们对其进行处理，我们需要使用netty对数据流写提供支持
        pipeline.addLast(new ChunkedWriteHandler());
        //说明
        // http数据在传输过程中是分段的，HttpObjectAggregator就是可以将多个段聚合起来
        //这就是为什么，当浏览器发生大量数据时，就会发出多次http请求
        //对HttpMessage进行聚合处理，聚合成request或者是response

        pipeline.addLast(new HttpObjectAggregator(1024 * 64));
        /**
         * 本handler会帮你处理一些繁重的工作
         * 会帮你处理握手动作,handskaking(close,ping,pong) ping+pong=心跳
         * 对于websocket来讲，都是以frame进行
         * 对于websocket，它的数据是以frame(帧)形式传递
         * WebSocketServerProtocolHandler核心功能将我们的http协议升级为websocket协议，保持长连接
         * 是通过一个状态码
         */

        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));

        //增加一个自定义的handler，处理业务逻辑
//        pipeline.addLast("myHttpHandler", new TestHttpServerHandler());
//        pipeline.addLast("webSocket", new ChannelHandler());
        pipeline.addLast("webSocket", new GuiGuChannelHandler());


    }
}