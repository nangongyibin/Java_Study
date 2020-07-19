package com.ngyb.study.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 10:32
 */
public class ReceiveClient {

    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(8888);
        byte[] buf = new byte[1024];
        int length = buf.length;
        DatagramPacket dp = new DatagramPacket(buf, length);
        ds.receive(dp);
        buf = dp.getData();
        System.out.println(new String(buf));
        ds.close();
    }
}
