package com.ngyb.study.note;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 19:34
 */
public @interface Note {
    int testInt();

    String testStr();

    Class testClass();

    TrafficLapm testEnum();

    Note2 testAnno();

    String[] testArr();
}
