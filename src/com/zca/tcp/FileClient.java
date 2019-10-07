package com.zca.tcp;

import java.io.*;
import java.net.Socket;

/**
 * 创建客户端
 * 1. 建立连接 使用ServerSocket创建客户端, 需要指定服务器地址和端口
 * 2. 操作输入输出流
 * 3. 释放资源
 * @author Altria
 * Date: 7/10/2019 上午 10:43
 */
public class FileClient {
    public static void main(String[] args) throws IOException {
        System.out.println("-----------服务器启动-----------");
        Socket client = new Socket("localhost" ,8888);
        // 文件操作
        InputStream is = new BufferedInputStream(new FileInputStream("imgs/24.jpg"));
        OutputStream os = new BufferedOutputStream(client.getOutputStream());
        byte[] flush = new byte[1024 * 10];
        int len = -1;
        while((len=is.read(flush))!=-1){
            os.write(flush, 0, len);
        }
        os.flush();
        // 释放资源
        os.close();
        is.close();
        client.close();
    }
}
