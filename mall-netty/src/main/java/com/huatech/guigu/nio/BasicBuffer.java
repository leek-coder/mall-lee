package com.huatech.guigu.nio;

import java.io.FileOutputStream;
import java.nio.IntBuffer;

/**
 * @author like
 * @date 2021-01-25 2:39 下午
 **/
public class BasicBuffer {
    public static void main(String[] args) {

        IntBuffer intBuffer = IntBuffer.allocate(5);
        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i * 2);
            if (i == 4) {
                System.out.println("==========" + intBuffer.position() + "=========");
            }
        }

        intBuffer.flip();

        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }
}