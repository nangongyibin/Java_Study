package com.ngyb.study.singleton;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 16:03
 */
public class Student {
    private static Student s = new Student();

    private Student(){

    }
    public synchronized static Student getInstance(){
        return s;
    }
}
