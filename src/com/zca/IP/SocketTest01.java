package com.zca.IP;

import java.net.InetSocketAddress;

/**
 * 端口
 * 1. 区分软件
 * 2. 2个字节 0-65535 UDP/TCP
 * 3. 同一个协议端口不能冲突
 * 4. 定义端口越大越好
 * InetSocketAddress
 * 1. 构造器
 * new InetSocketAddress(地址|域名, 端口)
 * 2. 方法
 * getAddress() // 获取域名加地址
 * getPort() // 获取端口
 * getHostName()
 * @author Altria
 * Date: 5/10/2019 下午 12:23
 */
public class SocketTest01 {
    public static void main(String[] args) {
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 8080);
        InetSocketAddress socketAddress2 = new InetSocketAddress("localhost", 9000);
        System.out.println(socketAddress.getHostName());
        System.out.println(socketAddress.getAddress());
        System.out.println(socketAddress2.getAddress());
        System.out.println(socketAddress2.getPort());
    }
}
