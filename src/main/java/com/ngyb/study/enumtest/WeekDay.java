package com.ngyb.study.enumtest;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 12:53
 */
public abstract class WeekDay {
    private WeekDay(){

    }

    public abstract WeekDay nextDay();

    public static WeekDay Monday = new WeekDay() {

        @Override
        public WeekDay nextDay() {
            return SunDay;
        }
    };

    public static WeekDay SunDay = new WeekDay() {

        @Override
        public WeekDay nextDay() {
            return Monday;
        }
    };

    public void tostring(){
        if (this ==Monday){
            System.out.println("MonDay");
        }
        if (this ==SunDay){
            System.out.println("SunDay");
        }
    }
}
