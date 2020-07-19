package com.ngyb.study.tcp;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 10:31
 */
public class Send2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getByName("192.168.0.101"), 8888);
        FileInputStream fis = new FileInputStream("1.txt");
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = fis.read(buf)) != -1) {
            socket.getOutputStream().write(buf, 0, len);
        }
        fis.close();
        socket.close();
    }
}
