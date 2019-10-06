package com.zca.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 发送端: 使用面向对象封装
 * 1. 使用DatagramSocket 指定端口, 创建发送端
 * 2. 准备数据, 转换成字节数组
 * 3. 封装成DatagramPacket包裹, 需要指定目的地
 * 4. 发送包裹send(DatagramPacket p)
 * 5. 释放资源
 * @author Altria
 * Date: 6/10/2019 下午 1:01
 */
public class TalkSend implements Runnable{
    // 1. 使用DatagramSocket 指定端口, 创建发送端
    DatagramSocket send = null;
    // 窗口输入
    BufferedReader reader = null;

    InetSocketAddress address = null;

    public TalkSend(int port, String ToIP, int ToPort){
        try {
            send = new DatagramSocket(port);
            reader = new BufferedReader(new InputStreamReader(System.in));
            address = new InetSocketAddress(ToIP, ToPort);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true){
            try {
                // 2. 准备数据, 转换成字节数组
                String data = reader.readLine();
                byte[] datas = data.getBytes();
                // 3. 封装成DatagramPacket包裹, 需要指定目的地
                DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, address);
                // 4. 发送包裹send(DatagramPacket p)4. 发送包裹send(DatagramPacket p)
                send.receive(packet);
                if (data.equals("bye")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
