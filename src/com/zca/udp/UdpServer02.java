package com.zca.udp;

import com.zca.utils.FileSwitch;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 这里接收发过来的图片
 * 接收端
 * 1. 使用DatagramSocket 指定端口, 创建接收端
 * 2. 准备容器, 封装成DatagramPacket包裹
 * 3. 阻塞式接收包裹reveive(DatagramPacket p)
 * 4. 分析数据
 *    byte[] getData()
 *           getLength()
 * 5. 释放资源
 * @author Altria
 * Date: 6/10/2019 上午 10:12
 */
public class UdpServer02 {
    public static void main(String[] args) throws IOException {
        System.out.println("接收方启动中");
        // 使用DatagramSocket 指定端口, 创建接收端
        DatagramSocket server = new DatagramSocket(9999);
        // 准备容器, 封装成DatagramPacket包裹
        byte[] container = new byte[1024 * 6];
        DatagramPacket packet = new DatagramPacket(container, 0, container.length);
        // 阻塞式接收包裹reveive(DatagramPacket p)
        server.receive(packet);
        // 分析数据
        byte[] datas = packet.getData();
        FileSwitch fileSwitch = new FileSwitch();
        fileSwitch.byteArrayToFile(datas, "01.jpg");
        // 释放资源
        server.close();
    }
}
