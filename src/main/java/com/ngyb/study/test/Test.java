package com.ngyb.study.test;

import java.util.Random;

public class Test {
    String name = "zhangsan";
    static int age = 18;
    long hahah = 123;
    String ages = "19";

    public static void main(String[] args){
        StringBuffer sb = new StringBuffer();
        sb.append("南宫燚滨");
        sb.append(12.3);
        sb.append(18);
        System.out.println(sb.toString());
        Integer in = age;
        age = in;
        System.out.println(in);
        System.out.println(age);
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            System.out.println(random.nextInt(6));
        }
    }
}
