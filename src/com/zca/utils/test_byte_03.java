package com.zca.utils;

import java.io.*;

/**
 * 1、图片读取到字节数组中
 * 2、字节数组写出到文件
 * @author Altria
 */
public class test_byte_03 {
    public static void main(String[] args) {
        byte[] datas = fileToByteArray("01.jpg");
        System.out.println(datas.length);
        byteArrayToFile(datas, "01_byte.jpg");
    }

    /**
     * 图片写入进字节数组
     * @param filePath
     * @return
     */
    public static byte[] fileToByteArray(String filePath){
        // 源与目的地
        File src = new File(filePath);

        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            is = new FileInputStream(src);
            baos = new ByteArrayOutputStream();

            // 操作
             byte[] flush = new byte[1024];
            int len = -1;
            while((len=is.read(flush))!=-1){
                baos.write(flush, 0, len);
            }
            baos.flush();
            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                if (null != is){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (null != baos){
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;

    }

    /**
     * 将字节数组转出成图片
     * @param src
     * @param filePath
     */
    public static void byteArrayToFile(byte[] src, String filePath){
        // 创建源
        File dest = new File(filePath);
        // 选择流
        InputStream is;
        OutputStream os = null;
        try {
            is = new ByteArrayInputStream(src);
            os = new FileOutputStream(dest);
            byte[] flush = new byte[1024];
            int len = -1;
            while((len=is.read(flush))!=-1){
                os.write(flush, 0, len);
            }
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(null != os){
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
