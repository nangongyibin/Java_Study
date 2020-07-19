package com.ngyb.study.test;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 17:11
 */
public class classsoho {
    public static void main(String[] args) {
        try {
            String str = "你好，南宫燚滨！";
            Class clazz1 = str.getClass();
            Class  clazz2 = String.class;
            Class clazz3 = Class.forName("java.lang.String");
            System.out.println(clazz1 ==clazz2);
            System.out.println(clazz2 ==clazz3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
