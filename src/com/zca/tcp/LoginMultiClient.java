package com.zca.tcp;

import java.io.*;
import java.net.Socket;

/**
 * 创建客户端
 * 1. 建立连接 使用ServerSocket创建客户端, 需要指定服务器地址和端口
 * 2. 操作输入输出流
 * 3. 释放资源
 * @author Altria
 * Date: 7/10/2019 下午 12:13
 */
public class LoginMultiClient {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入用户名: ");
        String uname = br.readLine();
        System.out.print("请输入密码: ");
        String upwd = br.readLine();
        Socket client = new Socket("localhost", 8888);
        // 将登入信息传入服务器端
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF("uname:" + uname + "&upwd:" + upwd);
        dos.flush();

        // 接收服务器端的反馈
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String msg = dis.readUTF();
        System.out.println(msg);
        // 释放资源
        dis.close();
        dos.close();
        client.close();
        br.close();

    }
}
