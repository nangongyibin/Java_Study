package com.ngyb.study.enumtest;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 13:01
 */
public class Main {

    public static void main(String[] args) {
        WeekDay weekDay = WeekDay.SunDay;
        WeekDay nextDay = weekDay.nextDay();
        nextDay.tostring();
        WeekDayNew monday = WeekDayNew.Monday;
    }
}
