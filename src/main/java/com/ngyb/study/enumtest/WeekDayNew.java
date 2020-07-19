package com.ngyb.study.enumtest;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 13:03
 */
public enum WeekDayNew {
    Monday,
    Tuesday,
    Wednesday(1),
    Thursday,
    Friday,
    Saturday,
    Sunday;

    private WeekDayNew() {
        System.out.println("不带参数");
    }

    private WeekDayNew(int x){
        System.out.println("带参数"+x);
    }
}
