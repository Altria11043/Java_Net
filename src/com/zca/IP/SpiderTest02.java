package com.zca.IP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Altria
 * Date: 6/10/2019 上午 9:31
 */
public class SpiderTest02 {
    public static void main(String[] args) throws IOException {
        // 获取URL
        URL url = new URL("https://www.bilibili.com");
        // 下载资源
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:69.0) Gecko/20100101 Firefox/69.0");
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        String msg = null;
        while((msg=br.readLine())!=null){
            System.out.println(msg);
        }
        br.close();
    }
}
