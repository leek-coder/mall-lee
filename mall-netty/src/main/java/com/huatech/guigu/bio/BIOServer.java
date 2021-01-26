package com.huatech.guigu.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author like
 * @date 2021-01-25 1:39 下午
 **/
public class BIOServer {

    /**
     * 声明一个线程池
     */
    static ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务启动成功");
        while (true) {
            final Socket socket = serverSocket.accept();
            //处理客户端请求
            executorService.execute(new ServiceHandler(socket));
        }
    }
}

class ServiceHandler implements Runnable {

    private Socket socket;

    public ServiceHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("处理客户端请求的线程为:"+Thread.currentThread().getName());
        System.out.println("收到一个客户端连接");
        byte[] bytes = new byte[1024];
        try {
            InputStream inputStream = this.socket.getInputStream();
            //循环获取客户端数据
            while (true) {
                //建立连接后，如果当前线程暂时没有数据可读，则线程阻塞在read操作上
                int len = inputStream.read(bytes);
                if (len != -1) {
                    String message = new String(bytes, 0, len);
                    System.out.println(message);
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (this.socket != null) {
                try {
                    this.socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}