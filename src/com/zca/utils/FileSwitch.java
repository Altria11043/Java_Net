package com.zca.utils;

import java.io.*;

/**
 * @author Altria
 * Date: 6/10/2019 上午 10:58
 */
public class FileSwitch {
    public byte[] fileToByteArray(String filePath){
        try(InputStream is = new FileInputStream(new File(filePath));
            ByteArrayOutputStream baos = new ByteArrayOutputStream()){
            byte[] flush = new byte[1024 * 6];
            int len = -1;
            while((len=is.read(flush))!= -1){
                baos.write(flush, 0, len);
            }
            baos.flush();
            return flush;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void byteArrayToFile(byte[] src, String filePath){
        try(InputStream is = new ByteArrayInputStream(src);
            OutputStream os = new FileOutputStream(new File(filePath))){
            byte[] flush = new byte[1024*6];
            int len = -1;
            while((len=is.read(flush))!=-1){
                os.write(flush, 0, len);
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
