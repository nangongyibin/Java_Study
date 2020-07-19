package com.ngyb.study.test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 09:09
 */
public class Exceptions {
    public static void main(String[] args) throws MalformedURLException, IllegalAccessException {
        //编译时异常
//        method1();
        //运行时异常
//        method2();
        //严重错误问题
        method3();
    }

    private static void method1() throws MalformedURLException {
        URL url = new URL("www.baidu.com");
    }

    public static void method2() throws IllegalAccessException {
        int i = 2;
        int j = 0;
        if (j ==0){
            throw new IllegalAccessException("j不能为0");
        }
        System.out.println(i/j);
    }

    private static void method3() {
        try {
            URL url = new URL("www.baidu.com");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
