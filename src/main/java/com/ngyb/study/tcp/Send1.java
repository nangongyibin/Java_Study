package com.ngyb.study.tcp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 10:31
 */
public class Send1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getByName("192.168.0.101"), 8888);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            while (str.equals("886")) {
                socket.close();
                return;
            }
            byte[] buf = str.getBytes();
            int length = buf.length;
            socket.getOutputStream().write(buf);
        }
    }
}
