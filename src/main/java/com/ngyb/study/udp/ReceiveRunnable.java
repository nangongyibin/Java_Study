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
public class ReceiveRunnable implements Runnable{
    private DatagramSocket ds;

    public ReceiveRunnable(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {
        try {
            byte[] buf = new byte[1024];
            int length = buf.length;
            while (true){
                DatagramPacket dp = new DatagramPacket(buf, length);
                ds.receive(dp);
                buf = dp.getData();
                System.out.println("ReceiveRunnable："+new String(buf));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
