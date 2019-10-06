package com.zca.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收端: 使用面向对象封装
 * 1. 使用DatagramSocket 指定端口, 创建接收端
 * 2. 准备容器, 封装成DatagramPacket包裹
 * 3. 阻塞式接收包裹reveive(DatagramPacket p)
 * 4. 分析数据
 *    byte[] getData()
 *           getLength()
 * 5. 释放资源
 * @author Altria
 * Date: 6/10/2019 下午 1:02
 */
public class TalkReceive implements Runnable {
    // 1. 使用DatagramSocket 指定端口, 创建接收端
    DatagramSocket socket = null;
    public TalkReceive(int port){
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        while(true){
            try {
                // 2. 准备容器, 封装成DatagramPacket包裹
                byte[] container = new byte[1024*60];
                DatagramPacket packet = new DatagramPacket(container, 0, container.length);
                // 3. 阻塞式接收包裹reveive(DatagramPacket p)
                socket.receive(packet);
                // 4. 分析数据
                byte[] datas = packet.getData();
                int len = datas.length;
                String msg = new String(datas, 0, len);
                System.out.println("对方说: " + msg);
                if (msg.equals("bye")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 释放资源
        socket.close();
    }
}
