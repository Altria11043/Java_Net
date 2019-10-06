package com.zca.IP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Altria
 * Date: 6/10/2019 上午 9:31
 */
public class SpiderTest01 {
    public static void main(String[] args) throws IOException {
        // 获取URL
        URL url = new URL("https://www.jd.com");
        // 下载资源
        InputStream is = url.openStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        String msg = null;
        while((msg=br.readLine())!=null){
            System.out.println(msg);
        }
        br.close();
    }
}
