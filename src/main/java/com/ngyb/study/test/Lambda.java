package com.ngyb.study.test;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 09:32
 */
public class Lambda {
    public static void main(String[] args) {
        method1();
        method2();
    }

    public static void method1(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("南宫燚滨");
            }
        }).start();
    }

    public static void method2(){
        new Thread(()-> System.out.println("南宫燚滨")).start();
    }
}
