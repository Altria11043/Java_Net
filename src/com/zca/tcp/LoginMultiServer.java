package com.zca.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器: 多客户端登入
 * 1. 指定端口 使用ServerSocket创建服务器
 * 2. 阻塞式等待连接accept
 * 3. 操作: 输入输出流操作
 * 4. 释放资源
 * @author Altria
 * Date: 7/10/2019 下午 12:13
 */
public class LoginMultiServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        boolean flag = true;
        int num = 0;
        while(flag){
            Socket client = server.accept();
            System.out.println((++num) + "个客户端连接服务器");
            new Thread(new TestChannel(client)).start();
        }
        server.close();
    }

    static class TestChannel implements Runnable{
        private Socket client;
        private DataInputStream dis;
        private DataOutputStream dos;
        public TestChannel(Socket client){
            this.client = client;
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
                release();
            }
        }
        // 接收数据
        private String receive(){
            String datas = null;
            try {
                datas = dis.readUTF();
                return datas;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        // 发送数据
        private void send(String msg){
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 释放资源
        private void release(){
            // 释放资源
            try {
                if (null != dos){
                    dos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (null!=dis){
                    dis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (null != client){
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void run() {
            String uname = null;
            String upwd = null;
            String[] dataArray = receive().split("&");
            for(String info:dataArray){
                String[] userInfo = info.split(":");
                if ("uname".equals(userInfo[0]) && userInfo.length == 2){
                    System.out.println("登入用户名: " + userInfo[1]);
                    uname = userInfo[1];
                }else if ("upwd".equals(userInfo[0]) && userInfo.length == 2){
                    System.out.println("登入密码: " + userInfo[1]);
                    upwd = userInfo[1];
                }
            }
            // 对登入信息进行判断并返回
            if ("admin".equals(uname) && "123456".equals(upwd)){
                send("登入成功");
            }else{
                send("登入失败, 用户名密码错误!!!!");
            }
            release();
        }


    }
}
