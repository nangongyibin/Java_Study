package com.ngyb.study.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2019/11/27 16:54
 */
public class publicIP {


    /**
     * @return 获取公网IP
     */
        public String getPublicIp() {
            try {
                String path = "http://www.ip138.com/";// 要获得html页面内容的地址
                URL url = new URL(path);// 创建url对象
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();// 打开连接
//                conn.setRequestProperty("contentType", "GBK"); // 设置url中文参数编码
                conn.setConnectTimeout(5 * 1000);// 请求的时间
                conn.setRequestMethod("GET");// 请求方式
                InputStream inStream = conn.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(inStream, "GBK"));
                StringBuffer buffer = new StringBuffer();
                String line = "";
                // 读取获取到内容的最后一行,写入
                while ((line = in.readLine()) != null) {
                    buffer.append(line);
                }
                String str = buffer.toString();
                System.out.println(str);
                String ipString1 = str.substring(str.indexOf("["));
                // 获取你的IP是中间的[182.149.82.50]内容
                String ipsString2 = ipString1.substring(ipString1.indexOf("[") + 1,
                        ipString1.lastIndexOf("]"));
                // 返回公网IP值
                return ipsString2;
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage().toString());
                System.out.println("获取公网IP连接超时");
                return "连接超时";
            }
        }

        public static void main(String[] args)  {
            publicIP interIp=new publicIP();
            System.err.println(interIp.getPublicIp());
        }
}
