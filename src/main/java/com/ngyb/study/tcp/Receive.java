package com.ngyb.study.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 10:32
 */
public class Receive {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        byte[] buf = new byte[1024];
        int length = 0;
        while ((length = is.read(buf))!=-1){
            System.out.println(new String(buf));
        }
    }
}
