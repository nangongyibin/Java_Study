package com.ngyb.study.udp;

import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 11:03
 */
public class Main {
    public static void main(String[] args) throws SocketException {
        DatagramSocket dss = new DatagramSocket();
        DatagramSocket dsr = new DatagramSocket(8888);
        SendRunnable sendRunnable = new SendRunnable(dss);
        ReceiveRunnable receiveRunnable = new ReceiveRunnable(dsr);
        Thread t1 = new Thread(sendRunnable);
        Thread t2 = new Thread(receiveRunnable);
        t1.start();
        t2.start();
    }
}
