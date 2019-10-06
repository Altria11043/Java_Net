package com.zca.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器
 * 1. 指定端口 使用ServerSocket创建服务器
 * 2. 阻塞式等待连接accept
 * 3. 操作: 输入输出流操作
 * 4. 释放资源
 * @author Altria
 * @date: 2019/10/6 23:25
 */
public class ServerTest01 {
    public static void main(String[] args) throws IOException {
        // 1. 指定端口 使用ServerSocket创建服务器
        ServerSocket socket = new ServerSocket(8888);
        // 2. 阻塞式等待连接accept
        Socket client = socket.accept();
        System.out.println("一个客户端建立了连接");
        // 3. 操作: 输入输出流操作
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String data = dis.readUTF();
        System.out.println(data);
        // 4. 释放资源
        dis.close();
        client.close();

        // 如果要关闭服务器就可以考虑添加socket.close()
        socket.close();
    }
}
