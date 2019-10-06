package com.zca.IP;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP: 定位一个节点, 联网的设备
 * InetAddress:
 * 1.getLocalHost: 本机解析
 * 2.getByName: 根据域名DNS|IP地址 --> IP
 *
 * 成员方法
 * 1.getHostAddress: 返回地址
 * 2.getHostName:返回计算机名
 * @author Altria
 * Date: 5/10/2019 下午 12:06
 */
public class IPTest01 {
    public static void main(String[] args) throws UnknownHostException {
        // 使用getLocalHost方法创建InetAddress对象 本机
        InetAddress add = InetAddress.getLocalHost();
        System.out.println(add.getHostAddress()); // 返回本机ip地址
        System.out.println(add.getHostName()); // 输出计算机名

        // 根据域名得到InetAddress对象
        add = InetAddress.getByName("www.bilibili.com");
        System.out.println(add.getHostAddress()); // 返回B站服务器地址
        System.out.println(add.getHostName()); // 输出B站域名
    }
}
