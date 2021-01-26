package com.huatech.guigu.chat;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author like
 * @date 2021-01-26 1:25 下午
 **/
public class GroupChatClient {
    /**
     * 定义相关的属性
     */
    private final String HOST = "127.0.0.1";
    private final Integer PORT = 6667;
    private Selector selector;
    private SocketChannel socketChannel;
    private String username;

    public GroupChatClient() {
        try {
            //打开一个selector
            selector = Selector.open();
            //连接服务器
            socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress(HOST, PORT));
            socketChannel.configureBlocking(false);
            //将channel注册到selector上
            socketChannel.register(selector, SelectionKey.OP_READ);
            username = socketChannel.getLocalAddress().toString().substring(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 向服务器发送消息
     *
     * @param info
     */
    public void sendInfo(String info) {
        info = username + "说:" + info;
        try {
            //发送消息
            socketChannel.write(ByteBuffer.wrap(info.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从服务器读取回复的消息
     */
    public void readInfo() {
        try {
            int count = selector.select();
            if (count > 0) {
                //有可用的通道
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    handler(key);
                    //当前的key删除，防止重复处理
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 处理通道数据
     *
     * @param key
     */
    private void handler(SelectionKey key) {
        if (key.isReadable()) {
            SocketChannel channel = (SocketChannel) key.channel();
            //得到一个Buffer
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            try {
                channel.read(byteBuffer);
                String msg = new String(byteBuffer.array());
                System.out.println(msg.trim());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //启动客户端
        GroupChatClient client = new GroupChatClient();
        //启动一个线程
        new Thread(() -> {
            while (true) {
                client.readInfo();
                try {
                    //每隔2s读取从服务器端可能发送的数据
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String msg = scanner.nextLine();
            client.sendInfo(msg);
        }


    }
}