package com.ngyb.study.utils;

public class HexUtils {

    public static String toHex(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            int value = b & 0XFF;
            String hex = Integer.toHexString(value);//转成16进制字符串：0,1...9,A,..,F
            //System.out.println(hex);
            if (hex.length() == 1) {
                stringBuilder.append("0");
            }
            stringBuilder.append(hex);
        }
        return stringBuilder.toString();
    }
}
