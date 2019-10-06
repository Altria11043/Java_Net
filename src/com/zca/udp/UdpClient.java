package com.zca.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
/**
 * 发送端
 * 1. 使用DatagramSocket 指定端口, 创建发送端
 * 2. 准备数据, 转换成字节数组
 * 3. 封装成DatagramPacket包裹, 需要指定目的地
 * 4. 发送包裹send(DatagramPacket p)
 * 5. 释放资源
 * @author Altria
 * Date: 6/10/2019 上午 10:12
 */
public class UdpClient {
    public static void main(String[] args) throws IOException {
        System.out.println("发送端启动中");
        // 使用DatagramSocket 指定端口, 创建发送端
        DatagramSocket client = new DatagramSocket(8888);
        // 准备数据, 转换成字节数组
        String data = "java编程";
        byte[] datas = data.getBytes();
        // 封装成DatagramPacket包裹, 需要指定目的地
        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length,
                new InetSocketAddress("localhost", 9999));
        // 发送包裹send(DatagramPacket p)
        client.send(packet);
        // 释放资源
        client.close();
    }
}
