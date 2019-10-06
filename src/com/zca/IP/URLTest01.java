package com.zca.IP;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL: 统一资源定位器, 互联网三大基石之一(html http), 区分资源
 * 1. 协议
 * 2. 域名, 计算机名
 * 3. 端口: 默认80
 * 4. 请求资源
 * @author Altria
 * Date: 5/10/2019 下午 12:35
 */
public class URLTest01 {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://www.bilibili.com/video/av30023103/?p=237");

        System.out.println("协议: " + url.getProtocol());
        System.out.println("域名|IP: " + url.getHost());
        System.out.println("端口: " + url.getPort());
        System.out.println("请求资源: " + url.getFile());
        System.out.println("请求资源: " + url.getPath());
    }
}
