package com.zca.tcp;

import java.io.*;
import java.net.Socket;

/**
 * 模拟登入
 * 1. 建立连接 使用ServerSocket创建客户端, 需要指定服务器地址和端口
 * 2. 操作输入输出流
 * 3. 释放资源
 * @author Altria
 * Date: 7/10/2019 上午 9:52
 */
public class LoginClient {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入用户名: ");
        String uname = br.readLine();
        System.out.print("请输入密码: ");
        String upwd = br.readLine();
        //1. 建立连接 使用ServerSocket创建客户端, 需要指定服务器地址和端口
        Socket client = new Socket("localhost", 8888);
        //2. 操作输入输出流
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF("uname:" + uname + "&" + "upwd:" + upwd);
        dos.flush();

        DataInputStream dis = new DataInputStream(client.getInputStream());
        String msg = dis.readUTF();
        System.out.println(msg);
        //3. 释放资源
        dos.close();
        client.close();
    }
}
