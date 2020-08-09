package com.ngyb.study.test.other;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 作者：南宫燚滨
 * 描述：文件下载
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/8/9 09:52
 */
public class FileDownLoad {

    public static void main(String[] args) throws IOException {
        String path = "http://it.nangongyibin.com:8080/resource/a.txt";
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("range", "bytes=0-");
        InputStream is = conn.getInputStream();
        int len = 0;
        byte[] buf = new byte[1024];
        String filename = path.substring(path.lastIndexOf("/") + 1);
        System.out.println(filename);
        FileOutputStream fos = new FileOutputStream(filename);
        while ((len = is.read(buf)) != -1) {
            fos.write(buf, 0, len);
        }
        is.close();
        fos.close();
    }
}
