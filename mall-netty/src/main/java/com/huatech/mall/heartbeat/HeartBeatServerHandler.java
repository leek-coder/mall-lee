package com.huatech.mall.heartbeat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @author like
 * @date 2021-01-13 10:14 下午
 **/
public class HeartBeatServerHandler extends SimpleChannelInboundHandler<String> {

    int readIdleTimes = 0;

    private static final String HEART = "Heart";

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {
        System.out.println(" ====== > [server] message received : " + s);
        if (HEART.equals(s)) {
            ctx.channel().writeAndFlush("ok");
        } else {
            System.out.println(" 其他信息处理 ... ");
        }
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            String eventType = null;
            switch (event.state()) {
                case READER_IDLE:
                    eventType = "读空闲";
                    readIdleTimes++; // 读空闲的计数加1
                    break;
                case WRITER_IDLE:
                    eventType = "写空闲";
                    // 不处理
                    break;
                case ALL_IDLE:
                    eventType = "读写空闲";
                    // 不处理
                    break;
            }

            System.out.println(ctx.channel().remoteAddress() + "超时时间：" + eventType);
            if (readIdleTimes > 3) {
                System.out.println(" [server]读空闲超过3次，关闭连接，释放更多资源");
                ctx.channel().writeAndFlush("idle close");
                ctx.channel().close();
            }
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.err.println("=== " + ctx.channel().remoteAddress() + " is active ===");
    }
}