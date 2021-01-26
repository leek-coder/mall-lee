package com.huatech.guigu.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;

/**
 * @author like
 * @date 2021-01-25 3:41 下午
 **/
public class FileChannel0 {
    public static void main(String[] args) throws IOException {
        String str = "Hello Netty!!!";
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/like/Desktop/1.txt");
        FileChannel channel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(str.getBytes());
        byteBuffer.clear();
        byteBuffer.flip();
        try {
            channel.write(byteBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileOutputStream.close();

    }
}