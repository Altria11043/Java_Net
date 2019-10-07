package com.zca.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟服务器接收
 * 1. 指定端口 使用ServerSocket创建服务器
 * 2. 阻塞式等待连接accept
 * 3. 操作: 输入输出流操作
 * 4. 释放资源
 * @author Altria
 * Date: 7/10/2019 上午 9:52
 */
public class LoginServer {
    public static void main(String[] args) throws IOException {
        //1. 指定端口 使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(8888);
        //2. 阻塞式等待连接accept
        Socket client = server.accept();
        //3. 操作: 输入输出流操作
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String datas = dis.readUTF();
        String[] dataArray = datas.split("&");
        String uname = null;
        String upwd = null;
        for(String info: dataArray){
            String[] userinfo = info.split(":");
            if (userinfo[0].equals("uname") && userinfo.length == 2){
                System.out.println("你的用户名为: " + userinfo[1]);
                uname = userinfo[1];
            }else if(userinfo[0].equals("upwd") && userinfo.length == 2){
                System.out.println("你的密码为: " + userinfo[1]);
                upwd = userinfo[1];
            }
        }
        // 这里对用户名和密码进行判断,并且对客户端输出信息
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        if (uname.equals("admin") && upwd.equals("123456")){
            dos.writeUTF("登入成功");
        }else{
            dos.writeUTF("登入失败");
        }
        dos.flush();
        //4. 释放资源
        dos.close();
        dis.close();
        client.close();

    }
}
