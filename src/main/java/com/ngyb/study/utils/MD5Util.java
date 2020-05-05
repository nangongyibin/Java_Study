package com.ngyb.study.utils;

import java.io.FileInputStream;
import java.security.MessageDigest;

/**
 * 消息摘要工具类:核心类MessageDigest
 */
public class MD5Util {
    private static final String ALGORITHM = "MD5";

    public static void main(String[] args) {
        String input = "12345678";//明文
        String md5 = md5(input);
        System.out.println(md5);
        String md5File = md5File("apache-tomcat-9.0.1.zip");
        System.out.println("文件md5值=" + md5File);
    }

    public static String md5(String input) {
        try {
            //获取消息摘要对象
            MessageDigest md5 = MessageDigest.getInstance(ALGORITHM);
            byte[] digest = md5.digest(input.getBytes());
            System.out.println("MD5后长度=" + digest.length);
            String hex = HexUtils.toHex(digest);
            System.out.println("MD5转成16进制长度=" + hex.getBytes().length);
            //System.out.println(hex);
            return hex;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取文件md5值
     *
     * @return
     */
    public static String md5File(String filePath) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
            MessageDigest md5 = MessageDigest.getInstance(ALGORITHM);
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fis.read(buffer)) != -1) {
                md5.update(buffer, 0, len);
            }
            byte[] digest = md5.digest();
            System.out.println("md5文件长度=" + digest.length);
            //转成16进制
            String hex = HexUtils.toHex(digest);
            System.out.println("md5文件转成16进制长度=" + hex.getBytes().length);
            return hex;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(fis);
        }
        return null;
    }
}
