package com.ngyb.study.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 10:31
 */
public class SendClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        String str = "你好，南宫燚滨！！！";
        byte[] buf = str.getBytes();
        int length = buf.length;
        DatagramPacket dp = new DatagramPacket(buf, length, InetAddress.getByName("192.168.0.101"), 8888);
        ds.send(dp);
        ds.close();
    }
}
