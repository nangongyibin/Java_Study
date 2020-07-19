package com.ngyb.study.singleton;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 16:05
 */
public class Main {
    public static void main(String[] args) {
        Teacher t1 = Teacher.getInstance();
        Teacher t2 = Teacher.getInstance();
        System.out.println(t1 ==t2);
    }
}
