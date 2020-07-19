package com.ngyb.study.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 10:31
 */
public class SendClient1 {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            if (str.equals("886")){
                ds.close();
                return;
            }
            byte[] buf = str.getBytes();
            int length = buf.length;
            DatagramPacket dp = new DatagramPacket(buf, length, InetAddress.getByName("192.168.0.101"), 8888);
            ds.send(dp);
        }
    }
}
