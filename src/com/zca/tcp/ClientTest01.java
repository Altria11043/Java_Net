package com.zca.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 创建客户端
 * 1. 建立连接 使用ServerSocket创建客户端, 需要指定服务器地址和端口
 * 2. 操作输入输出流
 * 3. 释放资源
 * @author Altria
 * @date: 2019/10/6 23:31
 */
public class ClientTest01 {
    public static void main(String[] args) throws IOException {
        // 1. 建立连接 使用ServerSocket创建客户端, 需要指定服务器地址和端口
        Socket client = new Socket("localhost", 8888);
        // 2. 操作输入输出流
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        String data = "你好";
        dos.writeUTF(data);
        dos.flush();
        // 3. 释放资源
        dos.close();
        client.close();
    }
}
