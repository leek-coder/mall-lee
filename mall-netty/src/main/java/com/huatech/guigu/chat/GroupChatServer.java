package com.huatech.guigu.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @author like
 * @date 2021-01-26 10:56 上午
 **/
public class GroupChatServer {
    /**
     * 定义相关的属性
     *
     * @param args
     */

    private Selector selector;
    private ServerSocketChannel listenChannel;
    private static final Integer PORT = 6667;

    /**
     * 构造器，初始化工作
     */
    public GroupChatServer() {
        try {
            //获取选择器
            selector = Selector.open();
            listenChannel = ServerSocketChannel.open();
            //绑定端口
            listenChannel.socket().bind(new InetSocketAddress(PORT));
            //设置非阻塞
            listenChannel.configureBlocking(false);
            //注册
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listen() {
        try {
            while (true) {
                int count = selector.select();
                //有事件处理
                if (count <= 0) {
                    System.out.println("服务端等待客户端连接。。。");
                }
                Iterator<SelectionKey> selectionKeys = selector.selectedKeys().iterator();
                while (selectionKeys.hasNext()) {
                    //获取key
                    SelectionKey key = selectionKeys.next();
                    handlerKey(key);
                    //当前的key删除，防止重复处理
                    selectionKeys.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handlerKey(SelectionKey key) {
        //监听到accept
        if (key.isAcceptable()) {
            SocketChannel socketChannel = null;
            try {
                socketChannel = listenChannel.accept();
                socketChannel.configureBlocking(false);
                //注册read事件
                socketChannel.register(selector, SelectionKey.OP_READ);
                System.out.println(socketChannel.getRemoteAddress() + "上线了......");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //通道发生read事件
        else if (key.isReadable()) {
            //专门写读的操作
            readData(key);
        }
    }

    /**
     * 读取客户端信息
     *
     * @param key
     */
    private void readData(SelectionKey key) {
        //取得关联的channel
        SocketChannel channel = null;
        try {
            channel = (SocketChannel) key.channel();
            //创建buffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int count = channel.read(buffer);
            if (count > 0) {
                //将缓冲区的数据转换成字符串
                String msg = new String(buffer.array());
                System.out.println("来自客户端的信息:" + msg);
                //向其他的客户端(去掉自己)转发消息
                sendInfoToOtherClients(msg, channel);
            }
        } catch (Exception e) {
            try {
                System.out.println(channel.getRemoteAddress() + "离线了");
                //取消注册
                key.cancel();
                //关闭通道
                channel.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * 转发消息给其他客户端
     *
     * @param msg
     * @param socketChannel
     */
    private void sendInfoToOtherClients(String msg, SocketChannel socketChannel) {
        System.out.println("服务器转发消息中");
        //遍历所有注册到selector上的SocketChannel，并排除自己
        for (SelectionKey key : selector.keys()) {
            //通过key，取出对应的SocketChannel
            SelectableChannel channel = key.channel();
            if (channel instanceof SocketChannel && channel != socketChannel) {
                //将mgs存储到buffer里
                SocketChannel socket = (SocketChannel)key.channel();
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                try {
                    //将buffer的数据写入通道
                    socket.write(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    public static void main(String[] args) {

        //创建服务器对象
        GroupChatServer chatServer = new GroupChatServer();
        //启动监听
        chatServer.listen();
    }

}