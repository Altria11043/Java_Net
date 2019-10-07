package com.zca.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器
 * 1. 指定端口 使用ServerSocket创建服务器
 * 2. 阻塞式等待连接accept
 * 3. 操作: 输入输出流操作
 * 4. 释放资源
 * @author Altria
 * Date: 7/10/2019 上午 10:43
 */
public class FileServer {
    public static void main(String[] args) throws IOException {
        System.out.println("-----------客户端启动-----------");
        ServerSocket server = new ServerSocket(8888);
        Socket client = server.accept();
        System.out.println("一个客户端连接");
        // 接收图片
        InputStream is = new BufferedInputStream(client.getInputStream());
        OutputStream os = new BufferedOutputStream(new FileOutputStream("imgs/copy_24.jpg"));
        byte[] flush = new byte[1024*10];
        int len = -1;
        while((len=is.read(flush))!=-1){
            os.write(flush, 0, len);
        }
        os.flush();
        // 释放资源
        os.close();
        is.close();
        client.close();
    }
}
