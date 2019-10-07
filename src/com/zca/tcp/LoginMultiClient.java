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
        Socket client = new Socket("localhost", 8888);
        // 将登入信息传入服务器端
        new Send(client).send();
        String msg = new Receive(client).receive();
        System.out.println(msg);
        client.close();
    }

    // 将信息接传出和接受分开
    static class Send{
        DataOutputStream dos;
        BufferedReader br;
        String msg;
        public Send(Socket client){
            br = new BufferedReader(new InputStreamReader(System.in));
            this.msg = info();
            try {
                dos = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
                try {
                    if(null!=dos){
                        dos.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                try {
                    if (null!=br){
                        br.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        public void send(){
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String info(){
            try {
                System.out.print("请输入用户名: ");
                String uname = br.readLine();
                System.out.print("请输入密码: ");
                String upwd = br.readLine();
                return "uname:" + uname + "&upwd:" + upwd;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    static class Receive{
        DataInputStream dis;
        public Receive(Socket client){
            try {
                dis = new DataInputStream(client.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
                try {
                    if (null!=dis){
                        dis.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

        public String receive(){
            // 接收服务器端的反馈
            try {
                String msg = dis.readUTF();
                return msg;
            } catch (IOException e) {
                e.printStackTrace();
                try {
                    if (null!=dis){
                        dis.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            return null;
        }
    }
}
