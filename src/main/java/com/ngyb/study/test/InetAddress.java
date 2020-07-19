package com.ngyb.study.test;

import java.net.UnknownHostException;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 09:56
 */
public class InetAddress {
    public static void main(String[] args) {
        try {
            java.net.InetAddress byName = java.net.InetAddress.getByName("192.168.0.100");
            String hostName = byName.getHostName();
            String hostAddress = byName.getHostAddress();
            System.out.println(hostName);
            System.out.println(hostAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
